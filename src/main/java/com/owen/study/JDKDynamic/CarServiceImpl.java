package com.owen.study.JDKDynamic;

/**
 * 具体的服务类
 * Created by owen on 2017/6/13.
 */
public class CarServiceImpl implements CarService {

    /**
     * 启动汽车
     */
    public void start() {
        System.out.println("start my car...");
    }

    /**
     * 获得汽车搭载人数
     *
     * @return
     */
    public int getLoadAmount() {
        System.out.println("count the person amount in my car...");
        return 5;
    }

    /**
     * 设置驾驶员
     *
     * @param driver
     * @return
     */
    public String setDriver(String driver) {
        System.out.println("driver is:" + driver);
        if (driver == null || "".equals(driver)) {
            return "There is not driver.";
        } else {
            return "The driver's name is " + driver + ".";
        }
    }
}
