package com.rongrong.powermock.answers;

/**
 * @author rongrong
 * @version 1.0
 * @description:
 * @date 2019/12/4 20:24
 */
public class StudentController {

    public String getEmail(String userName) {
        StudentAnswerService studentAnswerService = new StudentAnswerService();
        return studentAnswerService.getEmail(userName);
    }
}
