package org.lanqiao.controller;

import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONObject;
import org.lanqiao.entity.Article;
import org.lanqiao.entity.Users;
import org.lanqiao.service.SqService;
import org.lanqiao.util.SmsUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Set;

@RestController
@Slf4j
public class SqController {

    @Autowired
    SqService sqService;

    @RequestMapping("/getNowA")
    public List getNowCityA(@RequestParam(defaultValue = "天津市") String cityName) {
        return sqService.getNowCityArticle(cityName);
    }

    @RequestMapping("/selectSolr")
    public PageInfo<Article> getYouji(@RequestParam("msg") String findMsg,@RequestParam("pageNum") Integer pageNum){

        PageHelper.startPage(pageNum, 3);

//        List<Article> articleList = articlesService.getAllArticles();
        List<Article> list = sqService.getNowCityArticle(findMsg);

        PageInfo<Article> pageInfo = new PageInfo<>(list);

        return pageInfo;

    }


    @RequestMapping("/getUserName")
    public String getUserName(int userid) {
        return sqService.getUserName(userid);
    }

    @RequestMapping("/setHot")
    public void setHotCity(@RequestParam(defaultValue = "深圳市") String cityName) {
        sqService.setHotCity(cityName);
    }

    @RequestMapping("/getHot")
    public Set getHotCity() {
        return sqService.getHotCity();
    }

    //注册
    @RequestMapping("/register")
    public String register(HttpServletRequest request, String userPhone, String userPassw, String authcode) {
        log.info("到达register");
        JSONObject json = (JSONObject) request.getSession().getAttribute("verifycode");
        log.info("authcode:" + json);
        if (!json.getString("authcode").equals(authcode)) {
            return "验证码错误";
        }
//        if((System.currentTimeMillis()-json.getLong("createTime"))>1000 * 60 ){
//            return "验证码过期";
//        }
        //将用户信息存入数据库
        Users users = new Users();
        users.setUserPhone(userPhone);
        users.setUserPassw(userPassw);
        sqService.addUser(users);
        return "success";
    }

    //发送验证码
    @RequestMapping("/sendSms")
    public Object sendSms(HttpServletRequest request, String userPhone) throws Exception {
        SmsUtils smsUtils = new SmsUtils();
        smsUtils.setNewcode();
        String code = Integer.toString(smsUtils.getNewcode());
        SendSmsResponse sendSms = smsUtils.sendSms(userPhone, code);
        System.out.println("短信接口返回的数据-----------");
        System.out.println("Code=" + sendSms.getCode());
        System.out.println("Message=" + sendSms.getMessage());

        //将验证码存到session中，同时创建存入时间
        //以json存放
        HttpSession session = request.getSession();
        JSONObject json = new JSONObject();

        json.put("authcode", code);
        json.put("createTime", System.currentTimeMillis());

        log.info("authCode:" + code);

        session.setAttribute("verifycode", json);
        if (sendSms.getCode() != null && sendSms.getCode().equals("ok")) {
            return "success";
        } else {
            return "fail";
        }
    }

    //检查手机号已注册
    @RequestMapping("/check")
    public int checkUser(String userPhone) {
        return sqService.userPhoneIsExist(userPhone);
    }

    //注册
    @RequestMapping("/insert")
    public int insert(Users users) {

        return sqService.addUser(users);
    }

    @RequestMapping("/login")
    public String checkLoginUser(HttpServletResponse response, String userPhone, String userPassw) {
        String url = "login.html";
        List<Users> list = sqService.PhoneAndPasswExist(userPhone, userPassw);
        if (list.size() > 0) {
            String id = list.get(0).getUserId().toString();
            Cookie cookie = new Cookie("userId", id);
            cookie.setPath("/");
            response.addCookie(cookie);
            url = "sy-index.html";

        }
        return url;
    }

    //展示用户资料
    @RequestMapping("/showUserInfo")
    public Users getUserInfo(Integer userId) {
        return sqService.getUser(userId);
    }

    //修改用户资料
    @RequestMapping("/updateUserInfo")
    public int updateUserInfo(Users users) {
        return sqService.updateUser(users);
    }


}
