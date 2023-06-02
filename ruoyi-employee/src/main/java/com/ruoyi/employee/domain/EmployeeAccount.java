package com.ruoyi.employee.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 账号对象 tb_employee_account
 *
 * @author Snow
 * @date 2023-05-31
 */
public class EmployeeAccount extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 自增ID */
    private Long id;

    /** 用户名 */
    @Excel(name = "用户名")
    private String username;

    /** 密码 */
    @Excel(name = "密码")
    private String password;

    /** 是否是管理员，1: 管理员, 2: 普通员工 */
    @Excel(name = "是否是管理员，1: 管理员, 2: 普通员工")
    private Integer isAdmin;

    /** 关联员工基础信息表的ID */
    @Excel(name = "关联员工基础信息表的ID")
    private Long employeeId;

    public EmployeeAccount(Long id, String username, String password, Integer isAdmin, Long employeeId) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.isAdmin = isAdmin;
        this.employeeId = employeeId;
    }

    public EmployeeAccount() {
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }
    public void setUsername(String username)
    {
        this.username = username;
    }

    public String getUsername()
    {
        return username;
    }
    public void setPassword(String password)
    {
        this.password = password;
    }

    public String getPassword()
    {
        return password;
    }
    public void setIsAdmin(Integer isAdmin)
    {
        this.isAdmin = isAdmin;
    }

    public Integer getIsAdmin()
    {
        return isAdmin;
    }
    public void setEmployeeId(Long employeeId)
    {
        this.employeeId = employeeId;
    }

    public Long getEmployeeId()
    {
        return employeeId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("username", getUsername())
                .append("password", getPassword())
                .append("isAdmin", getIsAdmin())
                .append("employeeId", getEmployeeId())
                .toString();
    }
}
