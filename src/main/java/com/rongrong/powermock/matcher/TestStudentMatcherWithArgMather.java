package com.rongrong.powermock.matcher;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatcher;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.fail;

/**
 * @author rongrong
 * @version 1.0
 * @description:
 * @date 2019/12/3 21:23
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest(StudentController.class)
public class TestStudentMatcherWithArgMather {

    @Test
    public void testStudentMatcherWithArgMather(){
        StundentMatcherService stundentMatcherService = PowerMockito.mock(StundentMatcherService.class);
        PowerMockito.when(stundentMatcherService.getPhoneNum(Mockito.argThat(new ArgumentMatcher<String>() {
            @Override
            public boolean matches(Object argument) {
                String arg=(String)argument;
                if(arg.startsWith("rr")||arg.contains("rongrong"))
                    return true;
                else
                    return false;
                    //使用运行时异常也可，只是使用后看不到，匹配不到情况返回值效果
                   //throw new RuntimeException();
            }
        }))).thenReturn("010-888888888");
        try {
            PowerMockito.whenNew(StundentMatcherService.class).withAnyArguments().thenReturn(stundentMatcherService);
            StudentController studentController = new StudentController();
            //验证存在的时候，返回匹配结果
            String phoneNum = studentController.getPhoneNum("rr");
            assertEquals("010-888888888",phoneNum);
            //验证不存在的时候，返回null
            phoneNum = studentController.getPhoneNum("jiuqujian");
            assertEquals("010-888888888",phoneNum);
        } catch (Exception e) {
            fail("test fail!!!");
        }

    }
}
