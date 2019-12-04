package com.rongrong.powermock.answers;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.fail;

/**
 * @author rongrong
 * @version 1.0
 * @description:
 * @date 2019/12/4 20:34
 */
@RunWith(PowerMockRunner.class)
//准备调用层
@PrepareForTest(StudentController.class)
public class TestStudentAnswerService {

    @Test
    public void testStudentAnswerService() {
        StudentAnswerService studentAnswerService = PowerMockito.mock(StudentAnswerService.class);
        PowerMockito.when(studentAnswerService.getEmail(Mockito.anyString())).then(new Answer<String>() {
            @Override
            public String answer(InvocationOnMock invocation) throws Throwable {
                String arg = (String) invocation.getArguments()[0];
                if ("rr".equals(arg)) {
                    return "rongrong@qq.com";
                } else if ("jqj".equals(arg)) {
                    return "jiuqujian@qq.com";
                }
                throw new NullPointerException();
            }
        });
        try {
            PowerMockito.whenNew(StudentAnswerService.class).withAnyArguments().thenReturn(studentAnswerService);
            StudentController studentController = new StudentController();
            String email = studentController.getEmail("rr");
            assertEquals("rongrong@qq.com",email);
            email = studentController.getEmail("jqj");
            assertEquals("jiuqujian@qq.com",email);
            email = studentController.getEmail("tony");
            assertEquals("jiuqujian@qq.com",email);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
