package com.xxx.bean;

import java.io.Serializable;
import java.util.List;

public class Role implements Serializable {
    private Integer id;
    private String roleName;
    private String roleDesc;

    //多对多,其实就是双向一对多,一个角色对应多个用户,即用户集合↓
    private List<User> users;

    public Role() {
    }

    public Role(Integer id, String roleName, String roleDesc, List<User> users) {
        this.id = id;
        this.roleName = roleName;
        this.roleDesc = roleDesc;
        this.users = users;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleDesc() {
        return roleDesc;
    }

    public void setRoleDesc(String roleDesc) {
        this.roleDesc = roleDesc;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", roleName='" + roleName + '\'' +
                ", roleDesc='" + roleDesc + '\'' +
                ", users=" + users +
                '}';
    }
}