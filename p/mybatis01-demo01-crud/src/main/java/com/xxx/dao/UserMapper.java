package com.xxx.dao;

import com.xxx.bean.QueryVo;
import com.xxx.bean.User;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

public interface UserMapper {
    List<User> findAll();
    Integer add(User user);

    Integer update(User user);

    Integer delete(Integer id);

    List<User> findUserName(String username);


    User findUserByVo(QueryVo vo);

    int findCount();


    List<User> testMoreWhere(User user);

    List<User> testMoreForeach(List<Integer> ids);

    List<User> findUsers();

    @Select("select * from user where id = #{uid}")
    User findUserById(Integer uid);


    @Results(id = "ref", value = {
            @Result(column = "id", property = "id"),
            @Result(property = "accounts", column = "id",
                    many = @Many(select = "com.xxx.dao.AccountMapper.findAccountByUid", fetchType = FetchType.LAZY))
    })
    @Select("select * from user where user_name = #{username}")
    User findUserByUsername(String username);

    @ResultMap("ref")
    @Select("select * from user where user_name = #{username}")
    User findUserByUsername1(String username);

    @Select("select * from user where user_name = #{username} and address = #{address}")
    User findUser(@Param("username") String  username, @Param("address") String address);

    @Select(value = {
            "<script>",
                "select * from user where 1 = 1",
                "<if test='username != null and username != \"\"'>",
                    "and user_name like #{username}",
                "</if>",
            "</script>"
    })
    List<User> findUsers5(User user);
}
