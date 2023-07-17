package cn.edu.tju.mapper;

import cn.edu.tju.domain.UserInfo;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper {
    @Select("select count(1) from user_info where username= #{username} and credential = #{password}")
    int selectUser(@Param("username")String username, @Param("password")String password);

    @Select("select id, username  from user_info ")
    List<UserInfo> getUserList();

    @Delete("delete  from user_info where username= #{username} ")
    int deleteUser(String username);

    @Insert("insert into user_info(username,credential) values(#{username},#{password}) ")
    int addUser(@Param("username") String username, @Param("password")String password);


}
