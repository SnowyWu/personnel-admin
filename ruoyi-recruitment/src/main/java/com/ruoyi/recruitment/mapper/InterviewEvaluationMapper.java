package com.ruoyi.recruitment.mapper;

import java.util.List;
import com.ruoyi.recruitment.domain.InterviewEvaluation;

/**
 * 面试评价Mapper接口
 *
 * @author Snow
 * @date 2023-05-31
 */
public interface InterviewEvaluationMapper
{
    /**
     * 查询面试评价
     *
     * @param evaluationId 面试评价主键
     * @return 面试评价
     */
    public InterviewEvaluation selectInterviewEvaluationByEvaluationId(Long evaluationId);

    /**
     * 查询面试评价列表
     *
     * @param interviewEvaluation 面试评价
     * @return 面试评价集合
     */
    public List<InterviewEvaluation> selectInterviewEvaluationList(InterviewEvaluation interviewEvaluation);

    /**
     * 新增面试评价
     *
     * @param interviewEvaluation 面试评价
     * @return 结果
     */
    public int insertInterviewEvaluation(InterviewEvaluation interviewEvaluation);

    /**
     * 修改面试评价
     *
     * @param interviewEvaluation 面试评价
     * @return 结果
     */
    public int updateInterviewEvaluation(InterviewEvaluation interviewEvaluation);

    /**
     * 删除面试评价
     *
     * @param evaluationId 面试评价主键
     * @return 结果
     */
    public int deleteInterviewEvaluationByEvaluationId(Long evaluationId);

    /**
     * 删除面试评价
     *
     * @param evaluationId 通过简历id删除面试信息
     * @return 结果
     */
    public int deleteInterviewEvaluationByResumeId(Long resumeId);

    /**
     * 批量删除面试评价
     *
     * @param evaluationIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteInterviewEvaluationByEvaluationIds(Long[] evaluationIds);


}
