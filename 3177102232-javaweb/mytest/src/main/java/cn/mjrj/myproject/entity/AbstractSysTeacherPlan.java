package cn.mjrj.myproject.entity;

public abstract class AbstractSysTeacherPlan {
    private Integer courseHour;
    private Byte status;
    private AbstractSysClasses cnum;
    private AbstractSysCourse code;

    public AbstractSysTeacherPlan() {
    }

    public AbstractSysTeacherPlan(Integer courseHour, Byte status, AbstractSysClasses cnum, AbstractSysCourse code) {
        this.courseHour = courseHour;
        this.status = status;
        this.cnum = cnum;
        this.code = code;
    }

    public Integer getCourseHour() {
        return courseHour;
    }

    public void setCourseHour(Integer courseHour) {
        this.courseHour = courseHour;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public AbstractSysClasses getCnum() {
        return cnum;
    }

    public void setCnum(AbstractSysClasses cnum) {
        this.cnum = cnum;
    }

    public AbstractSysCourse getCode() {
        return code;
    }

    public void setCode(AbstractSysCourse code) {
        this.code = code;
    }
}