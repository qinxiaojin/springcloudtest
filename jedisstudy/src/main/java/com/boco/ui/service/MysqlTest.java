package com.boco.ui.service;

import com.boco.ui.dao.MysqlConnect;
import com.boco.ui.mapper.MapperMysql;
import com.boco.ui.pojo.Tuser;

import java.util.List;

public class MysqlTest extends MysqlConnect {

    public void selectUser(){
        open();
        MapperMysql mapperMysql = sqlSession.getMapper(MapperMysql.class);
        List<Tuser> list = mapperMysql.selectUser();
        for (int i = 0 ; i < list.size(); i++){
            Tuser tuser = list.get(i);
            System.out.println(tuser.getId()+" "+tuser.getName()+" "+
                    tuser.getAge());
        }
        closeResource();
    }

    public static void main(String[] args) {
        new MysqlTest().selectUser();
    }
}
