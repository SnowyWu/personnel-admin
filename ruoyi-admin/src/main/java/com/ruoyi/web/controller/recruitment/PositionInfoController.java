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
import com.ruoyi.recruitment.domain.PositionInfo;
import com.ruoyi.recruitment.service.IPositionInfoService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 职位信息Controller
 *
 * @author Snow
 * @date 2023-05-31
 */
@RestController
@RequestMapping("/recruitment/jobInformation")
public class PositionInfoController extends BaseController
{
    @Autowired
    private IPositionInfoService positionInfoService;

    /**
     * 查询职位信息列表
     */
    @PreAuthorize("@ss.hasPermi('recruitment:jobInformation:list')")
    @GetMapping("/list")
    public TableDataInfo list(PositionInfo positionInfo)
    {
        startPage();
        List<PositionInfo> list = positionInfoService.selectPositionInfoList(positionInfo);
        return getDataTable(list);
    }

    /**
     * 导出职位信息列表
     */
    @PreAuthorize("@ss.hasPermi('recruitment:jobInformation:export')")
    @Log(title = "职位信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, PositionInfo positionInfo)
    {
        List<PositionInfo> list = positionInfoService.selectPositionInfoList(positionInfo);
        ExcelUtil<PositionInfo> util = new ExcelUtil<PositionInfo>(PositionInfo.class);
        util.exportExcel(response, list, "职位信息数据");
    }

    /**
     * 获取职位信息详细信息
     */
    @PreAuthorize("@ss.hasPermi('recruitment:jobInformation:query')")
    @GetMapping(value = "/{positionId}")
    public AjaxResult getInfo(@PathVariable("positionId") Long positionId)
    {
        return success(positionInfoService.selectPositionInfoByPositionId(positionId));
    }

    /**
     * 新增职位信息
     */
    @PreAuthorize("@ss.hasPermi('recruitment:jobInformation:add')")
    @Log(title = "职位信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody PositionInfo positionInfo)
    {
        return toAjax(positionInfoService.insertPositionInfo(positionInfo));
    }

    /**
     * 修改职位信息
     */
    @PreAuthorize("@ss.hasPermi('recruitment:jobInformation:edit')")
    @Log(title = "职位信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody PositionInfo positionInfo)
    {
        return toAjax(positionInfoService.updatePositionInfo(positionInfo));
    }

    /**
     * 删除职位信息
     */
    @PreAuthorize("@ss.hasPermi('recruitment:jobInformation:remove')")
    @Log(title = "职位信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{positionIds}")
    public AjaxResult remove(@PathVariable Long[] positionIds)
    {
        return toAjax(positionInfoService.deletePositionInfoByPositionIds(positionIds));
    }
}
