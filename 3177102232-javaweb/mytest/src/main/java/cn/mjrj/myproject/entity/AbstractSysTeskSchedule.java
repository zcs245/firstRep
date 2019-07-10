package cn.mjrj.myproject.entity;

public abstract class AbstractSysTeskSchedule {
    private String time;
    private String course;
    private String teacher;
    private String classes;
    private Byte status;

    public AbstractSysTeskSchedule() {
    }

    public AbstractSysTeskSchedule(String time, String course, String teacher, String classes, Byte status) {
        this.time = time;
        this.course = course;
        this.teacher = teacher;
        this.classes = classes;
        this.status = status;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public String getClasses() {
        return classes;
    }

    public void setClasses(String classes) {
        this.classes = classes;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }
}
