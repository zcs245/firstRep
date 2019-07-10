package cn.mjrj.myproject.entity;

public abstract class AbstractSysTeachers {
    private String name;
    private String teachSituation;
    private String title;
    private Byte status;
    private AbstractSysUsers id;

    public AbstractSysTeachers() {
    }

    public AbstractSysTeachers(String name, String teachSituation, String title, Byte status, AbstractSysUsers id) {
        this.name = name;
        this.teachSituation = teachSituation;
        this.title = title;
        this.status = status;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTeachSituation() {
        return teachSituation;
    }

    public void setTeachSituation(String teacherSituation) {
        this.teachSituation = teacherSituation;
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

    public AbstractSysUsers getId() {
        return id;
    }

    public void setId(AbstractSysUsers id) {
        this.id = id;
    }
}
