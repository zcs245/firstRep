package cn.mjrj.myproject.service;

import cn.mjrj.myproject.dal.*;
import cn.mjrj.myproject.dal.impl.*;
import cn.mjrj.myproject.entity.*;
import cn.mjrj.myproject.utils.Pager;

public class Service {

    private SysUser users = new SysUser();

    private ISysUserDao dao = new SysUserDao();
    private ISysCourseDao codao = new SysCourseDao();
    private ISysClassesDao cdao = new SysClassesDao();
    private ISysTeachersDao teachersDao = new SysTeachersDao();
    private ISysStudentsDao sysStudentsDao = new SysStundentsDao();
    private ISysTeacherPlanDao tdao = new SysTeacherPlanDao();
    private ISysLessonPlanDao ldao = new SysLessonPlanDao();
    private ISysRestrictiveConditionDao_1 rdao = new SysRestrictiveConditionDao_1();
    private ISysRestrictiveConditionDao_2 r2dao = new SysRestrictiveConditionDao_2();

    public SysUser login(String id, String passWord, String user) {
        users.setId(Integer.parseInt(id));
        users.setPassWord(Integer.parseInt(passWord));
        users.setUser(user);
        if (dao.find(users) == null) {
            return null;
        } else {
            return users;
        }
    }

    public boolean classesAdd(SysClasses classes){return cdao.insert(classes);}
    public boolean courseAdd(SysCourse course){return codao.insert(course);}
    public boolean teacherPlanAdd(SysTeacherPlan tp){return tdao.insert(tp);}
    public boolean restrictive_1Add(SysRestrictiveCondition_1 re){return rdao.insert(re);}
    public boolean lessonPlanAdd(SysLessonPlan lp){return ldao.insert(lp);}

    public boolean classDelete(String str){return cdao.delete(str);}
    public boolean courseDelete(String str){return codao.delete(str);}
    public boolean teacherPlanDelete(String str){return tdao.delete(str);}
    public boolean restrictive_1Delete(String str){return rdao.delete(str);}
    public boolean lessonPlanDelete(String str){return ldao.delete(str);}

    public boolean lessonPlanUpdate(SysLessonPlan lp,String oldCourseName){return ldao.update(lp, oldCourseName);}
    public boolean restrictive_1Update(SysRestrictiveCondition_1 plan,String str){return rdao.update(plan,str);}
    public boolean restrictive_2Update(SysRestrictiveCondition_2 plan,String str){return r2dao.update(plan,str);}

    public SysTeachers findByIdTea(String id){return teachersDao.findById(Integer.parseInt(id));}
    public SysStudents findByIdStu(String id){return sysStudentsDao.findById(Integer.parseInt(id));}

    public Pager findWithPageUNI(Pager page, SysTeacherPlan plan){return  tdao.findWithPage(page,plan);}
    public Pager findWithPageCOL(Pager page, SysRestrictiveCondition_1 plan){return  rdao.findWithPage(page,plan);}
    public Pager findWithPageTEA(Pager page, SysLessonPlan plan){return  ldao.findWithPage(page,plan);}
    public Pager findWithPageCOL2(Pager page, SysRestrictiveCondition_2 plan){return  r2dao.findWithPage(page,plan);}
}
