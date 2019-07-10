package cn.mjrj.myproject.dal.impl;

import cn.mjrj.myproject.dal.ISysUserDao;
import cn.mjrj.myproject.entity.SysUser;
import cn.mjrj.myproject.utils.Pager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class SysUserDao implements ISysUserDao {
    @Override
    public boolean insert(SysUser instance) {
        return false;
    }

    @Override
    public boolean delete(String id) {
        return false;
    }

    @Override
    public boolean update(SysUser instance, String id) {
        return false;
    }

    @Override
    public SysUser findById(Integer id) {
        return null;
    }

    @Override
    public List<SysUser> find(SysUser instance) {
        String sql ="SELECT * FROM sys_users WHERE id=? AND password=? AND sys_users.user=?";
        List<SysUser> users = new ArrayList<>();
        try {
            Connection conn = DbHelper.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, instance.getId());
            pstmt.setInt(2, instance.getPassWord());
            pstmt.setString(3, instance.getUser());
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                users.add(instance);
                return users;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;}

    @Override
    public Pager findWithPage(Pager pager, SysUser instance) {
        return null;
    }
}
