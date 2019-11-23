package com.rongrong.powermock.mockstatic;

import com.rongrong.powermock.service.Student;

/**
 * @author rongrong
 * @version 1.0
 * @date 2019/11/23 8:08
 */
public class StudentStaticService {

    /**
     * 获取学生总数
     * @return
     */
    public int getStudentTotal(){
        return StudentUtils.getStudent();
    }

    /**
     * 创建一个学生
     * @param student
     */
    public void createStudent(Student student){
        StudentUtils.createStudent(student);
    }
}
