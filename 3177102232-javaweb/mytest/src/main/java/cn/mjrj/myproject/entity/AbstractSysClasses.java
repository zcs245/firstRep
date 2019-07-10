package cn.mjrj.myproject.entity;

public abstract class  AbstractSysClasses {
    private String classNumber;
    private String classType;
    private Byte status;

    public AbstractSysClasses() {
    }

    public AbstractSysClasses(String classNumber, String classType, Byte status) {
        this.classNumber = classNumber;
        this.classType = classType;
        this.status = status;
    }

    public String getClassNumber() {
        return classNumber;
    }

    public void setClassNumber(String classNumber) {
        this.classNumber = classNumber;
    }

    public String getClassType() {
        return classType;
    }

    public void setClassType(String classType) {
        this.classType = classType;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }
}
