package org.lanqiao.controller;

import com.github.pagehelper.PageInfo;
import org.lanqiao.entity.Article;
import org.lanqiao.entity.Photo;
import org.lanqiao.entity.Users;
import org.lanqiao.entity.Work;
import org.lanqiao.service.SqService;
import org.lanqiao.util.FileUpload1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

@Controller
public class SQHController {

    @Autowired
    SqService sqService;

//分页获取相册
    @RequestMapping("/getP")
    @ResponseBody
    public PageInfo getAllPhoto(Integer pageNum, Integer pageSize, Photo photo){
        PageInfo pageInfo = sqService.getAllPhoto(pageNum,pageSize,photo);
        return pageInfo;
    }
//分页获取摄影作品
    @RequestMapping("/getW")
    @ResponseBody
    public PageInfo getAllWork(Integer pageNum, Integer pageSize, Work work){
        PageInfo pageInfo = sqService.getAllWork(pageNum,pageSize,work);
        return pageInfo;
    }
//分页获取游记
    @RequestMapping("/getA")
    @ResponseBody
    public PageInfo getAllArticle(Integer pageNum, Integer pageSize, Article article){
        PageInfo pageInfo = sqService.getAllArticle(pageNum,pageSize,article);
        return pageInfo;
    }
//获取user
    @RequestMapping("/getusersi")
    @ResponseBody
    public List getusersi(int userId ){
        return sqService.getuserssi(userId);
    }

//上传图片
    @RequestMapping("/uploadFile")
    public String UploadFileServlet (MultipartFile file, HttpServletRequest request, @Valid Users user) {
        String p = new FileUpload1().upload(request,file);
        user.setUserImg(p);
        sqService.updateUser(user);
        return "redirect:community_youji.html";
    }
//
    @RequestMapping("/getphoto")
    @ResponseBody
    public PageInfo getusersi(@Valid Photo photo, Integer pageNum, Integer pageSize){
        PageInfo pageInfo = sqService.getAllPhoto(pageNum,pageSize,photo);
        return pageInfo;
//        return sqService.insertPhot(photo);
    }
//删除
    @RequestMapping("/deletePhotoArray")
    @ResponseBody
    public int deletePhotoArray(int pid){
        int s = sqService.deletePhotoArray(pid);
        System.out.println(s);
        return s;
    }

    //登录


}
