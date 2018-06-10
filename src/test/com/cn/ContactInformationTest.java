package com.cn;

import com.org.bean.ContactInformation;
import com.org.util.SessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.io.IOException;

public class ContactInformationTest {
    @Test
    public void oneToOne2() throws IOException {
        SqlSession session = SessionFactoryUtil.getSession().openSession(true);

        String statement = "com.org.mapper.ContactInformationMapper.getInformation";
        ContactInformation contactInformation = session.selectOne(statement,2);
        session.close();
        System.out.println(contactInformation.toString());
    }
    @Test
    public void oneToOne() throws IOException {
        SqlSession session = SessionFactoryUtil.getSession().openSession(true);

        String statement = "com.org.mapper.ContactInformationMapper.getContactInformation_User_ById";
        ContactInformation contactInformation = session.selectOne(statement,2);
        session.close();
        System.out.println(contactInformation.toString());
    }
    @Test
    public void getInformationById() throws IOException {
        SqlSession session = SessionFactoryUtil.getSession().openSession(true);

        String statement = "com.org.mapper.ContactInformationMapper.getContactInformationrById";
        statement = "com.org.mapper.ContactInformationMapper.getContactInformationrById_1";
        ContactInformation contactInformation = session.selectOne(statement,1);
        session.close();
        System.out.println(contactInformation.toString());
    }
}
