package cn.mjrj.myproject.entity.order;

public class Order {
    String teacherName;
    String time;
    String courseName;
    String courseType;
    String classNumber;

    public Order() {
    }

    public Order(String teacherName, String time, String courseName, String courseType, String classNumber) {
        this.teacherName = teacherName;
        this.time = time;
        this.courseName = courseName;
        this.courseType = courseType;
        this.classNumber = classNumber;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseType() {
        return courseType;
    }

    public void setCourseType(String courseType) {
        this.courseType = courseType;
    }

    public String getClassNumber() {
        return classNumber;
    }

    public void setClassNumber(String classNumber) {
        this.classNumber = classNumber;
    }
}
