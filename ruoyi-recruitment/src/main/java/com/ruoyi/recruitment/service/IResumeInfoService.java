package com.ruoyi.recruitment.service;

import java.util.List;
import com.ruoyi.recruitment.domain.ResumeInfo;

/**
 * 简历信息Service接口
 * 
 * @author Snow
 * @date 2023-05-31
 */
public interface IResumeInfoService 
{
    /**
     * 查询简历信息
     * 
     * @param resumeId 简历信息主键
     * @return 简历信息
     */
    public ResumeInfo selectResumeInfoByResumeId(Long resumeId);

    /**
     * 查询简历信息列表
     * 
     * @param resumeInfo 简历信息
     * @return 简历信息集合
     */
    public List<ResumeInfo> selectResumeInfoList(ResumeInfo resumeInfo);

    /**
     * 新增简历信息
     * 
     * @param resumeInfo 简历信息
     * @return 结果
     */
    public int insertResumeInfo(ResumeInfo resumeInfo);

    /**
     * 修改简历信息
     * 
     * @param resumeInfo 简历信息
     * @return 结果
     */
    public int updateResumeInfo(ResumeInfo resumeInfo);

    /**
     * 批量删除简历信息
     * 
     * @param resumeIds 需要删除的简历信息主键集合
     * @return 结果
     */
    public int deleteResumeInfoByResumeIds(Long[] resumeIds);

    /**
     * 删除简历信息信息
     * 
     * @param resumeId 简历信息主键
     * @return 结果
     */
    public int deleteResumeInfoByResumeId(Long resumeId);
}
