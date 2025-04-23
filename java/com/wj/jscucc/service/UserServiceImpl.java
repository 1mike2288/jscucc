package com.wj.jscucc.service;

import javax.annotation.Resource;

import com.wj.jscucc.dao.UserDao;
import com.wj.jscucc.entity.ResultMsg;
import com.wj.jscucc.entity.UserInfo;

import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserDao userDao;


    @Override
    public ResultMsg addUser(UserInfo user) {

        ResultMsg rs = new ResultMsg();
        System.out.println(user.toString());
        UserInfo user2 = userDao.findByIdCard(user.getIdCard());
        if(user2==null) {
            userDao.addUser(user);
            rs.setStatus("0");
            rs.setMsg("新用户注册成功");
        }else {
            rs.setStatus("1");
            rs.setMsg("该用户已经存在");
        }
        return rs;
    }



    @Override
    public ResultMsg queryUser(String code) {
        ResultMsg rs = new ResultMsg();
        UserInfo userInfo=null;

        if(code.length()>11) {
            userInfo = userDao.findByIdCard(code);
        }else {
            userInfo = userDao.findByUserPhone(code);
        }

        if(userInfo!=null) {
            System.out.println(userInfo.toString());
            rs.setStatus("0");
            rs.setData(userInfo);
        }else {
            rs.setStatus("1");
            rs.setMsg("没有查询到用户信息");
        }
        return rs;
    }


    @Override
    public ResultMsg modifyUser(UserInfo userInfo) {
        ResultMsg rs = new ResultMsg();
        userDao.modifyUser(userInfo);
        rs.setStatus("0");
        rs.setMsg("修改成功");
        return rs;
    }

}
