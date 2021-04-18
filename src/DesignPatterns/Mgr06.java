package DesignPatterns;

/**
 * 比较完美的
 * 双重检查
 */
public class Mgr06 {
    private static Mgr06 INSTANCE;

    private Mgr06() {
    }

    //    public static synchronized Mgr03 getINSTANCE() {
    public static  Mgr06 getINSTANCE() {
        if (INSTANCE == null) {         //必要的
            synchronized (Mgr06.class) {
                if (INSTANCE == null)
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                INSTANCE = new Mgr06();
            }
        }
        return INSTANCE;
    }

}
