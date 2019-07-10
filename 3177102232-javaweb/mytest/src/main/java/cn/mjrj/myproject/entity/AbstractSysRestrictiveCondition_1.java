package cn.mjrj.myproject.entity;

public abstract class AbstractSysRestrictiveCondition_1 {
    private AbstractSysCourse restrictiveCode;
    private String courseType;
    private String title;
    private Byte status;

    public AbstractSysRestrictiveCondition_1() {
    }

    public AbstractSysRestrictiveCondition_1(AbstractSysCourse restrictiveCode, String courseType, String title, Byte status) {
        this.restrictiveCode = restrictiveCode;
        this.courseType = courseType;
        this.title = title;
        this.status = status;
    }

    public AbstractSysCourse getRestrictiveCode() {
        return restrictiveCode;
    }

    public void setRestrictiveCode(AbstractSysCourse restrictiveCode) {
        this.restrictiveCode = restrictiveCode;
    }

    public String getCourseType() {
        return courseType;
    }

    public void setCourseType(String courseType) {
        this.courseType = courseType;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }
}
