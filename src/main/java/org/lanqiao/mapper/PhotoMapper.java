package org.lanqiao.mapper;

import org.lanqiao.entity.Photo;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface PhotoMapper {
    int deleteByPrimaryKey(Integer photoId);

    int insert(Photo record);

    int insertSelective(Photo record);

    Photo selectByPrimaryKey(Integer photoId);

    List selectAllPhoto(Photo photo);
    List selectPhoto(int userId);

    int updateByPrimaryKeySelective(Photo record);

    int updateByPrimaryKey(Photo record);
}