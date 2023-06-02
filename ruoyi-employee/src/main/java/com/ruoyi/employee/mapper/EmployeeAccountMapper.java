package com.ruoyi.employee.mapper;

import java.util.List;

import com.ruoyi.employee.domain.AccountAndName;
import com.ruoyi.employee.domain.EmployeeAccount;

/**
 * 账号Mapper接口
 *
 * @author Snow
 * @date 2023-05-31
 */
public interface EmployeeAccountMapper
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
     * 查询账号姓名列表
     *
     * @param  employeeAccount 账号
     * @return 账号集合
     */
    public List<AccountAndName> selectEmployeeAndNameList(EmployeeAccount employeeAccount);

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
     * 删除账号
     *
     * @param id 账号主键
     * @return 结果
     */
    public int deleteEmployeeAccountById(Long id);

    /**
     * 批量删除账号
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteEmployeeAccountByIds(Long[] ids);

    /**
     * 通过员工信息id删除账号信息
     */
    public int deleteEmployeeAccountByEmployeeId(long id);


}
