package com.org.dao;

import com.org.bean.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 *  注解方式
 */
public interface UserMapper {

    @Select("select * from user")
    public List<User> getAll();

    @Select("select * from user where id = #{id}")
    public User getUserById(int id);

    @Insert("INSERT user (userName, birthday, sex, address, createtime) VALUES (#{userName}, #{birthday} ,#{sex} ,#{address} ,#{createtime})")
    public int insertUser(User user);

    @Update("UPDATE user set userName = #{userName},birthday = #{birthday},sex = #{sex},address = #{address} WHERE id = #{id}")
    public int updateUser(User user);

    @Delete("DELETE FROM user WHERE id = #{id}")
    public int deleteUserById(int id);

}
