package DesignPatterns;

/*
单例设计模式一
线程安全
简单实用
类加载时就会实现实例化
 */
public class Mgr01 {
    private static final Mgr01 INSTANCE = new Mgr01();

    private Mgr01() {
    }

    //返回这个单例
    private static Mgr01 getInstance() {
        return INSTANCE;
    }

}
