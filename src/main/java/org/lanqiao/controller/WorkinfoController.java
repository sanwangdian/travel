package org.lanqiao.controller;

import org.lanqiao.entity.Workinfo;
import org.lanqiao.service.WorkinfoService;
import org.lanqiao.util.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class WorkinfoController {
    @Autowired
    WorkinfoService workinfoService;

    @RequestMapping("/selectWorkContent")
    public List<Workinfo> selectWorkContent(int workId) {
        return workinfoService.selectWorkContent(workId);
    }

    @RequestMapping("/changeUrl")
    public String changeUrl(Workinfo workinfo){
        Base64 base64 =new Base64();
        String url= base64.base64(workinfo.getPicUrl());
        workinfo.setPicUrl(url);
        if(workinfoService.insertOne(workinfo)==0){
            return "false";
        }
            return "success";
    }
    @RequestMapping("/selectByworkId")
    public List<Workinfo> selectByWorkId(int workId){
        return workinfoService.selectByWorkId(workId);
    }
}
