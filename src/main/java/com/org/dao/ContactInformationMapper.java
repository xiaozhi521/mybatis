package com.org.dao;

import com.org.bean.ContactInformation;

/**
 *  使用session.getMapper 方式获取数据
 *      方式一、
 *          ContactInformationMapper contactInformationMapper = session.getMapper(ContactInformationMapper.class);
 *          ContactInformation contactInformation = contactInformationMapper.getContactInformationrById_1(1);
 *
 *      需要注意在 *Mapper.xml 文件 namespace 的值是对应mapper类的dao接口 <mapper namespace="com.org.dao.ContactInformationMapper">
 *
 *      方式二、
 *          String statement = "com.org.mapper.ContactInformationMapper.getContactInformationrById";
 *          statement = "com.org.mapper.ContactInformationMapper.getContactInformationrById_1";
 *          ContactInformation contactInformation = session.selectOne(statement,1);
 *
 *      需要注意在 *Mapper.xml 文件 namespace 的值是对应他自己的*Mapper.xml  <mapper namespace="com.org.Mapper.ContactInformationMapper">
 *
 */
public interface ContactInformationMapper {
    public ContactInformation getContactInformationrById_1(int id);

    public ContactInformation getContactInformationrById_2(int id);
}
