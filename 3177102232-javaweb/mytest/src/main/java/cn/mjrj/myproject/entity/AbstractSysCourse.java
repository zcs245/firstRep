package cn.mjrj.myproject.entity;

public abstract class AbstractSysCourse {
    private Integer courseCode;
    private String courseName;
    private Byte status;

    public AbstractSysCourse() {
    }

    public AbstractSysCourse(Integer courseCode, String courseName, Byte status) {
        this.courseCode = courseCode;
        this.courseName = courseName;
        this.status = status;
    }

    public Integer getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(Integer courseCode) {
        this.courseCode = courseCode;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }
}
