package mytest;

import cn.mjrj.myproject.dal.ISysClassesDao;
import cn.mjrj.myproject.dal.impl.SysClassesDao;
import cn.mjrj.myproject.entity.SysClasses;
import org.junit.Test;

public class ClassTest {

    @Test
    public void insertTest(){
        SysClasses sysClasses = new SysClasses();
        sysClasses.setClassNumber("软件2班");
        sysClasses.setStatus((byte)9);
        ISysClassesDao dao = new SysClassesDao();
        dao.insert(sysClasses);
    }

    @Test
    public void deleteTest(){
        String classNumber = "软件2班";
        ISysClassesDao dao = new SysClassesDao();
        dao.delete(classNumber);
    }

    @Test
    public void updateTest(){
        String oldClassNumber = "软件2班";
        SysClasses sysClasses = new SysClasses();
        sysClasses.setClassNumber("软件1班");
        sysClasses.setStatus((byte)9);
        ISysClassesDao dao = new SysClassesDao();
        dao.update(sysClasses,oldClassNumber);
    }
}
