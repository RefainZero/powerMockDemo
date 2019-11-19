package com.rongrong.powermock.service;

import com.rongrong.powermock.dao.StudentDao;
import org.powermock.api.mockito.PowerMockito;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * @author rongrong
 * @version 1.0
 * @date 2019/11/17 21:19
 */
public class StudentServiceTest {

    @Test
    public void testGetStudentTotal() {
        StudentDao studentDao = PowerMockito.mock(StudentDao.class);
        PowerMockito.when(studentDao.getTotal()).thenReturn(666);
        StudentService studentService = new StudentService(studentDao);
        int total = studentService.getTotal(studentDao);
        Assert.assertEquals(total, 666);
    }


}
