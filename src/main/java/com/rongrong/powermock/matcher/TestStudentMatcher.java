package com.rongrong.powermock.matcher;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static junit.framework.TestCase.assertEquals;

/**
 * @description:之前学过的方法测试
 * @author rongrong
 * @version 1.0
 * @date 2019/12/3 21:10
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest(StudentController.class)
public class TestStudentMatcher {

    @Test
    public void testStudentMatcher(){
        StundentMatcherService stundentMatcherService = PowerMockito.mock(StundentMatcherService.class);
        PowerMockito.when(stundentMatcherService.getPhoneNum("xiaoqiang")).thenReturn("15111111111");
        try {
            PowerMockito.whenNew(StundentMatcherService.class).withAnyArguments().thenReturn(stundentMatcherService);
            StudentController studentController = new StudentController();
            String phoneNum = studentController.getPhoneNum("xiaoqiang");
            assertEquals("15111111111",phoneNum);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
