package com.rongrong.powermock.mockfinal;

/**
 * @author rongrong
 * @version 1.0
 * @date 2019/11/27 21:29
 */
public class StudentFinalService {

    private StudentFinalDao studentFinalDao;

    public StudentFinalService(StudentFinalDao studentFinalDao) {
        this.studentFinalDao = studentFinalDao;
    }

    public void createStudent(Student student) {
        studentFinalDao.isInsert(student);
    }
}
