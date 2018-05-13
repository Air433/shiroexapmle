package com.renjie.entity;

import java.util.List;

/**
 * Created by Air on 2018/5/13.
 */
public class UserInfo {
    private List<SysRole> roleList;
    private int state;

    public List<SysRole> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<SysRole> roleList) {
        this.roleList = roleList;
    }

    public int getState() {
        return state;
    }
}
