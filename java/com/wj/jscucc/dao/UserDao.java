package com.wj.jscucc.dao;

import com.wj.jscucc.entity.UserInfo;


public interface UserDao {

    //添加用户
    public void addUser(UserInfo user);

    //根据身份证查询用户信息
    public UserInfo findByIdCard(String idCard);

    //根据手机号，查询用户信息
    public UserInfo findByUserPhone(String phone);

    //修改用户信息
    public void modifyUser(UserInfo userInfo);
}
