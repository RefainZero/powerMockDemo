package com.rongrong.powermock.mockprivate;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static junit.framework.TestCase.assertTrue;

/**
 * @author rongrong
 * @version 1.0
 * @description:
 * @date 2019/12/5 21:54
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest(StudentPrivateService.class)
public class TestStudentPrivateService {

    @Test
    public void testStudentPrivateService(){
        StudentPrivateService studentPrivateService = PowerMockito.spy(new StudentPrivateService());
        try {
            PowerMockito.doAnswer(new Answer<Integer>() {
                @Override
                public Integer answer(InvocationOnMock invocation) throws Throwable {
                    String arg= (String) invocation.getArguments()[0];
                    if("rongrong".equals(arg)){
                        return 1;
                    }else {
                        return 0;
                    }
                }
            }).when(studentPrivateService,"checkExist","rongrong");
            boolean exist = studentPrivateService.isExist("rongrong");
            assertTrue(exist);
            PowerMockito.verifyPrivate(studentPrivateService).invoke("checkExist","rongrong");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
