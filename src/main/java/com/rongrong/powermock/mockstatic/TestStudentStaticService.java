package com.rongrong.powermock.mockstatic;

import com.rongrong.powermock.service.Student;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

/**
 * @author rongrong
 * @version 1.0
 * @date 2019/11/23 8:41
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest(StudentUtils.class)
public class TestStudentStaticService {

    //@Test
    public void testGetStudnetTotal(){
        StudentStaticService staticService = new StudentStaticService();
        int studentTotal = staticService.getStudentTotal();
        assertEquals(studentTotal,10);
    }

    //@Test
    public void testCreateStudent(){
        StudentStaticService staticService = new StudentStaticService();
        staticService.createStudent(new Student());
        assertTrue(true);
    }

    @Test
    public void testGetStudentWithMock(){
        //先mock工具类对象
        PowerMockito.mockStatic(StudentUtils.class);
        //模拟静态类调用
        PowerMockito.when(StudentUtils.getStudent()).thenReturn(10);
        //构建service
        StudentStaticService service = new StudentStaticService();
        int studentTotal = service.getStudentTotal();
        assertEquals(10,studentTotal);
    }

    @Test
    public void testCreateStudentWithMock(){
        //先模拟静态工具类
        PowerMockito.mockStatic(StudentUtils.class);
        //模拟调用
        PowerMockito.doNothing().when(StudentUtils.class);
        //构建service
        StudentStaticService service = new StudentStaticService();
        Student student = new Student();
        service.createStudent(student);
        //这里用powermock来验证，而不是mock，更体现了powermock的强大
        PowerMockito.verifyStatic();
    }

}
