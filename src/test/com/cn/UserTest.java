package com.cn;

import com.org.bean.User;
import com.org.dao.UserMapper;
import com.org.util.SessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.io.IOException;
import java.util.Date;
import java.util.List;

public class UserTest {
    @Test
    public void insertUser2() throws IOException {
        //创建能执行映射文件中sql的sqlSession
        SqlSession session =  SessionFactoryUtil.getSession().openSession();

        UserMapper userMapper = session.getMapper(UserMapper.class);

        User user = new User();
        user.setUserName("AA");
        user.setBirthday(new Date(93,3,3));
        user.setAddress("北京市丰台区5号");
        user.setCreatetime(new Date());

        int i = userMapper.insertUser(user);
        if(i == 1){
            session.commit();
        }
        session.close();
    }

    @Test
    public void getAllUser() throws IOException {
        SqlSession session =  SessionFactoryUtil.getSession().openSession();

        String statement = "com.org.mapper.userMapper.getAll";
        //获取所有的user 对象
        List<User> list =  session.selectList(statement);
        System.out.println(list.size());
        for(User user : list){
            System.out.println(user.toString());
        }

        session.close();
    }
    @Test
    public void deleteUserById() throws IOException {
        SqlSession session =  SessionFactoryUtil.getSession().openSession();

        String statement = "com.org.mapper.userMapper.deleteUserById";
        //删除一个对象
        int i  = session.delete(statement,4);
        if (i == 1) {
            session.commit();
        }else {
            session.rollback();
        }
        session.close();
        System.out.println("delete success");
    }
    @Test
    public void updateUser() throws IOException {
        SqlSession session =  SessionFactoryUtil.getSession().openSession();

        String statement1 = "com.org.mapper.userMapper.getUserById";
        //执行查询返回一个唯一user对象的sql
        User user = session.selectOne(statement1, 1);

        //映射sql的标识字符串
        String statement = "com.org.mapper.userMapper.updateUser";

        user.setUserName("tom");
        //更新一个对象
        int i = session.update(statement,user);

        if(i == 1){
            System.out.println("update success");
            session.commit();
        }

        session.close();
        System.out.println(user);
    }
    @Test
    public void insertUser() throws IOException {
        //创建能执行映射文件中sql的sqlSession
        SqlSession session =  SessionFactoryUtil.getSession().openSession();
        //映射sql的标识字符串
        String statement = "com.org.mapper.userMapper.insertUser";

        User user = new User();
        user.setUserName("Alex");
        user.setBirthday(new Date(93,3,3));
        user.setAddress("北京市丰台区2号");
        user.setCreatetime(new Date());
        //插入一个对象
        int i =session.insert(statement,user);
        if(i == 1){
            System.out.println(user);
            session.commit();
        }else{
            session.rollback();
        }
        session.close();
    }
    @Test
    public void getUser() throws IOException {
        SqlSession session =  SessionFactoryUtil.getSession().openSession();
        //映射sql的标识字符串
        String statement = "com.org.mapper.userMapper.getUserById";

        //执行查询返回一个唯一user对象的sql
        User user = session.selectOne(statement, 1);
        System.out.println(user);

        session.clearCache();
        user = session.selectOne(statement, 1);
        System.out.println(user);
    }
}
