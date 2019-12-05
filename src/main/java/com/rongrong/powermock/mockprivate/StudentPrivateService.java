package com.rongrong.powermock.mockprivate;

/**
 * @author rongrong
 * @version 1.0
 * @description:
 * @date 2019/12/5 21:48
 */
public class StudentPrivateService {

    public boolean isExist(String userName) {
        int count = checkExist(userName);
        if (count > 0) {
            return true;
        } else {
            throw new NullPointerException();
        }

    }

    private int checkExist(String userName) {
        throw new UnsupportedOperationException();
    }


}
