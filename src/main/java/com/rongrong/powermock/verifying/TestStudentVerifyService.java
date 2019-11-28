package com.rongrong.powermock.verifying;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

/**
 * @author rongrong
 * @version 1.0
 * @date 2019/11/26 22:05
 */
@RunWith(PowerMockRunner.class)
//提前将StudentVerifyService这个类准备好
@PrepareForTest(StudentVerifyService.class)
public class TestStudentVerifyService {

    @Test
    public void testStudentLessThanZero(){
        //mock一个假对象
        StudentVerifyDao studentVerifyDao = PowerMockito.mock(StudentVerifyDao.class);
        //mock对象构造过程
        try {
            PowerMockito.whenNew(StudentVerifyDao.class).withNoArguments().thenReturn(studentVerifyDao);
            Student student = new Student();
            //模拟当调用查询学生个数时候，没有找到，我给了0
            PowerMockito.when(studentVerifyDao.getStudentCount(student)).thenReturn(0);
            StudentVerifyService studentVerifyService = new StudentVerifyService();
            //调用保存并更新方法
            studentVerifyService.saveOrUpdate(student);
            //没有那么走的就是保存方法啦
            Mockito.verify(studentVerifyDao).saveStudent(student);
            //这里就不走更新了，所以用了mockito.never()方法
            Mockito.verify(studentVerifyDao,Mockito.never()).updateStudent(student);
            Mockito.verify(studentVerifyDao, Mockito.atLeast(1)).saveStudent(student);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testStudentMoreThanZero(){
        //mock一个假对象
        StudentVerifyDao studentVerifyDao = PowerMockito.mock(StudentVerifyDao.class);
        Student student = new Student();
        try {
            //mock对象构造过程即局部变量构造
            PowerMockito.whenNew(StudentVerifyDao.class).withNoArguments().thenReturn(studentVerifyDao);
            //模拟调用查询学生存在，那么返回值给1即可
            PowerMockito.when(studentVerifyDao.getStudentCount(student)).thenReturn(1);
            StudentVerifyService studentVerifyService = new StudentVerifyService();
            //调用保存并更新方法
            studentVerifyService.saveOrUpdate(student);
            ////如果存在，这里要去更新学生信息
            Mockito.verify(studentVerifyDao).updateStudent(student);
            ////Mockito.never()后就不会走保存的方法了
            Mockito.verify(studentVerifyDao,Mockito.never()).saveStudent(student);
            //至少一次保存
            Mockito.verify(studentVerifyDao, Mockito.atLeastOnce()).saveStudent(student);
            //想要调用的次数
            Mockito.verify(studentVerifyDao, Mockito.times(1)).saveStudent(student);
            //最多调用1次保存
            Mockito.verify(studentVerifyDao, Mockito.atMost(1)).saveStudent(student);
            //最少调用1次保存
            Mockito.verify(studentVerifyDao, Mockito.atLeast(1)).saveStudent(student);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
