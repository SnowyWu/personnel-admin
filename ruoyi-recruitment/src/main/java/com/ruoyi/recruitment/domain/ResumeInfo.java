package com.ruoyi.recruitment.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 简历信息对象 tb_resume_info
 * 
 * @author Snow
 * @date 2023-05-31
 */
public class ResumeInfo extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 简历编号 */
    private Long resumeId;

    /** 应聘者姓名 */
    @Excel(name = "应聘者姓名")
    private String applicantName;

    /** 性别 */
    @Excel(name = "性别")
    private String gender;

    /** 联系方式 */
    @Excel(name = "联系方式")
    private String contactInfo;

    /** 政治面貌 */
    @Excel(name = "政治面貌")
    private String politicalStatus;

    /** 籍贯 */
    @Excel(name = "籍贯")
    private String nativePlace;

    /** 学历 */
    @Excel(name = "学历")
    private String education;

    /** 工作经历 */
    @Excel(name = "工作经历")
    private String workExperience;

    /** 能力特长 */
    @Excel(name = "能力特长")
    private String skills;

    /** 工作意向 */
    @Excel(name = "工作意向")
    private String jobIntentions;

    /** 提交日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "提交日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date submitDate;

    public void setResumeId(Long resumeId) 
    {
        this.resumeId = resumeId;
    }

    public Long getResumeId() 
    {
        return resumeId;
    }
    public void setApplicantName(String applicantName) 
    {
        this.applicantName = applicantName;
    }

    public String getApplicantName() 
    {
        return applicantName;
    }
    public void setGender(String gender) 
    {
        this.gender = gender;
    }

    public String getGender() 
    {
        return gender;
    }
    public void setContactInfo(String contactInfo) 
    {
        this.contactInfo = contactInfo;
    }

    public String getContactInfo() 
    {
        return contactInfo;
    }
    public void setPoliticalStatus(String politicalStatus) 
    {
        this.politicalStatus = politicalStatus;
    }

    public String getPoliticalStatus() 
    {
        return politicalStatus;
    }
    public void setNativePlace(String nativePlace) 
    {
        this.nativePlace = nativePlace;
    }

    public String getNativePlace() 
    {
        return nativePlace;
    }
    public void setEducation(String education) 
    {
        this.education = education;
    }

    public String getEducation() 
    {
        return education;
    }
    public void setWorkExperience(String workExperience) 
    {
        this.workExperience = workExperience;
    }

    public String getWorkExperience() 
    {
        return workExperience;
    }
    public void setSkills(String skills) 
    {
        this.skills = skills;
    }

    public String getSkills() 
    {
        return skills;
    }
    public void setJobIntentions(String jobIntentions) 
    {
        this.jobIntentions = jobIntentions;
    }

    public String getJobIntentions() 
    {
        return jobIntentions;
    }
    public void setSubmitDate(Date submitDate) 
    {
        this.submitDate = submitDate;
    }

    public Date getSubmitDate() 
    {
        return submitDate;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("resumeId", getResumeId())
            .append("applicantName", getApplicantName())
            .append("gender", getGender())
            .append("contactInfo", getContactInfo())
            .append("politicalStatus", getPoliticalStatus())
            .append("nativePlace", getNativePlace())
            .append("education", getEducation())
            .append("workExperience", getWorkExperience())
            .append("skills", getSkills())
            .append("jobIntentions", getJobIntentions())
            .append("submitDate", getSubmitDate())
            .toString();
    }
}
