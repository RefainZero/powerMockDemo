package com.rongrong.powermock.mocklocalvariable;

import com.rongrong.powermock.dao.StudentDao;
import com.rongrong.powermock.service.Student;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * @author rongrong
 * @version 1.0
 * @date 2019/11/20 21:42
 */
@RunWith(PowerMockRunner.class)
//这句注解意思是为我提前准备了StudentNewService的class
@PrepareForTest(StudentNewService.class)
public class TestNewStudentService {

    /**
     * 传统方式测试
     */
    @Test
    public void testGetStudentTotal() {
        StudentNewService studentNewService = new StudentNewService();
        int total = studentNewService.getTotal();
        assertEquals(total, 10);
    }

    /**
     * @desc测试有返回值类型 采用powermock进行测试获取学生个数
     */
    @Test
    public void testGetStudentTotalWithPowerMock() {
        //先模拟一个假对象即studentdao方法中的局部变量
        StudentDao studentDao = PowerMockito.mock(StudentDao.class);
        try {
            //这句话我按照英文理解就是，我用无参的方式new了一个StudentDao对象（模拟录制构造的过程）
            PowerMockito.whenNew(StudentDao.class).withNoArguments().thenReturn(studentDao);
            //再模拟这个对象被调用时，我们默认假定返回10个证明调用成功
            PowerMockito.when(studentDao.getTotal()).thenReturn(10);
            //这里就是service就不用再说了
            StudentNewService studentNewService = new StudentNewService();
            int total = studentNewService.getTotal();
            assertEquals(total, 10);
        } catch (Exception e) {
            fail("测试失败了！！！");
            e.printStackTrace();
        }

    }

    /**
     * @desc测试的无返回值类型 采用powermock进行测试创建学生
     */
    @Test
    public void testCreateStudentWithPowerMock() {
        //先模拟一个假对象即studentdao方法中的局部变量
        StudentDao studentDao = PowerMockito.mock(StudentDao.class);
        try {
            //这句话我按照英文理解就是，我用无参的方式new了一个StudentDao对象
            PowerMockito.whenNew(StudentDao.class).withNoArguments().thenReturn(studentDao);
            Student student = new Student();
            //这句话注释与否都能运行通过，也就是我只能判断他是否被调用
            //PowerMockito.doNothing().when(studentDao).createStudent(student);
            //这里就是service就不用再说了
            StudentNewService studentNewService = new StudentNewService();
            studentNewService.createStudent(student);
            Mockito.verify(studentDao).createStudent(student);
        } catch (Exception e) {
            fail("测试失败了！！！");
            e.printStackTrace();
        }

    }

}
