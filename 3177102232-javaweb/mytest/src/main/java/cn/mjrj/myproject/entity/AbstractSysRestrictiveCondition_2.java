package cn.mjrj.myproject.entity;

public abstract class AbstractSysRestrictiveCondition_2 {
    private AbstractSysTeachers tid;
    private Integer minWeekHour;
    private Integer maxWeekHour;
    private Integer maxCourseNumber;
    private Byte status;

    public AbstractSysRestrictiveCondition_2() {
    }

    public AbstractSysRestrictiveCondition_2(AbstractSysTeachers tid, Integer minWeekHour, Integer maxWeekHour, Integer maxCourseNumber, Byte status) {
        this.tid = tid;
        this.minWeekHour = minWeekHour;
        this.maxWeekHour = maxWeekHour;
        this.maxCourseNumber = maxCourseNumber;
        this.status = status;
    }

    public AbstractSysTeachers getTid() {
        return tid;
    }

    public void setTid(AbstractSysTeachers tid) {
        this.tid = tid;
    }

    public Integer getMinWeekHour() {
        return minWeekHour;
    }

    public void setMinWeekHour(Integer minWeekHour) {
        this.minWeekHour = minWeekHour;
    }

    public Integer getMaxWeekHour() {
        return maxWeekHour;
    }

    public void setMaxWeekHour(Integer maxWeekHour) {
        this.maxWeekHour = maxWeekHour;
    }

    public Integer getMaxCourseNumber() {
        return maxCourseNumber;
    }

    public void setMaxCourseNumber(Integer maxCourseNumber) {
        this.maxCourseNumber = maxCourseNumber;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }
}