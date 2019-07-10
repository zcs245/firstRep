package mytest;

import cn.mjrj.myproject.dal.ISysCourseDao;
import cn.mjrj.myproject.dal.impl.SysCourseDao;
import cn.mjrj.myproject.entity.SysCourse;
import org.junit.Test;

public class CourseTest {
    @Test
    public void insertTest(){
        SysCourse sysCourse = new SysCourse();
        sysCourse.setCourseCode(101);
        sysCourse.setCourseName("测试");
        sysCourse.setStatus((byte)9);
        ISysCourseDao dao = new SysCourseDao();
        dao.insert(sysCourse);
    }

    @Test
    public void deleteTest(){
        Integer courseCode = 101;
        ISysCourseDao dao = new SysCourseDao();
        dao.delete(courseCode.toString());
    }

    @Test
    public void updateTest(){
        String oldCourseCode = "101";
        SysCourse sysCourse = new SysCourse();
        sysCourse.setCourseCode(102);
        sysCourse.setCourseName("修改");
        sysCourse.setStatus((byte)9);
        ISysCourseDao dao = new SysCourseDao();
        dao.update(sysCourse,oldCourseCode);
    }
}
