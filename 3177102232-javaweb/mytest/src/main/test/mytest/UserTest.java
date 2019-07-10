package mytest;

import cn.mjrj.myproject.dal.ISysUserDao;
import cn.mjrj.myproject.dal.impl.SysTeacherPlanDao;
import cn.mjrj.myproject.dal.impl.SysUserDao;
import cn.mjrj.myproject.entity.SysUser;
import org.junit.Test;

public class UserTest {
    @Test
    public  void find(){
        SysUser user = new SysUser();
        user.setId(111);
        user.setPassWord(123);
        user.setUser("校教务");
        ISysUserDao dao = new SysUserDao();
        dao.find(user);
    }
}
