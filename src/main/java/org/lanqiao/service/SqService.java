package org.lanqiao.service;


import com.github.pagehelper.PageInfo;
import org.lanqiao.entity.Article;
import org.lanqiao.entity.Photo;
import org.lanqiao.entity.Users;
import org.lanqiao.entity.Work;

import java.util.List;
import java.util.Set;


public interface SqService {

    List<Article> getUserIdArticle(String userId);

    public List<Article> getNowCityArticle(String cityName);

    public String getUserName(Integer userId);

    public void setHotCity(String cityName);

    public Set getHotCity();

    //hcy
    public PageInfo getAllWork(int pageNum, int pageSize, Work work);

    public PageInfo getAllArticle(int pageNum, int pageSize, Article article);

    public PageInfo getAllPhoto(int pageNum, int pageSize, Photo photo);

    public int updateUsers(Users user);

    public List getuserssi(int userId);

    public PageInfo insertPhot(Photo photo, int pageNum, int pageSize);

    public int deletePhotoArray(int pid);

    //hcy
    //lwx
    public int addUser(Users users);

    public int userPhoneIsExist(String userPhone);

    public List<Users> PhoneAndPasswExist(String userPhone, String userPassw);

    public Users getUser(Integer userId);

    public int updateUser(Users users);

}
