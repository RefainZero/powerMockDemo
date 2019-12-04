package com.rongrong.powermock.spies;

import org.junit.Test;
import org.powermock.api.mockito.PowerMockito;

import java.io.File;

import static junit.framework.TestCase.assertTrue;

/**
 * @author rongrong
 * @version 1.0
 * @description:
 * @date 2019/12/4 23:01
 */
public class TestFileService {

    @Test
    public void testFileService(){
        FileService fileService = PowerMockito.mock(FileService.class);
        fileService.writeData("hellow,rongrong!!");
    }

    @Test
    public void testFileServiceWithSpy(){
        FileService fileService = PowerMockito.spy(new FileService());
        File file = new File(System.getProperty("user.dir") + "/ronngrong.txt");
        fileService.writeData("hellow,RongRong!!");
        assertTrue(file.exists());
    }
}
