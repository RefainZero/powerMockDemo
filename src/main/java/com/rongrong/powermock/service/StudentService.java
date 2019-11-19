package com.rongrong.powermock.service;

import com.rongrong.powermock.dao.StudentDao;

/**
 * @author rongrong
 * @version 1.0
 * @date 2019/11/17 21:13
 */
public class StudentService {
    private StudentDao studentDao;

    public StudentService(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    /**
     * 获取学生个数
     *
     * @param studentDao
     */
    public int getTotal(StudentDao studentDao) {
        return studentDao.getTotal();
    }
}
