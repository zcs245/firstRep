package cn.mjrj.myproject.entity;

public abstract class AbstactSysStudents {
    private String name;
    private Byte status;
    private AbstractSysUsers sid;
    private AbstractSysClasses cnum;

    public AbstactSysStudents() {
    }

    public AbstactSysStudents(String name, Byte status, AbstractSysUsers sid, AbstractSysClasses cnum) {
        this.name = name;
        this.status = status;
        this.sid = sid;
        this.cnum = cnum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public AbstractSysUsers getSid() {
        return sid;
    }

    public void setSid(AbstractSysUsers sid) {
        this.sid = sid;
    }

    public AbstractSysClasses getCnum() {
        return cnum;
    }

    public void setCnum(AbstractSysClasses cnum) {
        this.cnum = cnum;
    }
}
