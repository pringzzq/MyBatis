package com.zzq.text;

import com.zzq.dao.Dao;
import com.zzq.po.Specil;
import com.zzq.utils.MybatisUtils;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentText {
    public  static void main(String[] args) throws IOException {
        SqlSession sqlSession= MybatisUtils.getSqlSession(false);
        int pageNum=1;
        int pageSize=1;
        int start=(pageNum-1)*pageSize;
        Dao dao =sqlSession.getMapper(Dao.class);

        Map<String,Object> map=new HashMap<>();
        map.put("start",start);
        map.put("pageSize",pageSize);

        List<Specil> specilList=dao.fSS(map);
        for (Specil specil:specilList){
            System.out.println(specil);
        }
       MybatisUtils.closeSqlSession(sqlSession);
    }

}
