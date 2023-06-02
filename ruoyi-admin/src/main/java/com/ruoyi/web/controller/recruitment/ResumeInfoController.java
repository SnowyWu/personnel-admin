package com.ruoyi.web.controller.recruitment;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.recruitment.domain.InterviewEvaluation;
import com.ruoyi.recruitment.mapper.InterviewEvaluationMapper;
import com.ruoyi.recruitment.service.IInterviewEvaluationService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.recruitment.domain.ResumeInfo;
import com.ruoyi.recruitment.service.IResumeInfoService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 简历信息Controller
 *
 * @author Snow
 * @date 2023-05-31
 */
@RestController
@RequestMapping("/recruitment/resume")
public class ResumeInfoController extends BaseController {
    @Autowired
    private IResumeInfoService resumeInfoService;

    @Autowired
    private IInterviewEvaluationService interviewEvaluationService;

    @Autowired
    private InterviewEvaluationMapper interviewEvaluationMapper;

    /**
     * 查询简历信息列表
     */
    @PreAuthorize("@ss.hasPermi('recruitment:resume:list')")
    @GetMapping("/list")
    public TableDataInfo list(ResumeInfo resumeInfo) {
        startPage();
        List<ResumeInfo> list = resumeInfoService.selectResumeInfoList(resumeInfo);
        return getDataTable(list);
    }

    /**
     * 导出简历信息列表
     */
    @PreAuthorize("@ss.hasPermi('recruitment:resume:export')")
    @Log(title = "简历信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, ResumeInfo resumeInfo) {
        List<ResumeInfo> list = resumeInfoService.selectResumeInfoList(resumeInfo);
        ExcelUtil<ResumeInfo> util = new ExcelUtil<ResumeInfo>(ResumeInfo.class);
        util.exportExcel(response, list, "简历信息数据");
    }

    /**
     * 获取简历信息详细信息
     */
    @PreAuthorize("@ss.hasPermi('recruitment:resume:query')")
    @GetMapping(value = "/{resumeId}")
    public AjaxResult getInfo(@PathVariable("resumeId") Long resumeId) {
        return success(resumeInfoService.selectResumeInfoByResumeId(resumeId));
    }

    /**
     * 新增简历信息
     */
    @PreAuthorize("@ss.hasPermi('recruitment:resume:add')")
    @Log(title = "简历信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ResumeInfo resumeInfo) {
        int ansRow = resumeInfoService.insertResumeInfo(resumeInfo);

        /**
         * 增加面试信息
         */
        InterviewEvaluation interviewEvaluation = new InterviewEvaluation(
                null,
                resumeInfo.getResumeId(),
                resumeInfo.getApplicantName(),
                null,
                null,
                (long) 2,
                null
        );
        System.out.println("interviewEvaluation = " + interviewEvaluation);
        interviewEvaluationService.insertInterviewEvaluation(interviewEvaluation);


        return toAjax(ansRow);
    }

    /**
     * 修改简历信息
     */
    @PreAuthorize("@ss.hasPermi('recruitment:resume:edit')")
    @Log(title = "简历信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ResumeInfo resumeInfo) {
        return toAjax(resumeInfoService.updateResumeInfo(resumeInfo));
    }

    /**
     * 删除简历信息
     */
    @PreAuthorize("@ss.hasPermi('recruitment:resume:remove')")
    @Log(title = "简历信息", businessType = BusinessType.DELETE)
    @DeleteMapping("/{resumeIds}")
    public AjaxResult remove(@PathVariable Long[] resumeIds) {
        /**
         * 删除面试信息,通过简历id列表
         */
        for (Long resumeId : resumeIds) {
            interviewEvaluationMapper.deleteInterviewEvaluationByResumeId(resumeId);
        }


        return toAjax(resumeInfoService.deleteResumeInfoByResumeIds(resumeIds));
    }
}
