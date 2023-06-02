package com.ruoyi.recruitment.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 面试评价对象 tb_interview_evaluation
 *
 * @author Snow
 * @date 2023-05-31
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class InterviewEvaluation extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 评价编号 */
    private Long evaluationId;

    /**
     * 简历表id
     */
    private Long resumeId;

    /** 申请人姓名 */
    @Excel(name = "申请人姓名")
    private String applicantName;


    /** 面试担当 */
    @Excel(name = "面试担当")
    private String interviewer;

    /** 面试日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "面试日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date interviewDate;

    /** 面试结果 */
    @Excel(name = "面试结果")
    private Long interviewResult;

    /** 评价内容 */
    @Excel(name = "评价内容")
    private String evaluationContent;


}
