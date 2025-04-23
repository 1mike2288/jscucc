package com.wj.jscucc.dao;

import com.wj.jscucc.entity.PhoneInfo;

import java.util.List;
import java.util.Map;



public interface PhoneDao {

    //查询所有可用手机号
    public List<PhoneInfo> queryPhone();

    //分页查询
    public List<PhoneInfo> queryPhonePage(int begin,int end);

    //统计数量
    public int findCount();


    //查询宽带信息
    public List<Map<String,Object>> querykdInfo();

    //修改手机状态
    public void updateStatus(Map<String,String> map);

    //根据手机号，查询手机先关信息
    public String findByphone(String phone);


    //用户和手机插入关联表
    public void addUserPhone(Map<String,String> map);

    //用户和宽带信息 插入关联表
    public void addUserKd(Map<String,String> map);
}
