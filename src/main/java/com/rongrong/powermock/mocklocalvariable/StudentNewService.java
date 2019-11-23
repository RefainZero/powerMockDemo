package com.rongrong.powermock.mocklocalvariable;

import com.rongrong.powermock.dao.StudentDao;
import com.rongrong.powermock.service.Student;

/**
 * @author rongrong
 * @version 1.0
 * @date 2019/11/17 21:13
 */
public class StudentNewService {


    /**
     * 获取学生个数
     * @return返回学生总数
     */
    public int getTotal() {
        StudentDao studentDao = new StudentDao();
        return studentDao.getTotal();
    }

    /**
     * 创建学生
     * @param student
     */
    public void createStudent(Student student) {
        StudentDao studentDao = new StudentDao();
        studentDao.createStudent(student);
    }
}
