package com.rongrong.powermock.mockconstructor;

/**
 * @author rongrong
 * @version 1.0
 * @date 2019/11/28 23:18
 */
public class StudentConstructorService {

    public void createStudnet(StudentConstructor studentConstructor){
        StudentConstructorDao studentConstructorDao = new StudentConstructorDao(false, StudentConstructorDao.DataBaseType.MYSQL);
        studentConstructorDao.insertStudent(studentConstructor);
    }
}
