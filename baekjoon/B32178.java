package _java.baekjoon;
import java.io.*;
import java.util.*;

/**
 * 아이디어
 * 구간 합을 이용해서 오른쪽 외쪽 합이 가장 비슷한 경우를 구하면 어떨까?
 *
 * 구현
 * 1. 양의 정수 N을 입력 받고 N개의 용액 특성값을 입력 받는다.
 * 2. 0~i 까지의 누적 합을 구한 배열을 구한다.
 * 3. 누적합에 idx를 기록한다. (중복 되는 경우도 크게 상관 없음)
 * 4. 누적 합을 크기 순으로 섞은 다음 가장 인접한 값과 차이가 작은 경우를 구한다.
 * 5. 이전에 매핑 해놓은 idx 값을 이용해 L, R, 특성값 을 구한다.
 */
public class B32178 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] featureNums = new int[n];
        long[] prefixSum = new long[n+1];  // 누적 합을 저장하는 배열
        List<Long> prefixList = new ArrayList<>();  // 누적합 리스트 (정렬에 이용)
        Map<Long, List<Integer>> map = new HashMap<>();  // 각 누적합에 대한 인덱스를 저장

        // prefixSum[0]을 0으로 설정하고 인덱스 0으로 초기화
        prefixSum[0] = 0;
        prefixList.add(0L);
        map.put(0L, new ArrayList<>(Arrays.asList(0)));

        // 입력받고 누적합을 계산
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            featureNums[i] = Integer.parseInt(st.nextToken());
            prefixSum[i + 1] = prefixSum[i] + featureNums[i];
            prefixList.add(prefixSum[i + 1]);

            // 동일한 누적합에 대해 여러 인덱스를 저장
            map.putIfAbsent(prefixSum[i + 1], new ArrayList<>());
            map.get(prefixSum[i + 1]).add(i + 1);
        }

        // 누적합을 정렬
        Collections.sort(prefixList);

        long minDiff = Long.MAX_VALUE;
        long leftFeature = 0, rightFeature = 0;
        int l = 0, r = 0;

        // 인접한 누적합 쌍 중 가장 차이가 작은 구간 찾기
        for (int i = 1; i < prefixList.size(); i++) {
            long diff = Math.abs(prefixList.get(i) - prefixList.get(i - 1));
            if (diff < minDiff) {
                minDiff = diff;
                leftFeature = prefixList.get(i - 1);
                rightFeature = prefixList.get(i);
            }
        }

        // 각 누적합에 대한 인덱스 추출
        List<Integer> leftIndices = map.get(leftFeature);
        List<Integer> rightIndices = map.get(rightFeature);

        // 서로 다른 인덱스를 가지는 가장 가까운 쌍을 찾아서 처리
        for (int leftIdx : leftIndices) {
            for (int rightIdx : rightIndices) {
                if (leftIdx != rightIdx) {
                    l = Math.min(leftIdx, rightIdx);
                    r = Math.max(leftIdx, rightIdx);
                    break;
                }
            }
            if (l != 0 || r != 0) break;  // 인덱스 찾으면 루프 종료
        }

        if (r < l) {
            minDiff = -1 * minDiff;
            int temp = r;
            r = l;
            l = temp;
        }

        // 결과 출력
        System.out.println(minDiff);
        System.out.println(l+1 + " " + r);
    }
}
