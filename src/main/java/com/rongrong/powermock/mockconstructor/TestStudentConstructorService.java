package com.rongrong.powermock.mockconstructor;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static com.rongrong.powermock.mockconstructor.StudentConstructorDao.DataBaseType.MYSQL;

/**
 * @author rongrong
 * @version 1.0
 * @date 2019/11/28 23:54
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest(StudentConstructorService.class)
public class TestStudentConstructorService {

    @Test
    public void testStudentConstructorService(){
        StudentConstructorDao studentConstructorDao = PowerMockito.mock(StudentConstructorDao.class);
        try {
            //此处需要注释下，需要构造一个带参数的Dao对象，即便是假的也要带参数，该类初始化的时候就带参数
            PowerMockito.whenNew(StudentConstructorDao.class).withArguments(false,MYSQL).thenReturn(studentConstructorDao);
            StudentConstructor studentConstructor = new StudentConstructor();
            StudentConstructorService studentConstructorService = new StudentConstructorService();
            studentConstructorService.createStudnet(studentConstructor);
            Mockito.verify(studentConstructorDao).insertStudent(studentConstructor);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
