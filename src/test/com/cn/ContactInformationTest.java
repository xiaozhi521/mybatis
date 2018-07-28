package com.cn;

import com.org.bean.ContactInformation;
import com.org.dao.ContactInformationMapper;
import com.org.util.SessionFactoryUtil;
import com.sun.istack.internal.logging.Logger;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.io.IOException;

public class ContactInformationTest {
    Logger logger = Logger.getLogger(ContactInformationTest.class);
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

    /**
     *
     * @throws IOException
     */
    @Test
    public void getInformationByIdForInterface() throws IOException {
        SqlSession session = SessionFactoryUtil.getSession().openSession(true);
        ContactInformationMapper contactInformationMapper = session.getMapper(ContactInformationMapper.class);
        ContactInformation contactInformation = contactInformationMapper.getContactInformationrById_1(1);

        ContactInformation contactInformation1 = contactInformationMapper.getContactInformationrById_1(2);
        session.close();
        System.out.println(contactInformation.toString());
        System.out.println(contactInformation1.toString());
    }

    @Test
    public void getInformationByIdForInterface2() throws IOException {
        SqlSession session = SessionFactoryUtil.getSession().openSession(true);
        ContactInformationMapper contactInformationMapper = session.getMapper(ContactInformationMapper.class);
        ContactInformation contactInformation = contactInformationMapper.getContactInformationrById_2(1);

        ContactInformation contactInformation1 = contactInformationMapper.getContactInformationrById_2(2);
        session.close();
        System.out.println(contactInformation.toString());
        System.out.println(contactInformation1.toString());
    }


}
