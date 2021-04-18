package DesignPatterns;

/**
 * 采用静态内部类的
 * 可以实习懒单例
 * 线程安全
 */
public class Mgr07 {
    private Mgr07() {
    }

    private static class Mgr07Holder {
        private final static Mgr07 INSTANCE = new Mgr07();
    }

    public static Mgr07 getInstance() {
        return Mgr07Holder.INSTANCE;
    }
}
