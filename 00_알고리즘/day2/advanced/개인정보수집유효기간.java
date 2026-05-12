import java.util.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        List<Integer> answer = new ArrayList<>();

        int todayTotalDays = getDays(today);

        Map<String, Integer> termMap = new HashMap<>();
        for (String t : terms) {
            String[] split = t.split(" ");
            termMap.put(split[0], Integer.parseInt(split[1]) * 28);
        }

        for (int i = 0; i < privacies.length; i++) {
            String[] split = privacies[i].split(" ");
            int privacyDays = getDays(split[0]);
            int termDuration = termMap.get(split[1]);

            if (privacyDays + termDuration <= todayTotalDays) {
                answer.add(i + 1);
            }
        }

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }

    private int getDays(String date) {
        int y = Integer.parseInt(date.substring(0, 4));
        int m = Integer.parseInt(date.substring(5, 7));
        int d = Integer.parseInt(date.substring(8, 10));
        return (y * 12 * 28) + (m * 28) + d;
    }
}