package cn.mjrj.myproject.dal;

import cn.mjrj.myproject.utils.Pager;

import java.util.List;

public interface IBaseDao<T> {
    boolean insert(T instance);
    boolean delete(String id);
    boolean update(T instance,String id);
    T findById(Integer id);
    List<T>find(T instance);
    Pager findWithPage(Pager pager, T instance);
}
