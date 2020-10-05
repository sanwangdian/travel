package org.lanqiao.service;

import com.github.pagehelper.PageInfo;
import org.lanqiao.entity.Video;

import java.util.List;

public interface VideoService {
//    public List<Video> getVideoItem(int videoSort);

    public List<Video> getAllVideo();

    public PageInfo getAll(int pageNum, int pageSize);

    public PageInfo getAllLast(int pageNum, int pageSize);

    public PageInfo getVideoItem(int videoSort, int pageNum, int pageSize);

    public List<Video> getVideoDetail(int videoId);
    public List<Video> getVideoItem1(int videoId);

    public List<Video> getVideoSortItem(int videoSort);

    public Integer getVideoSum(int videoSort);

//    public String upLoadVideo(Video video);

//    public List<Video> insertVideo(Video formDate);
}
