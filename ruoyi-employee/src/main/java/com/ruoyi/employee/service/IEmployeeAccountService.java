package com.ruoyi.employee.service;

import java.util.List;
import com.ruoyi.employee.domain.EmployeeAccount;

/**
 * 账号Service接口
 *
 * @author Snow
 * @date 2023-05-31
 */
public interface IEmployeeAccountService
{
    /**
     * 查询账号
     *
     * @param id 账号主键
     * @return 账号
     */
    public EmployeeAccount selectEmployeeAccountById(Long id);

    /**
     * 查询账号列表
     *
     * @param employeeAccount 账号
     * @return 账号集合
     */
    public List<EmployeeAccount> selectEmployeeAccountList(EmployeeAccount employeeAccount);

    /**
     * 新增账号
     *
     * @param employeeAccount 账号
     * @return 结果
     */
    public int insertEmployeeAccount(EmployeeAccount employeeAccount);

    /**
     * 修改账号
     *
     * @param employeeAccount 账号
     * @return 结果
     */
    public int updateEmployeeAccount(EmployeeAccount employeeAccount);

    /**
     * 批量删除账号
     *
     * @param ids 需要删除的账号主键集合
     * @return 结果
     */
    public int deleteEmployeeAccountByIds(Long[] ids);

    /**
     * 删除账号信息
     *
     * @param id 账号主键
     * @return 结果
     */
    public int deleteEmployeeAccountById(Long id);
}
