package DesignPatterns;

/**
 * 懒汉式
 * 需要时实例化
 * 线程不安全，可能导致多个线程new了实例 使得单例化被打破
 * 解决方法:加锁
 */
public class Mgr03 {
    private static Mgr03 INSTANCE;

    private Mgr03() {
    }

    //    public static synchronized Mgr03 getINSTANCE() {
    public static synchronized Mgr03 getINSTANCE() {
        if (INSTANCE == null) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            INSTANCE = new Mgr03();
        }
        return INSTANCE;
    }

//    public static void main(String[] args) {
//        for (int i = 0; i < 100; i++) {
//            new Thread(()->{
//                System.out.println(Mgr03.getINSTANCE().hashCode());
//            }).start();
//        }
//    }
}
