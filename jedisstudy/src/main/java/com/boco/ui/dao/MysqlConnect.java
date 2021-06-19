package com.boco.ui.dao;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class MysqlConnect {
    private static SqlSessionFactory sqlSessionFactory;
    public SqlSession sqlSession;
    static {
        try {
            String resource = "mysqlconnect.xml";
            InputStream inputStream = Resources.getResourceAsStream(resource);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //获取SqlSession连接
    public void open(){
        sqlSession = sqlSessionFactory.openSession();
    }
    public void closeResource(){
        if (sqlSession != null){
            sqlSession.close();
        }
    }
}
