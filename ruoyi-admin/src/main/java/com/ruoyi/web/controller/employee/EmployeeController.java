package com.ruoyi.web.controller.employee;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.employee.domain.EmployeeAccount;
import com.ruoyi.employee.mapper.EmployeeAccountMapper;
import com.ruoyi.employee.service.IEmployeeAccountService;
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
import com.ruoyi.employee.domain.Employee;
import com.ruoyi.employee.service.IEmployeeService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 员工Controller
 *
 * @author Snow
 * @date 2023-05-30
 */
@RestController
@RequestMapping("/employee/employee")
public class EmployeeController extends BaseController {
    @Autowired
    private IEmployeeService employeeService;

    @Autowired
    private IEmployeeAccountService employeeAccountService;

    @Autowired
    private EmployeeAccountMapper employeeAccountMapper;

    /**
     * 查询员工列表
     */
    @PreAuthorize("@ss.hasPermi('employee:employee:list')")
    @GetMapping("/list")
    public TableDataInfo list(Employee employee) {
        startPage();
        List<Employee> list = employeeService.selectEmployeeList(employee);
        return getDataTable(list);
    }

    /**
     * 导出员工列表
     */
    @PreAuthorize("@ss.hasPermi('employee:employee:export')")
    @Log(title = "员工", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Employee employee) {
        List<Employee> list = employeeService.selectEmployeeList(employee);
        ExcelUtil<Employee> util = new ExcelUtil<Employee>(Employee.class);
        util.exportExcel(response, list, "员工数据");
    }

    /**
     * 获取员工详细信息
     */
    @PreAuthorize("@ss.hasPermi('employee:employee:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        return success(employeeService.selectEmployeeById(id));
    }

    /**
     * 新增员工
     */
    @PreAuthorize("@ss.hasPermi('employee:employee:add')")
    @Log(title = "员工", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Employee employee) {
        int ansRow = employeeService.insertEmployee(employee);


        return toAjax(ansRow);
    }

    /**
     * 修改员工
     */
    @PreAuthorize("@ss.hasPermi('employee:employee:edit')")
    @Log(title = "员工", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Employee employee) {
        return toAjax(employeeService.updateEmployee(employee));
    }

    /**
     * 删除员工
     */
    @PreAuthorize("@ss.hasPermi('employee:employee:remove')")
    @Log(title = "员工", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(employeeService.deleteEmployeeByIds(ids));
    }
}
