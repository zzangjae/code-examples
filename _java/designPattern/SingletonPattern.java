package _java.designPattern;


public class SingletonPattern {

    /*
     Eager Initialization
     가장 간단한 방법으로, 클래스가 로드될 때 싱글톤 인스턴스를 생성합니다.
     이 방법은 구현이 간단하고 thread-safe 하지만, 인스턴스가 필요 없더라도 클래스가 로드될 때 인스턴스를 생성하므로 메모리 낭비가 발생할 수 있습니다.
     */
    public static class EagerSingleton {
        // 클래스 로드 시점에 인스턴스 생성
        private static final EagerSingleton instance = new EagerSingleton();

        // private 생성자
        private EagerSingleton() {}

        // 인스턴스 반환 메소드
        public static EagerSingleton getInstance() {
            return instance;
        }
    }

    /*
    Lazy Initialization
    인스턴스가 필요할 때 생성하는 방법으로, 메모리 절약이 가능합니다.
    이 방법은 thread-safe를 보장하지만, getInstance 메소드에서 synchronized 키워드 사용으로 인한 성능 저하가 발생할 수 있습니다.
     */
    public static class LazySingleton {
        // 인스턴스 변수를 미리 생성하지 않음
        private static LazySingleton instance;

        // private 생성자
        private LazySingleton() {}

        // synchronized 키워드로 thread-safe 보장
        public static synchronized LazySingleton getInstance() {
            if (instance == null) {
                instance = new LazySingleton();
            }
            return instance;
        }
    }

    /*
     Double-Checked Locking
     Lazy Initialization의 성능 문제를 해결하기 위한 방법입니다.
     volatile 키워드를 사용하여 인스턴스 변수에 대한 변경이 즉시 다른 스레드에 반영되도록 합니다.
     */
    public static class DCLSingleton {
        private static volatile DCLSingleton instance;

        private DCLSingleton() {}

        public static DCLSingleton getInstance() {
            if (instance == null) {
                synchronized (DCLSingleton.class) {
                    if (instance == null) {
                        instance = new DCLSingleton();
                    }
                }
            }
            return instance;
        }
    }

    /*
    Bill Pugh Singleton Design
    내부 정적 클래스를 사용하여 Lazy Initialization과 thread-safe를 동시에 달성할 수 있습니다.
    이 방법은 클래스가 로드될 때 내부 클래스가 로드되지 않으므로, Lazy Initialization을 보장하면서도 thread-safe합니다.
     */
    public static class BPSingleton {
        private BPSingleton() {}

        private static class SingletonHelper {
            private static final BPSingleton INSTANCE = new BPSingleton();
        }

        public static BPSingleton getInstance() {
            return SingletonHelper.INSTANCE;
        }
    }
}
