package com.rongrong.powermock.mockfinal;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

/**
 * @author rongrong
 * @version 1.0
 * @date 2019/11/27 22:10
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest(StudentFinalDao.class)
public class TestStudentFinalService {

    @Test
    public void testStudentFinalServiceWithPowerMock(){
        StudentFinalDao studentFinalDao = PowerMockito.mock(StudentFinalDao.class);
        Student student = new Student();
        PowerMockito.when(studentFinalDao.isInsert(student)).thenReturn(true);
        StudentFinalService studentFinalService = new StudentFinalService(studentFinalDao);
        studentFinalService.createStudent(student);
        Mockito.verify(studentFinalDao).isInsert(student);
    }
}
