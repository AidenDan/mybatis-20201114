package com.mybatis;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.mybatis.dao.IRunningAccountDao;
import com.mybatis.dao.IVipDao;
import com.mybatis.domain.RunningAccount;
import com.mybatis.domain.Vip;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;

/**
 * @author Aiden
 * @version 1.0
 * @description
 * @date 2020-11-14 17:11:03
 */
public class MybatisTest {

    private SqlSessionFactory sqlSessionFactory = null;
    private SqlSession sqlSession;
    private InputStream inputStream;

    @Before
    public void init() throws Exception {
        // 1. 创建SqlSessionFactoryBuilder对象
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        // 2. 加载SqlMapConfig.xml配置文件
        inputStream = Resources.class.getClassLoader().getResourceAsStream("mybatis-config.xml");
        // 3. 创建SqlSessionFactory对象
        this.sqlSessionFactory = sqlSessionFactoryBuilder.build(inputStream);
    }

    @Test
    public void testQueryUserById() {
        HashMap<Object, Object> hashMap = Maps.newHashMap();
        ArrayList<Object> arrayList = Lists.newArrayList();
        // 4. 创建SqlSession对象
        sqlSession = sqlSessionFactory.openSession();

        // 5. 执行SqlSession对象执行查询，获取结果User
        // 第一个参数是UserMapper.xml的statement的id，第二个参数是执行sql需要的参数；
        IVipDao vipDao = sqlSession.getMapper(IVipDao.class);
        // 6. 打印结果
        List<Vip> vipInfo = vipDao.getAllVipInfo();
        vipInfo.forEach(System.err::println);
//            System.out.println(user);
        // 7. 释放资源
        sqlSession.close();
    }


    @Test
    public void testInsertOne() {
        // 4. 创建SqlSession对象
        sqlSession = sqlSessionFactory.openSession();
        // 5. 执行SqlSession对象执行查询，获取结果User
        // 第一个参数是UserMapper.xml的statement的id，第二个参数是执行sql需要的参数；
        IVipDao vipDao = sqlSession.getMapper(IVipDao.class);

        for (int i = 0; i < 1000; i++) {
            Vip vip = new Vip();
            vip.setName(UUID.randomUUID().toString().replace("-", "").substring(0, 4));
            vip.setAge((int) (Math.random() * 100 + 1));
            vip.setHeight((float) (Math.random() * 100 + 101));
            vip.setSex((int) ((Math.random() * 10) % 2) == 0 ? "男" : "女");
            // 6. 打印结果
            int result = vipDao.insertOneVipInfo(vip);
            System.err.println(result);
        }
//            System.out.println(user);
        // 7. 释放资源
        sqlSession.commit();
    }

    @Test
    public void testInsertRunningAccount() {
        // 4. 创建SqlSession对象
        sqlSession = sqlSessionFactory.openSession();
        // 5. 执行SqlSession对象执行查询，获取结果User
        // 第一个参数是UserMapper.xml的statement的id，第二个参数是执行sql需要的参数；
        IRunningAccountDao runningAccountDao = sqlSession.getMapper(IRunningAccountDao.class);

        for (int i = 0; i < 1000; i++) {
            RunningAccount runningAccount = new RunningAccount();
            runningAccount.setSerializeId(UUID.randomUUID().toString().replaceAll("-", ""));

            // 6. 打印结果
            int result = runningAccountDao.insertRunningAccountItems(runningAccount);
            System.err.println(result);
        }
//            System.out.println(user);
        // 7. 释放资源
        sqlSession.commit();
    }

    @After
    public void after() throws IOException {
        sqlSession.close();
        inputStream.close();
    }
}
