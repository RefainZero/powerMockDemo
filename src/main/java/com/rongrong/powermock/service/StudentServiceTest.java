package com.rongrong.powermock.service;

import com.rongrong.powermock.dao.StudentDao;
import org.junit.Test;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;

import static org.junit.Assert.assertEquals;

/**
 * @author rongrong
 * @version 1.0
 * @date 2019/11/17 21:19
 */
public class StudentServiceTest {

    @Test
    public void testGetStudentTotalWithMock() {
        StudentDao studentDao = PowerMockito.mock(StudentDao.class);
        PowerMockito.when(studentDao.getTotal()).thenReturn(666);
        StudentService studentService = new StudentService(studentDao);
        int total = studentService.getTotal(studentDao);
        assertEquals(total, 666);
    }

    @Test
    public void testCreateStudentWithMock() {
        StudentDao studentDao = PowerMockito.mock(StudentDao.class);
        Student student=new Student();
        PowerMockito.doNothing().when(studentDao).createStudent(student);
        StudentService studentService = new StudentService(studentDao);
        studentService.createStudent(student);
        Mockito.verify(studentDao).createStudent(student);
    }


    @Test
    public void testCreateStudent() {
        StudentDao studentDao = new StudentDao();
        Student student=new Student();
        StudentService studentService = new StudentService(studentDao);
        studentService.createStudent(student);
    }

}
