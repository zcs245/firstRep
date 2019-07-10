package cn.mjrj.myproject.dal.impl;

import cn.mjrj.myproject.dal.ISysTeskScheduleDao;
import cn.mjrj.myproject.entity.SysTeskSchedule;
import cn.mjrj.myproject.utils.Pager;

import java.util.List;

public class SysTeskScheduleDao implements ISysTeskScheduleDao {
    @Override
    public boolean insert(SysTeskSchedule instance) {
        return false;
    }

    @Override
    public boolean delete(String id) {
        return false;
    }

    @Override
    public boolean update(SysTeskSchedule instance, String id) {
        return false;
    }

    @Override
    public SysTeskSchedule findById(Integer id) {
        return null;
    }

    @Override
    public List<SysTeskSchedule> find(SysTeskSchedule instance) {
        return null;
    }

    @Override
    public Pager findWithPage(Pager pager, SysTeskSchedule instance) {
        return null;
    }
}
