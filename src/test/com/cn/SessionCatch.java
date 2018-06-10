package com.cn;

import com.org.bean.User;
import com.org.util.SessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.io.IOException;


public class SessionCatch {
    @Test
    public void getUserCatch2() throws IOException {
        //映射sql的标识字符串
        String statement = "com.org.mapper.userMapper.getUserById";

        SqlSession session1 =  SessionFactoryUtil.getSession().openSession();
        SqlSession session2 =  SessionFactoryUtil.getSession().openSession();

        //执行查询返回一个唯一user对象的sql
        User user = session1.selectOne(statement, 1);
        session1.commit();
        System.out.println("user1:" + user);

        //执行查询返回一个唯一user对象的sql
         user = session2.selectOne(statement, 1);
        session2.commit();
        System.out.println("user2:" + user);
    }

    /**
     *  一级缓存: 也就Session级的缓存(默认开启)
     *
     *  一级缓存默认就会被使用
     *
     *  1. 必须是同一个Session,如果session对象已经close()过了就不可能用了
     *  2. 查询条件是一样的
     *  3. 没有执行过session.clearCache()清理缓存
     *  4. 没有执行过增删改的操作(这些操作都会清理缓存)
     */
    @Test
    public void getUser() throws IOException {
        SqlSession session =  SessionFactoryUtil.getSession().openSession();
        //映射sql的标识字符串
        String statement = "com.org.mapper.userMapper.getUserById";

        //执行查询返回一个唯一user对象的sql
        User user = session.selectOne(statement, 1);
        System.out.println(user);

        //查询条件是一样的
        user = session.selectOne(statement, 1);
        System.out.println(user);

        //没有执行过session.clearCache()清理缓存
        session.clearCache();
        user = session.selectOne(statement, 1);
        System.out.println(user);

        //没有执行过增删改的操作(这些操作都会清理缓存)
        statement = "com.org.mapper.userMapper.updateUser";
        user.setUserName("tom");
//        //更新一个对象
        int i = session.update(statement,user);
        session.commit();

        statement = "com.org.mapper.userMapper.getUserById";
        user = session.selectOne(statement, 1);
        System.out.println(user);
    }
}
