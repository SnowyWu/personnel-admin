package com.ruoyi.recruitment.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.recruitment.mapper.ResumeInfoMapper;
import com.ruoyi.recruitment.domain.ResumeInfo;
import com.ruoyi.recruitment.service.IResumeInfoService;

/**
 * 简历信息Service业务层处理
 * 
 * @author Snow
 * @date 2023-05-31
 */
@Service
public class ResumeInfoServiceImpl implements IResumeInfoService 
{
    @Autowired
    private ResumeInfoMapper resumeInfoMapper;

    /**
     * 查询简历信息
     * 
     * @param resumeId 简历信息主键
     * @return 简历信息
     */
    @Override
    public ResumeInfo selectResumeInfoByResumeId(Long resumeId)
    {
        return resumeInfoMapper.selectResumeInfoByResumeId(resumeId);
    }

    /**
     * 查询简历信息列表
     * 
     * @param resumeInfo 简历信息
     * @return 简历信息
     */
    @Override
    public List<ResumeInfo> selectResumeInfoList(ResumeInfo resumeInfo)
    {
        return resumeInfoMapper.selectResumeInfoList(resumeInfo);
    }

    /**
     * 新增简历信息
     * 
     * @param resumeInfo 简历信息
     * @return 结果
     */
    @Override
    public int insertResumeInfo(ResumeInfo resumeInfo)
    {
        return resumeInfoMapper.insertResumeInfo(resumeInfo);
    }

    /**
     * 修改简历信息
     * 
     * @param resumeInfo 简历信息
     * @return 结果
     */
    @Override
    public int updateResumeInfo(ResumeInfo resumeInfo)
    {
        return resumeInfoMapper.updateResumeInfo(resumeInfo);
    }

    /**
     * 批量删除简历信息
     * 
     * @param resumeIds 需要删除的简历信息主键
     * @return 结果
     */
    @Override
    public int deleteResumeInfoByResumeIds(Long[] resumeIds)
    {
        return resumeInfoMapper.deleteResumeInfoByResumeIds(resumeIds);
    }

    /**
     * 删除简历信息信息
     * 
     * @param resumeId 简历信息主键
     * @return 结果
     */
    @Override
    public int deleteResumeInfoByResumeId(Long resumeId)
    {
        return resumeInfoMapper.deleteResumeInfoByResumeId(resumeId);
    }
}
