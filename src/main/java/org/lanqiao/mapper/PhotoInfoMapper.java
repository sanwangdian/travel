package org.lanqiao.mapper;

import org.lanqiao.entity.PhotoInfo;

public interface PhotoInfoMapper {
    int deleteByPrimaryKey(Integer photoContentId);

    int insert(PhotoInfo record);

    int insertSelective(PhotoInfo record);

    PhotoInfo selectByPrimaryKey(Integer photoContentId);

    int updateByPrimaryKeySelective(PhotoInfo record);

    int updateByPrimaryKey(PhotoInfo record);
}