package org.lanqiao.controller;

import com.github.pagehelper.PageInfo;
import org.lanqiao.entity.Video;
import org.lanqiao.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class VideoController {

    @Autowired
    VideoService videoService;

    @RequestMapping("/getVideoItem1")
    public List<Video> getVideoItem1(int videoSort){
        return videoService.getVideoItem1(videoSort);
    }

    @RequestMapping("/getVideoDetail")
    public List<Video> getVideoDetail(int videoId){
        return videoService.getVideoDetail(videoId);
    }

    @RequestMapping("/getVideoSortItem")
    public List<Video> getVideoSortItem(int videoSort){
        return videoService.getVideoSortItem(videoSort);
    }
    @RequestMapping("/getVideoSum")
    public Integer getVideoSum(int videoSort){
        return videoService.getVideoSum(videoSort);
    }

    @RequestMapping("/getAll")
    @ResponseBody
    public PageInfo getAll(Integer pageNum, Integer pageSize ){
        PageInfo pageInfo = videoService.getAll(pageNum,pageSize);
        return pageInfo;
    }
    @RequestMapping("/getVideoItem")
    @ResponseBody
    public PageInfo getVideoItem(int videoSort, Integer pageNum, Integer pageSize){
        PageInfo pageInfo1 = videoService.getVideoItem(videoSort,pageNum,pageSize);
        return pageInfo1;
    }
    @RequestMapping("/getAllVideo")
    public List<Video> getAllVideo(){
        return videoService.getAllVideo();
    }
    @RequestMapping("/getAllLast")
    @ResponseBody
    public PageInfo getAllLast(Integer pageNum, Integer pageSize ){
        PageInfo pageInfo2 = videoService.getAllLast(pageNum,pageSize);
        return pageInfo2;
    }

//    @RequestMapping("/upLoadVideo")
//    public String upLoadVideo(Video video){
//        return videoService.upLoadVideo(video);
//    }

//    @RequestMapping("/changeUrl")
//    public String changeUrl(Video video){
//        Base64 base64 =new Base64();
//        String url= base64.base64(video.getPicUrl());
//        video.setPicUrl(url);
//        if(videoService.insertOne(workinfo)==0){
//            return "false";
//        }
//        return "success";
//    }

}
