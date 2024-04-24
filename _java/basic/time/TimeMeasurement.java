package _java.basic.time;

public class TimeMeasurement {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();

        for (int i = 0; i < 1000000; i++) {
            System.out.println(i);
        }

        // ms 출력
        System.out.println("출력 소요시간: " + (System.currentTimeMillis() - start));
    }
}
