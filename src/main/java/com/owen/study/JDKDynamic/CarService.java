package com.owen.study.JDKDynamic;

/**
 * 服务类接口
 * Created by owen on 2017/6/13.
 */
public interface CarService {
    /**
     * 启动汽车
     */
    void start();

    /**
     * 获得汽车搭载人数
     *
     * @return
     */
    int getLoadAmount();

    /**
     * 设置驾驶员
     *
     * @param driver
     * @return
     */
    String setDriver(String driver);
}
