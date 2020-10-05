package org.lanqiao.mapper;

import org.lanqiao.entity.Video;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface VideoMapper {
    int deleteByPrimaryKey(Integer videoId);

    int insert(Video record);

    int insertSelective(Video record);

    Video selectByPrimaryKey(Integer videoId);

    int updateByPrimaryKeySelective(Video record);

    int updateByPrimaryKey(Video record);

    List<Video> getAllVideo();
    List<Video> getVideo(int videoSort);
    List<Video> getVideoDetail(int videoId);
    List<Video> getVideoSortItem(int videoSort);
    int getVideoSum(int videoSort);
    List<Video> getAll();
    List<Video> getAllLast();
}