package com.ruoyi.web.controller.employee;


import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.employee.domain.AccountAndName;
import com.ruoyi.employee.mapper.EmployeeAccountMapper;
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
import com.ruoyi.employee.domain.EmployeeAccount;
import com.ruoyi.employee.service.IEmployeeAccountService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 账号Controller
 *
 * @author Snow
 * @date 2023-05-31
 */
@RestController
@RequestMapping("/employee/account")
public class EmployeeAccountController extends BaseController
{
    @Autowired
    private IEmployeeAccountService employeeAccountService;

    @Autowired
    private EmployeeAccountMapper employeeAccountMapper;

    /**
     * 查询账号列表
     */
    @PreAuthorize("@ss.hasPermi('employee:account:list')")
    @GetMapping("/list")
    public TableDataInfo list(EmployeeAccount employeeAccount)
    {
        startPage();
        List<AccountAndName> accountAndNames = employeeAccountMapper.selectEmployeeAndNameList(employeeAccount);
//        List<EmployeeAccount> list = employeeAccountService.selectEmployeeAccountList(employeeAccount);
        return getDataTable(accountAndNames);
    }

    /**
     * 导出账号列表
     */
    @PreAuthorize("@ss.hasPermi('employee:account:export')")
    @Log(title = "账号", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, EmployeeAccount employeeAccount)
    {
        List<EmployeeAccount> list = employeeAccountService.selectEmployeeAccountList(employeeAccount);
        ExcelUtil<EmployeeAccount> util = new ExcelUtil<EmployeeAccount>(EmployeeAccount.class);
        util.exportExcel(response, list, "账号数据");
    }

    /**
     * 获取账号详细信息
     */
    @PreAuthorize("@ss.hasPermi('employee:account:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(employeeAccountService.selectEmployeeAccountById(id));
    }

    /**
     * 新增账号
     */
    @PreAuthorize("@ss.hasPermi('employee:account:add')")
    @Log(title = "账号", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody EmployeeAccount employeeAccount)
    {
        return toAjax(employeeAccountService.insertEmployeeAccount(employeeAccount));
    }

    /**
     * 修改账号
     */
    @PreAuthorize("@ss.hasPermi('employee:account:edit')")
    @Log(title = "账号", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody EmployeeAccount employeeAccount)
    {
        return toAjax(employeeAccountService.updateEmployeeAccount(employeeAccount));
    }

    /**
     * 删除账号
     */
    @PreAuthorize("@ss.hasPermi('employee:account:remove')")
    @Log(title = "账号", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(employeeAccountService.deleteEmployeeAccountByIds(ids));
    }
}
