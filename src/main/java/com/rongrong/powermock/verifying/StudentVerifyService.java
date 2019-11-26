package com.rongrong.powermock.verifying;

import org.junit.Test;

/**
 * @author rongrong
 * @version 1.0
 * @date 2019/11/26 21:05
 */
public class StudentVerifyService {

    public void saveOrUpdate(Student student) {
        final StudentVerifyDao verifyDao = new StudentVerifyDao();
        int count = verifyDao.getStudentCount(student);
        if (count > 0) {
            verifyDao.updateStudent(student);
        } else {
            verifyDao.saveStudent(student);
        }
    }

    @Test
    public void test(){
        StudentVerifyService verifyService = new StudentVerifyService();
        verifyService.saveOrUpdate(new Student());
    }
}
