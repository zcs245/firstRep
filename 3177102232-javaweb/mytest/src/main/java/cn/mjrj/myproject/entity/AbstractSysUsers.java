package cn.mjrj.myproject.entity;

public abstract class AbstractSysUsers {
    private String user;
    private Integer id;
    private Integer passWord;
    private Byte status;

    public AbstractSysUsers() {
    }

    public AbstractSysUsers(String user, Integer id, Integer passWord, Byte status) {
        this.user = user;
        this.id = id;
        this.passWord = passWord;
        this.status = status;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPassWord() {
        return passWord;
    }

    public void setPassWord(Integer passWord) {
        this.passWord = passWord;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }
}
