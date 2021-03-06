package com.swing.Singleton;

/**
 * Created by swing on 2016/10/13.
 */
public class LazySingelton {
    /**
     * 懒汉模式
     * 只有用的时候发现INSTANCE为空才去创建实例
     */

    private String name ,sex ,age ,salary;

    private LazySingelton(){
        //body

        try {
            Thread.currentThread().sleep(5000);//毫秒
        }
        catch(Exception e){}
    }


    private static LazySingelton INSTANCE = null;

    public static LazySingelton getINSTANCE(){
        if (INSTANCE == null){
            INSTANCE = new LazySingelton();
            System.out.println("【创建了一个实例】");
        }
        return INSTANCE;
    }

    /**
     * @question: 在多线程高并发的情境下，如果出现new对象耗时过长，有人再去调用getINSTANCE方法。
     * 当前对象还未初始化完成，所以又会new对象，周而复始，这就违反了单例的初衷。
     * so , we need synchronized
     */
}
