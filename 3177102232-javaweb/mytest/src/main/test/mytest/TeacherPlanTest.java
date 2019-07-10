package mytest;

import cn.mjrj.myproject.dal.ISysClassesDao;
import cn.mjrj.myproject.dal.ISysCourseDao;
import cn.mjrj.myproject.dal.ISysTeacherPlanDao;
import cn.mjrj.myproject.dal.impl.SysClassesDao;
import cn.mjrj.myproject.dal.impl.SysCourseDao;
import cn.mjrj.myproject.dal.impl.SysTeacherPlanDao;
import cn.mjrj.myproject.entity.SysClasses;
import cn.mjrj.myproject.entity.SysCourse;
import cn.mjrj.myproject.entity.SysTeacherPlan;
import org.junit.Test;

public class TeacherPlanTest {
    @Test
    public void insertTest() {
        SysClasses sysClasses = new SysClasses();
        sysClasses.setClassNumber("软件2班");
        sysClasses.setStatus((byte) 9);
        ISysClassesDao dao = new SysClassesDao();
        dao.insert(sysClasses);

        SysCourse sysCourse = new SysCourse();
        sysCourse.setCourseCode(102);
        sysCourse.setCourseName("测试");
        sysCourse.setStatus((byte) 9);
        ISysCourseDao dao2 = new SysCourseDao();
        dao2.insert(sysCourse);

        SysTeacherPlan teacherPlan = new SysTeacherPlan();
        teacherPlan.setCnum(sysClasses);
        teacherPlan.setCode(sysCourse);
        teacherPlan.setCourseHour(10);
        teacherPlan.setStatus((byte) 9);
        ISysTeacherPlanDao dao3 = new SysTeacherPlanDao();
        dao3.insert(teacherPlan);
    }

    @Test
    public void deleteTest() {
        String classNumber = "软件2班";
        Integer courseCode = 102;
        String mark = classNumber + "-" + courseCode;
        ISysTeacherPlanDao dao3 = new SysTeacherPlanDao();
        dao3.delete(mark);
        ISysClassesDao dao = new SysClassesDao();
        dao.delete(classNumber);
        ISysCourseDao dao2 = new SysCourseDao();
        dao2.delete(courseCode.toString());
    }

    @Test
    public void updateTest() {
    }
}