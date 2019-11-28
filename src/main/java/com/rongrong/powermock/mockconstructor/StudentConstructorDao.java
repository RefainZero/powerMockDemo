package com.rongrong.powermock.mockconstructor;

/**
 * @author rongrong
 * @version 1.0
 * @date 2019/11/28 23:12
 */
public class StudentConstructorDao {
    public enum DataBaseType{
        MYSQL,
        ORACLE,
    }

    /**
     *
     * @param isLoad 数据库是否加载即链接
     * @param dataBaseType 数据库类型
     */
    public StudentConstructorDao(Boolean isLoad,DataBaseType dataBaseType) {
        throw new UnsupportedOperationException();
    }

    public void insertStudent(StudentConstructor studentConstructor){
        throw new UnsupportedOperationException();
    }
}
