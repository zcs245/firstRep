package cn.mjrj.myproject.entity;

public abstract class AbstractSysLessonPlan {
    private String courseName;
    private String time;
    private Byte status;
    private AbstractSysTeachers tid;

    public AbstractSysLessonPlan() {
    }

    public AbstractSysLessonPlan(String courseName, String time, Byte status, AbstractSysTeachers tid) {
        this.courseName = courseName;
        this.time = time;
        this.status = status;
        this.tid = tid;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public AbstractSysTeachers getTid() {
        return tid;
    }

    public void setTid(AbstractSysTeachers tid) {
        this.tid = tid;
    }
}
