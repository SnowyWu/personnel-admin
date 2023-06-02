package com.ruoyi.recruitment.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.recruitment.mapper.InterviewEvaluationMapper;
import com.ruoyi.recruitment.domain.InterviewEvaluation;
import com.ruoyi.recruitment.service.IInterviewEvaluationService;

/**
 * 面试评价Service业务层处理
 *
 * @author Snow
 * @date 2023-05-31
 */
@Service
public class InterviewEvaluationServiceImpl implements IInterviewEvaluationService
{
    @Autowired
    private InterviewEvaluationMapper interviewEvaluationMapper;

    /**
     * 查询面试评价
     *
     * @param evaluationId 面试评价主键
     * @return 面试评价
     */
    @Override
    public InterviewEvaluation selectInterviewEvaluationByEvaluationId(Long evaluationId)
    {
        return interviewEvaluationMapper.selectInterviewEvaluationByEvaluationId(evaluationId);
    }

    /**
     * 查询面试评价列表
     *
     * @param interviewEvaluation 面试评价
     * @return 面试评价
     */
    @Override
    public List<InterviewEvaluation> selectInterviewEvaluationList(InterviewEvaluation interviewEvaluation)
    {
        return interviewEvaluationMapper.selectInterviewEvaluationList(interviewEvaluation);
    }

    /**
     * 新增面试评价
     *
     * @param interviewEvaluation 面试评价
     * @return 结果
     */
    @Override
    public int insertInterviewEvaluation(InterviewEvaluation interviewEvaluation)
    {
        return interviewEvaluationMapper.insertInterviewEvaluation(interviewEvaluation);
    }

    /**
     * 修改面试评价
     *
     * @param interviewEvaluation 面试评价
     * @return 结果
     */
    @Override
    public int updateInterviewEvaluation(InterviewEvaluation interviewEvaluation)
    {
        return interviewEvaluationMapper.updateInterviewEvaluation(interviewEvaluation);
    }

    /**
     * 批量删除面试评价
     *
     * @param evaluationIds 需要删除的面试评价主键
     * @return 结果
     */
    @Override
    public int deleteInterviewEvaluationByEvaluationIds(Long[] evaluationIds)
    {
        return interviewEvaluationMapper.deleteInterviewEvaluationByEvaluationIds(evaluationIds);
    }

    /**
     * 删除面试评价信息
     *
     * @param evaluationId 面试评价主键
     * @return 结果
     */
    @Override
    public int deleteInterviewEvaluationByEvaluationId(Long evaluationId)
    {
        return interviewEvaluationMapper.deleteInterviewEvaluationByEvaluationId(evaluationId);
    }
}
