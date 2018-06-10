package com.cn;

import com.org.bean.Items;
import com.org.bean.User;
import com.org.util.SessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

public class UserTest1 {
    @Test
    public void oneToMany2() throws IOException {
        SqlSession session = SessionFactoryUtil.getSession().openSession();

        String statement = "com.org.mapper.userMapper.getUserMany3";

        User user = session.selectOne(statement,1);
        List<Items> list  = user.getItems();
        System.out.println(list);
        System.out.println(user);

    }
    @Test
    public void oneToMany() throws IOException {
        SqlSession session = SessionFactoryUtil.getSession().openSession();

        String statement = "com.org.mapper.userMapper.getUserMany";

        User user = session.selectOne(statement,1);
        System.out.println(user);

    }
}
