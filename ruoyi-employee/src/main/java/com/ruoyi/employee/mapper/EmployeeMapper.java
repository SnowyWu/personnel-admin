package com.ruoyi.employee.mapper;

import java.util.List;
import com.ruoyi.employee.domain.Employee;

/**
 * 员工Mapper接口
 * 
 * @author Snow
 * @date 2023-05-30
 */
public interface EmployeeMapper 
{
    /**
     * 查询员工
     * 
     * @param id 员工主键
     * @return 员工
     */
    public Employee selectEmployeeById(Long id);

    /**
     * 查询员工列表
     * 
     * @param employee 员工
     * @return 员工集合
     */
    public List<Employee> selectEmployeeList(Employee employee);

    /**
     * 新增员工
     * 
     * @param employee 员工
     * @return 结果
     */
    public int insertEmployee(Employee employee);

    /**
     * 修改员工
     * 
     * @param employee 员工
     * @return 结果
     */
    public int updateEmployee(Employee employee);

    /**
     * 删除员工
     * 
     * @param id 员工主键
     * @return 结果
     */
    public int deleteEmployeeById(Long id);

    /**
     * 批量删除员工
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteEmployeeByIds(Long[] ids);
}
