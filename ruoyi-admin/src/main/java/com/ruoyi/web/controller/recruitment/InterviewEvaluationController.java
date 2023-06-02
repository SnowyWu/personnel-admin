package com.ruoyi.web.controller.recruitment;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
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
import com.ruoyi.recruitment.domain.InterviewEvaluation;
import com.ruoyi.recruitment.service.IInterviewEvaluationService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 面试评价Controller
 *
 * @author Snow
 * @date 2023-05-31
 */
@RestController
@RequestMapping("/recruitment/evaluation")
public class InterviewEvaluationController extends BaseController
{
    @Autowired
    private IInterviewEvaluationService interviewEvaluationService;

    /**
     * 查询面试评价列表
     */
    @PreAuthorize("@ss.hasPermi('recruitment:evaluation:list')")
    @GetMapping("/list")
    public TableDataInfo list(InterviewEvaluation interviewEvaluation)
    {
        startPage();
        List<InterviewEvaluation> list = interviewEvaluationService.selectInterviewEvaluationList(interviewEvaluation);
        return getDataTable(list);
    }

    /**
     * 导出面试评价列表
     */
    @PreAuthorize("@ss.hasPermi('recruitment:evaluation:export')")
    @Log(title = "面试评价", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, InterviewEvaluation interviewEvaluation)
    {
        List<InterviewEvaluation> list = interviewEvaluationService.selectInterviewEvaluationList(interviewEvaluation);
        ExcelUtil<InterviewEvaluation> util = new ExcelUtil<InterviewEvaluation>(InterviewEvaluation.class);
        util.exportExcel(response, list, "面试评价数据");
    }

    /**
     * 获取面试评价详细信息
     */
    @PreAuthorize("@ss.hasPermi('recruitment:evaluation:query')")
    @GetMapping(value = "/{evaluationId}")
    public AjaxResult getInfo(@PathVariable("evaluationId") Long evaluationId)
    {
        return success(interviewEvaluationService.selectInterviewEvaluationByEvaluationId(evaluationId));
    }

    /**
     * 新增面试评价
     */
    @PreAuthorize("@ss.hasPermi('recruitment:evaluation:add')")
    @Log(title = "面试评价", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody InterviewEvaluation interviewEvaluation)
    {
        return toAjax(interviewEvaluationService.insertInterviewEvaluation(interviewEvaluation));
    }

    /**
     * 修改面试评价
     */
    @PreAuthorize("@ss.hasPermi('recruitment:evaluation:edit')")
    @Log(title = "面试评价", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody InterviewEvaluation interviewEvaluation)
    {
        return toAjax(interviewEvaluationService.updateInterviewEvaluation(interviewEvaluation));
    }

    /**
     * 删除面试评价
     */
    @PreAuthorize("@ss.hasPermi('recruitment:evaluation:remove')")
    @Log(title = "面试评价", businessType = BusinessType.DELETE)
    @DeleteMapping("/{evaluationIds}")
    public AjaxResult remove(@PathVariable Long[] evaluationIds)
    {
        return toAjax(interviewEvaluationService.deleteInterviewEvaluationByEvaluationIds(evaluationIds));
    }
}
