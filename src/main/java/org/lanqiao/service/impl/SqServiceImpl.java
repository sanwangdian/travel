package org.lanqiao.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.lanqiao.entity.Article;
import org.lanqiao.entity.Photo;
import org.lanqiao.entity.Users;
import org.lanqiao.entity.Work;
import org.lanqiao.mapper.ArticleMapper;
import org.lanqiao.mapper.PhotoMapper;
import org.lanqiao.mapper.UserMapper;
import org.lanqiao.mapper.WorkMapper;
import org.lanqiao.service.SqService;
import org.lanqiao.util.RedisUtil;
import org.lanqiao.util.SolrUtil;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Set;

@Service
public class SqServiceImpl implements SqService {


    @Resource
    ArticleMapper articleMapper;

    @Resource
    WorkMapper workMapper;

    @Resource
    UserMapper userMapper;

    @Resource
    PhotoMapper photoMapper;

    @Override
    public List<Article> getNowCityArticle(String cityName) {
        List<Article> articles = null;
        System.out.println("cityName:"+cityName);
        try {
            articles = new SolrUtil().querySolr(cityName);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return articles;
        }
    }

    @Override
    public String getUserName(Integer userId) {
        return userMapper.selectUserNameByPK(userId);

    }

    @Override
    public void setHotCity(String cityName) {
        new RedisUtil().setRedisCity(cityName);
    }

    @Override
    public Set getHotCity() {
        return new RedisUtil().getRedisCity();
    }


    //    hcy
//分页获取摄影作品
    @Override
    public PageInfo getAllPhoto(int pageNum, int pageSize, Photo photo) {
        PageHelper.startPage(pageNum, pageSize); // 设定当前页码，以及当前页显示的条数
        //PageHelper.offsetPage(pageNum, pageSize);也可以使用此方式进行设置
        List list = photoMapper.selectAllPhoto(photo);
        PageInfo pageInfo = new PageInfo(list);
        return pageInfo;
    }

    //分页获取摄影作品
    @Override
    public PageInfo getAllWork(int pageNum, int pageSize, Work work) {
        PageHelper.startPage(pageNum, pageSize); // 设定当前页码，以及当前页显示的条数
        //PageHelper.offsetPage(pageNum, pageSize);也可以使用此方式进行设置
        List list = workMapper.selectAllWork(work);
        PageInfo pageInfo = new PageInfo(list);
        return pageInfo;
    }

    //    分页获取游记
    @Override
    public PageInfo getAllArticle(int pageNum, int pageSize, Article article) {
        PageHelper.startPage(pageNum, pageSize); // 设定当前页码，以及当前页显示的条数
        //PageHelper.offsetPage(pageNum, pageSize);也可以使用此方式进行设置
        List list = articleMapper.selectAllArticle(article);
        PageInfo pageInfo = new PageInfo(list);
        return pageInfo;
    }

    //上传社区用户背景图
    @Override
    public int updateUsers(Users users) {
        return userMapper.updateByPrimaryKeySelective(users);
    }

    //取出用户头像  以及社区的背景图
    @Override
    public List getuserssi(int userId) {
        return userMapper.selectsi(userId);
    }

    //    插入相册并获取相册内容
    @Override
    public PageInfo insertPhot(Photo photo, int pageNum, int pageSize) {

        photoMapper.insertSelective(photo);
        PageHelper.startPage(pageNum, pageSize); // 设定当前页码，以及当前页显示的条数
        //PageHelper.offsetPage(pageNum, pageSize);也可以使用此方式进行设置
        List list = photoMapper.selectPhoto(photo.getUserId());
        PageInfo pageInfo = new PageInfo(list);
        return pageInfo;
//        return photoMapper.selectPhoto(photo.getUserId());
    }

    @Override
    public int deletePhotoArray(int pid) {

        return photoMapper.deleteByPrimaryKey(pid);
    }

    //    hcy
    //lwx
//注册用户
    @Override
    public int addUser(Users users) {
        return userMapper.insert(users);
    }

    //手机号是否已注册
    @Override
    public int userPhoneIsExist(String userPhone) {
        int count = userMapper.selectByUserPhone(userPhone);
        if (count > 0) {
            return 0;
        } else {
            return 1;
        }
    }

    //根据手机号和密码获取用户
    @Override
    public List<Users> PhoneAndPasswExist(String userPhone, String userPassw) {
        return userMapper.selectByPhonePassw(userPhone, userPassw);
    }

    //根据用户id获取用户
    @Override
    public Users getUser(Integer userId) {
        return userMapper.selectByPrimaryKey(userId);
    }

    @Override
    public int updateUser(Users users) {
        return userMapper.updateByPrimaryKey(users);
    }
}
