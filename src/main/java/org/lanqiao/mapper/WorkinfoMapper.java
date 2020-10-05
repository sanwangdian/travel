package org.lanqiao.mapper;

import org.lanqiao.entity.Workinfo;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface WorkinfoMapper {
    int deleteByPrimaryKey(Integer picId);

    int insert(Workinfo record);

    int insertSelective(Workinfo record);

    Workinfo selectByPrimaryKey(Integer picId);

    int updateByPrimaryKeySelective(Workinfo record);

    int updateByPrimaryKey(Workinfo record);

    List<Workinfo> selectWorkContent(int workId);

    int insertOne(Workinfo workinfo);

    int updateWorkCover(Workinfo workinfo);

    List<Workinfo> selectByWorkId(int workId);

}