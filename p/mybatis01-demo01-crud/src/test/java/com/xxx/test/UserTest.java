package com.xxx.test;

import com.xxx.bean.Account;
import com.xxx.bean.QueryVo;
import com.xxx.bean.Role;
import com.xxx.bean.User;
import com.xxx.dao.AccountMapper;
import com.xxx.dao.RoleMapper;
import com.xxx.dao.UserMapper;
import com.xxx.utils.MybatisUtils;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserTest {

    @Test
    public void findAll() throws IOException {
//        String resource = "org/mybatis/example/mybatis-config.xml";
//        InputStream inputStream = Resources.getResourceAsStream(resource);
//        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
//
//        SqlSession session = sqlSessionFactory.openSession();
        SqlSession session = MybatisUtils.getSession();
        try {
            UserMapper userMapper = session.getMapper(UserMapper.class);
            System.out.println(userMapper.findAll());
        } finally {
            MybatisUtils.closeNotCommit();
        }
    }

    @Test
    public void add() throws IOException {
//        String resource = "org/mybatis/example/mybatis-config.xml";
//        InputStream inputStream = Resources.getResourceAsStream(resource);
//        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
//
//        SqlSession session = sqlSessionFactory.openSession();
        SqlSession session = MybatisUtils.getSession();
        try {
            UserMapper userMapper = session.getMapper(UserMapper.class);
            User user = new User(null, "范冰冰", new Date(), "女", "深圳");
            Integer count = userMapper.add(user);
            System.out.println(count);
            System.out.println(user.getId());
        } finally {
            MybatisUtils.closeCommit();
        }
    }

    @Test
    public void update() throws IOException {

        SqlSession session = MybatisUtils.getSession();
        try {
            UserMapper userMapper = session.getMapper(UserMapper.class);
            User user = new User(3, "刘欢欢", new Date(), "女", "深圳");
            Integer count = userMapper.update(user);
            System.out.println(count);
        } finally {
            MybatisUtils.closeCommit();
        }
    }

    @Test
    public void delete() throws IOException {

        SqlSession session = MybatisUtils.getSession();
        try {
            UserMapper userMapper = session.getMapper(UserMapper.class);

            Integer count = userMapper.delete(3);
            System.out.println(count);
        } finally {
            MybatisUtils.closeCommit();
        }
    }

    @Test
    public void findUserName() {
        SqlSession session = MybatisUtils.getSession();
        UserMapper userMapper = session.getMapper(UserMapper.class);
//        List<User> userList = userMapper.findUserName("%b%");
        List<User> userList = userMapper.findUserName("b");
        System.out.println(userList);
    }

    @Test
    public void testFindUserByVo() throws IOException {
        SqlSession session = MybatisUtils.getSession();
        UserMapper userMapper = session.getMapper(UserMapper.class);

        QueryVo vo = new QueryVo();

        User user = new User();
        user.setUsername("王哈哈");

        vo.setUser(user);

        User u = userMapper.findUserByVo(vo);//核心假设法
        System.out.println(u);
        int count = userMapper.findCount();
        System.out.println(count);
        MybatisUtils.closeNotCommit();
    }

    @Test
    public void testMoreWhere() {
        SqlSession session = MybatisUtils.getSession();
        UserMapper userMapper = session.getMapper(UserMapper.class);
        User user = new User();
        user.setId(1);
        user.setUsername("%王%");
        user.setAddress("深圳");
//user.setAddress("北京");

        List<User> list = userMapper.testMoreWhere(user);
        System.out.println(list);
        MybatisUtils.closeNotCommit();
    }

    @Test
    public void testMoreForeach() {
        SqlSession session = MybatisUtils.getSession();
        UserMapper userMapper = session.getMapper(UserMapper.class);
//根据集合id得到对应集合用户,foreach
        List<Integer> ids = new ArrayList<Integer>();
        ids.add(1);
        ids.add(2);
        ids.add(3);

        List<User> list = userMapper.testMoreForeach(ids);
        System.out.println(list);
        MybatisUtils.closeNotCommit();
    }
    @Test
    public void testFindAccountById(){
        SqlSession session = MybatisUtils.getSession();
        AccountMapper accountMapper = session.getMapper(AccountMapper.class);

        Integer aid =1;
        Account account= accountMapper.testFindAccountById(aid);
        System.out.println(account);
        MybatisUtils.closeNotCommit();
    }

    @Test
    public void testFindUserById(){
        SqlSession session = MybatisUtils.getSession();
        AccountMapper accountMapper = session.getMapper(AccountMapper.class);

        Integer uid =1;
        User user= accountMapper.testFindUserById(uid);
        System.out.println(user);
        MybatisUtils.closeNotCommit();
    }
    @Test
    public void testFindRoles(){
        SqlSession session = MybatisUtils.getSession();
        RoleMapper roleMapper = session.getMapper(RoleMapper.class);


        List<Role> roles= roleMapper.FindRoles();

        roles.forEach(System.out::println);
        MybatisUtils.closeNotCommit();
    }

    @Test
    public void testFindUsers(){
        SqlSession session = MybatisUtils.getSession();
        UserMapper userMapper = session.getMapper(UserMapper.class);


        List<User> users= userMapper.findUsers();

        users.forEach(System.out::println);
        MybatisUtils.closeNotCommit();
    }


    @Test
    public void testOneToOne(){
        SqlSession session = MybatisUtils.getSession();
        AccountMapper accountMapper = session.getMapper(AccountMapper.class);

        Integer uid = 1;
        Account account= accountMapper.findAccountById(uid);
        System.out.println(account);
        MybatisUtils.closeNotCommit();
    }

    @Test
    public void testOneToMore(){
        SqlSession session = MybatisUtils.getSession();
        UserMapper userMapper = session.getMapper(UserMapper.class);

        User user = userMapper.findUserByUsername1("王哈哈");
        //测试延迟加载
//        System.out.println(user.getUsername());
        System.out.println(user);

        MybatisUtils.closeNotCommit();
    }

    @Test
    public void testFindUser(){
        SqlSession session = MybatisUtils.getSession();
        UserMapper userMapper = session.getMapper(UserMapper.class);
        User user = userMapper.findUser("王哈哈", "深圳");
        System.out.println(user);
        MybatisUtils.closeNotCommit();
    }

    @Test
    public void testFindUser5() {
        SqlSession session = MybatisUtils.getSession();
        UserMapper userMapper = session.getMapper(UserMapper.class);

        //条件
        User user = new User();
        user.setUsername("王哈哈");
        user.setAddress("深圳");//等值

        List<User> users = userMapper.findUsers5(user);
        System.out.println(users);

        MybatisUtils.closeNotCommit();
    }

}
