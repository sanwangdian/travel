package org.lanqiao.mapper;

import org.lanqiao.entity.Users;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface UserMapper {
    int deleteByPrimaryKey(Integer userId);

    int insert(Users record);

    int insertSelective(Users record);

    Users selectByPrimaryKey(Integer userId);

    int updateByPrimaryKeySelective(Users record);

    int updateByPrimaryKey(Users record);

    String selectUserNameByPK(Integer userId);
//    hcy
//    取出用户信息
List selectsi(int userId);

int selectByUserPhone(String userPhone);

List<Users> selectByPhonePassw(String userPhone, String userPassw);
}