package org.lanqiao.controller;

import org.lanqiao.entity.Work;
import org.lanqiao.service.UpPhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UpPhotoController {

    @Autowired
    UpPhotoService upPhotoService;

    @RequestMapping("/insertWork")
    public int insertIntoWork(Work work){
        return upPhotoService.insertIntoWork(work);
    }

   @RequestMapping("/selectBydefault")
    public List<Work> selectBydefault() {
        return upPhotoService.selectBydefault();
    }

    @RequestMapping("/selectBydTime")
    public List<Work> selectBydTime() {
        return upPhotoService.selectBydTime();
    }

   @RequestMapping("/selectByHot")
    public List<Work> selectByHot() {
        return upPhotoService.selectByHot();
    }

    @RequestMapping("/selectHisWork")
    public List<Work> selectHisWork(int userId){return upPhotoService.selectHisWork(userId);}

    @RequestMapping("/selectThisWork")
    public Work selectThisWork(int workId){
        return upPhotoService.selectThisWork(workId);
    }

    @RequestMapping("/selectByTag")
    public List<Work> selectByTag(String tag){
        return upPhotoService.selectByTag(tag);
    }

//    @RequestMapping("/selectWorkId")
//    public int  selectWorkId(Work work){
//        return upPhotoService.selectWorkId(work);
//    }
    @RequestMapping("/selectByPrimaryKey")
    public Work selectByPrimaryKey(int workId){
        return upPhotoService.selectByPrimaryKey(workId);
    }

    @RequestMapping("/updateTheWork")
    public int updateTheWork(Work work){
        return upPhotoService.updateTheWork(work);
    }
    @RequestMapping("/deletWorkAndInfo")
    public int deletWorkAndInfo(int workId){
        return upPhotoService.deletWorkAndInfo(workId);
    }
    @RequestMapping("/deteletInfo")
    public int deteletInfo(int workId){
        return upPhotoService.deleteWorkInfo(workId);
    }





}
