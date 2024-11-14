package _java.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
1. 현금 금액과 MachineDuck의 14일치 주가를 입력받는다. 금액은 int, 주가는 int[14] 에 저장
2. 준현이의 현금, 주식 보유 수량을 변수로 선언한 뒤 14일치 주가에 대해 살 수 있을 때마다 주식을 사는 로직을 구현한다.
3. 성민이도 2번과 같은 방식으로 진행하고 전략에 대해서만 문제에 나와있는 조건들을 빠짐없이 적용한다.
4. 준현이와 성민이의 현금 + 주식 보유 수량 * 14일의 주가를 비교하여 큰 사람의 전략을 출력한다. 같은 경우 SAMESAME 출력
 */

public class B20546 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int firstCash = Integer.parseInt(br.readLine());
        int[] machineDuckPrice = new int[14];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int day=0; day<14; day++) {
            machineDuckPrice[day] = Integer.parseInt(st.nextToken());
        }

        int junhyunCash = firstCash;
        int junhyunStock = 0;

        int sungminCash = firstCash;
        int sungminStock = 0;

        int priceIncreaseCount = 0;
        int priceDecreaseCount = 0;

        for (int day=0; day<14; day++) {

            int todayStockPrice = machineDuckPrice[day];

            // BNP
            if (todayStockPrice <= junhyunCash) {
                junhyunStock = junhyunCash / todayStockPrice;
                junhyunCash = junhyunCash % todayStockPrice;
            }

            // TIMING
            if (day!=0){
                int yesterdayStockPrice = machineDuckPrice[day-1];

                if (todayStockPrice > yesterdayStockPrice) {
                    priceIncreaseCount++;
                    priceDecreaseCount = 0;
                }

                if (todayStockPrice == yesterdayStockPrice) {
                    priceIncreaseCount = 0;
                    priceDecreaseCount = 0;
                }

                if (todayStockPrice < yesterdayStockPrice) {
                    priceIncreaseCount = 0;
                    priceDecreaseCount++;
                }
            }

            if (priceIncreaseCount >= 3) {
                sungminCash += sungminStock * todayStockPrice;
                sungminStock = 0;
            }

            if (priceDecreaseCount >= 3 && todayStockPrice <= sungminCash) {
                sungminStock = sungminCash / todayStockPrice;
                sungminCash = sungminCash % todayStockPrice;
            }
        }

        int junhyunResult = junhyunCash + junhyunStock * machineDuckPrice[13];
        int sungminResult = sungminCash + sungminStock * machineDuckPrice[13];

        if (junhyunResult > sungminResult) {
            System.out.println("BNP");
        }
        if (junhyunResult == sungminResult) {
            System.out.println("SAMESAME");
        }
        if (junhyunResult < sungminResult) {
            System.out.println("TIMING");
        }

    }
}

