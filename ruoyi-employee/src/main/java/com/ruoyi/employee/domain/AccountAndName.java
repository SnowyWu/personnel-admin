package com.ruoyi.employee.domain;

import com.ruoyi.common.annotation.Excel;

public class AccountAndName {
    private static final long serialVersionUID = 1L;

    /** 自增ID */
    private Long id;
    /** 用户名 */
    @Excel(name = "用户名")
    private String username;

    /** 密码 */
    @Excel(name = "密码")
    private String password;

    /** 是否是管理员，1: 管理员, 2: 普通员工 */
    @Excel(name = "是否是管理员，1: 管理员, 2: 普通员工")
    private Integer isAdmin;



    /** 姓名 */
    @Excel(name = "姓名")
    private String name;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(Integer isAdmin) {
        this.isAdmin = isAdmin;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "AccountAndName{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", isAdmin=" + isAdmin +
                ", name='" + name + '\'' +
                '}';
    }
}
