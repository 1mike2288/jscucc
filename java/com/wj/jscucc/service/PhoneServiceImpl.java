package com.wj.jscucc.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.wj.jscucc.dao.PhoneDao;
import com.wj.jscucc.entity.PhoneInfo;
import com.wj.jscucc.entity.ResultMsg;


import com.wj.jscucc.util.TimeUtil;
import org.springframework.stereotype.Service;

@Service
public class PhoneServiceImpl implements PhoneService {

    @Resource
    PhoneDao phoneDao;

    @Override
    public ResultMsg queryPhone() {
        List<PhoneInfo> listPhone=phoneDao.queryPhone();
        ResultMsg rs = new ResultMsg();
        rs.setStatus("0");
        rs.setData(listPhone);
        return rs;
    }

    @Override
    public ResultMsg queryPhonePage(String begin, String end, String pageSize) {
        int b =Integer.valueOf(begin);
        int e = Integer.valueOf(end);
        int page = Integer.valueOf(pageSize);

        int row = phoneDao.findCount();

        int total=0;
        if(row%page==0) {
            total = row/page;
        }else {
            total = row/page+1;
        }
        String totalpage = String.valueOf(total);

        List<PhoneInfo> phoneList = phoneDao.queryPhonePage(b, e);

        ResultMsg rs = new ResultMsg();
        rs.setStatus("0");
        rs.setMsg(totalpage);
        rs.setData(phoneList);
        return rs;
    }

    @Override
    public ResultMsg querykdInfo() {
        List<Map<String,Object>> kdList = phoneDao.querykdInfo();
        System.out.println(kdList);
        ResultMsg rs = new ResultMsg();
        rs.setStatus("0");
        rs.setData(kdList);
        return rs;
    }

    @Override
    public ResultMsg updateStatus(String status, String phone) {
        ResultMsg rs = new ResultMsg();
        System.out.println(status);
        if("1".equals(status)) {
            String phoneStatus = phoneDao.findByphone(phone);
            System.out.println("status="+phoneStatus);
            if(phoneStatus.equals("0")) {
                Map<String,String> map = new HashMap<String, String>();
                map.put("status", status);
                map.put("phone", phone);
                phoneDao.updateStatus(map);
                rs.setStatus("0");
                String phoneStatus2 = phoneDao.findByphone(phone);
                System.out.println("status2="+phoneStatus2);
            }else {
                rs.setStatus("1");
                rs.setMsg("该号码已经被占用");
            }
        }else {
            Map<String,String> map = new HashMap<String, String>();
            map.put("status", status);
            map.put("phone", phone);
            phoneDao.updateStatus(map);
            rs.setStatus("2");
        }
        return rs;
    }

    @Override
    public ResultMsg addUserPhone(String idCard, String phone) {
        ResultMsg rs = new ResultMsg();
        Map<String,String> map = new HashMap<>();
        map.put("idCard", idCard);
        map.put("phone", phone);
        map.put("status", "1");
        map.put("createtime", TimeUtil.getTimeNow());
        map.put("modifytime", TimeUtil.getTimeNow());
        phoneDao.addUserPhone(map);
        rs.setStatus("0");
        rs.setMsg("手机号订购成功！！");
        updateStatus("2",phone);
        return rs;
    }



    @Override
    public ResultMsg addUserKd(String idCard, String phone, String kdname, String kdaddress) {
        ResultMsg rs =new ResultMsg();
        Map<String,String> map = new HashMap<>();
        map.put("idCard", idCard);
        map.put("phone", phone);
        map.put("kdname", kdname);
        map.put("kdaddress", kdaddress);
        map.put("status", "1");
        map.put("createtime", TimeUtil.getTimeNow());
        map.put("modifytime", TimeUtil.getTimeNow());
        phoneDao.addUserKd(map);
        rs.setStatus("0");
        rs.setMsg("宽带订购成功！！");
        return rs;
    }

}
