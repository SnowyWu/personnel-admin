package com.ruoyi.recruitment.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.recruitment.mapper.PositionInfoMapper;
import com.ruoyi.recruitment.domain.PositionInfo;
import com.ruoyi.recruitment.service.IPositionInfoService;

/**
 * 职位信息Service业务层处理
 * 
 * @author Snow
 * @date 2023-05-31
 */
@Service
public class PositionInfoServiceImpl implements IPositionInfoService 
{
    @Autowired
    private PositionInfoMapper positionInfoMapper;

    /**
     * 查询职位信息
     * 
     * @param positionId 职位信息主键
     * @return 职位信息
     */
    @Override
    public PositionInfo selectPositionInfoByPositionId(Long positionId)
    {
        return positionInfoMapper.selectPositionInfoByPositionId(positionId);
    }

    /**
     * 查询职位信息列表
     * 
     * @param positionInfo 职位信息
     * @return 职位信息
     */
    @Override
    public List<PositionInfo> selectPositionInfoList(PositionInfo positionInfo)
    {
        return positionInfoMapper.selectPositionInfoList(positionInfo);
    }

    /**
     * 新增职位信息
     * 
     * @param positionInfo 职位信息
     * @return 结果
     */
    @Override
    public int insertPositionInfo(PositionInfo positionInfo)
    {
        return positionInfoMapper.insertPositionInfo(positionInfo);
    }

    /**
     * 修改职位信息
     * 
     * @param positionInfo 职位信息
     * @return 结果
     */
    @Override
    public int updatePositionInfo(PositionInfo positionInfo)
    {
        return positionInfoMapper.updatePositionInfo(positionInfo);
    }

    /**
     * 批量删除职位信息
     * 
     * @param positionIds 需要删除的职位信息主键
     * @return 结果
     */
    @Override
    public int deletePositionInfoByPositionIds(Long[] positionIds)
    {
        return positionInfoMapper.deletePositionInfoByPositionIds(positionIds);
    }

    /**
     * 删除职位信息信息
     * 
     * @param positionId 职位信息主键
     * @return 结果
     */
    @Override
    public int deletePositionInfoByPositionId(Long positionId)
    {
        return positionInfoMapper.deletePositionInfoByPositionId(positionId);
    }
}
