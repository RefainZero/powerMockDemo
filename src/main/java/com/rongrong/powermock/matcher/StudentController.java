package com.rongrong.powermock.matcher;

/**
 * @description:controller调用service
 * @author rongrong
 * @version 1.0
 * @date 2019/12/3 20:55
 */
public class StudentController {

    public String getPhoneNum(String userName){
        StundentMatcherService stundentMatcherService = new StundentMatcherService();
        return stundentMatcherService.getPhoneNum(userName);
    }
}
