package com.ruoyi.employee.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 员工对象 tb_employee
 * 
 * @author Snow
 * @date 2023-05-30
 */
public class Employee extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    private Long id;

    /** 姓名 */
    @Excel(name = "姓名")
    private String name;

    /** 性别 */
    @Excel(name = "性别")
    private Long sex;

    /** 手机号 */
    @Excel(name = "手机号")
    private String phone;

    /** 入职时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "入职时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date entryDate;

    /** 部门 */
    @Excel(name = "部门")
    private Long department;

    /** 职位 */
    @Excel(name = "职位")
    private String job;

    /** 基本工资 */
    @Excel(name = "基本工资")
    private Long salary;

    /** 身份证号 */
    @Excel(name = "身份证号")
    private String idNumber;

    /** 教育背景 */
    @Excel(name = "教育背景")
    private Long educational;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
    }
    public void setSex(Long sex) 
    {
        this.sex = sex;
    }

    public Long getSex() 
    {
        return sex;
    }
    public void setPhone(String phone) 
    {
        this.phone = phone;
    }

    public String getPhone() 
    {
        return phone;
    }
    public void setEntryDate(Date entryDate) 
    {
        this.entryDate = entryDate;
    }

    public Date getEntryDate() 
    {
        return entryDate;
    }
    public void setDepartment(Long department) 
    {
        this.department = department;
    }

    public Long getDepartment() 
    {
        return department;
    }
    public void setJob(String job) 
    {
        this.job = job;
    }

    public String getJob() 
    {
        return job;
    }
    public void setSalary(Long salary) 
    {
        this.salary = salary;
    }

    public Long getSalary() 
    {
        return salary;
    }
    public void setIdNumber(String idNumber) 
    {
        this.idNumber = idNumber;
    }

    public String getIdNumber() 
    {
        return idNumber;
    }
    public void setEducational(Long educational) 
    {
        this.educational = educational;
    }

    public Long getEducational() 
    {
        return educational;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("name", getName())
            .append("sex", getSex())
            .append("phone", getPhone())
            .append("entryDate", getEntryDate())
            .append("department", getDepartment())
            .append("job", getJob())
            .append("salary", getSalary())
            .append("idNumber", getIdNumber())
            .append("educational", getEducational())
            .toString();
    }
}
