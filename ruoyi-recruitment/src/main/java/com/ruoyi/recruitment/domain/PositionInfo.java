package com.ruoyi.recruitment.domain;

import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 职位信息对象 tb_position_info
 * 
 * @author Snow
 * @date 2023-05-31
 */
public class PositionInfo extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 职位编号 */
    private Long positionId;

    /** 职位名称 */
    @Excel(name = "职位名称")
    private String positionName;

    /** 工作职责 */
    @Excel(name = "工作职责")
    private String jobResponsibility;

    /** 任职要求 */
    @Excel(name = "任职要求")
    private String jobRequirements;

    /** 工作地点 */
    @Excel(name = "工作地点")
    private String location;

    /** 薪资待遇 */
    @Excel(name = "薪资待遇")
    private BigDecimal salary;

    /** 发布日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "发布日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date publishDate;

    /** 截止日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "截止日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date deadline;

    public void setPositionId(Long positionId) 
    {
        this.positionId = positionId;
    }

    public Long getPositionId() 
    {
        return positionId;
    }
    public void setPositionName(String positionName) 
    {
        this.positionName = positionName;
    }

    public String getPositionName() 
    {
        return positionName;
    }
    public void setJobResponsibility(String jobResponsibility) 
    {
        this.jobResponsibility = jobResponsibility;
    }

    public String getJobResponsibility() 
    {
        return jobResponsibility;
    }
    public void setJobRequirements(String jobRequirements) 
    {
        this.jobRequirements = jobRequirements;
    }

    public String getJobRequirements() 
    {
        return jobRequirements;
    }
    public void setLocation(String location) 
    {
        this.location = location;
    }

    public String getLocation() 
    {
        return location;
    }
    public void setSalary(BigDecimal salary) 
    {
        this.salary = salary;
    }

    public BigDecimal getSalary() 
    {
        return salary;
    }
    public void setPublishDate(Date publishDate) 
    {
        this.publishDate = publishDate;
    }

    public Date getPublishDate() 
    {
        return publishDate;
    }
    public void setDeadline(Date deadline) 
    {
        this.deadline = deadline;
    }

    public Date getDeadline() 
    {
        return deadline;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("positionId", getPositionId())
            .append("positionName", getPositionName())
            .append("jobResponsibility", getJobResponsibility())
            .append("jobRequirements", getJobRequirements())
            .append("location", getLocation())
            .append("salary", getSalary())
            .append("publishDate", getPublishDate())
            .append("deadline", getDeadline())
            .toString();
    }
}
