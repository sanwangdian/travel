package org.lanqiao.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.lanqiao.entity.Video;
import org.lanqiao.mapper.VideoMapper;
import org.lanqiao.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class VideoServiceImpl implements VideoService {
    @Resource
    VideoMapper videoMapper;

    @Override
    public List<Video> getVideoItem1(int videoSort) {
        return videoMapper.getVideo(videoSort);
    }

    @Override
    public List<Video> getAllVideo() {
        return videoMapper.getAllVideo();
    }

    @Override
    public List<Video> getVideoDetail(int videoId) {
        return videoMapper.getVideoDetail(videoId);
    }

    @Override
    public List<Video> getVideoSortItem(int videoSort) {
        return videoMapper.getVideoSortItem(videoSort);
    }

    @Override
    public Integer getVideoSum(int videoSort) {
        Integer sum = videoMapper.getVideoSum(videoSort);
        if(sum == null){
            return 0;
        }else {
            return sum;
        }

    }
    @Override
    public PageInfo getAll(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize); // 设定当前页码，以及当前页显示的条数
        //PageHelper.offsetPage(pageNum, pageSize);也可以使用此方式进行设置
        List list = videoMapper.getAll();
        PageInfo pageInfo = new PageInfo(list);
        return pageInfo;
    }
    @Override
    public PageInfo getAllLast(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize); // 设定当前页码，以及当前页显示的条数
        //PageHelper.offsetPage(pageNum, pageSize);也可以使用此方式进行设置
        List list = videoMapper.getAllLast();
        PageInfo pageInfo2 = new PageInfo(list);
        return pageInfo2;
    }
    @Override
    public PageInfo getVideoItem(int videoSort, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize); // 设定当前页码，以及当前页显示的条数
        //PageHelper.offsetPage(pageNum, pageSize);也可以使用此方式进行设置
        List list = videoMapper.getVideo(videoSort);
        PageInfo pageInfo1 = new PageInfo(list);
        return pageInfo1;
    }

//    @Override
//    public String upLoadVideo(Video video){
//      return videoMapper.updateByPrimaryKeySelective(video);
//    }
}
