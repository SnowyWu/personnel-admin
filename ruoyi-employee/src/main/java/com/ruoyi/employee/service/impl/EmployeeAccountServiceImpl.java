package com.ruoyi.employee.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.employee.mapper.EmployeeAccountMapper;
import com.ruoyi.employee.domain.EmployeeAccount;
import com.ruoyi.employee.service.IEmployeeAccountService;

/**
 * 账号Service业务层处理
 *
 * @author Snow
 * @date 2023-05-31
 */
@Service
public class EmployeeAccountServiceImpl implements IEmployeeAccountService
{
    @Autowired
    private EmployeeAccountMapper employeeAccountMapper;

    /**
     * 查询账号
     *
     * @param id 账号主键
     * @return 账号
     */
    @Override
    public EmployeeAccount selectEmployeeAccountById(Long id)
    {
        return employeeAccountMapper.selectEmployeeAccountById(id);
    }

    /**
     * 查询账号列表
     *
     * @param employeeAccount 账号
     * @return 账号
     */
    @Override
    public List<EmployeeAccount> selectEmployeeAccountList(EmployeeAccount employeeAccount)
    {
        return employeeAccountMapper.selectEmployeeAccountList(employeeAccount);
    }

    /**
     * 新增账号
     *
     * @param employeeAccount 账号
     * @return 结果
     */
    @Override
    public int insertEmployeeAccount(EmployeeAccount employeeAccount)
    {
        return employeeAccountMapper.insertEmployeeAccount(employeeAccount);
    }

    /**
     * 修改账号
     *
     * @param employeeAccount 账号
     * @return 结果
     */
    @Override
    public int updateEmployeeAccount(EmployeeAccount employeeAccount)
    {
        return employeeAccountMapper.updateEmployeeAccount(employeeAccount);
    }

    /**
     * 批量删除账号
     *
     * @param ids 需要删除的账号主键
     * @return 结果
     */
    @Override
    public int deleteEmployeeAccountByIds(Long[] ids)
    {
        return employeeAccountMapper.deleteEmployeeAccountByIds(ids);
    }

    /**
     * 删除账号信息
     *
     * @param id 账号主键
     * @return 结果
     */
    @Override
    public int deleteEmployeeAccountById(Long id)
    {
        return employeeAccountMapper.deleteEmployeeAccountById(id);
    }
}
