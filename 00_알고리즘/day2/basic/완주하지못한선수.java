import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        Map<String, Integer> map = new HashMap();
        for(String s : participant) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }

        for(String s : completion) {
            if(map.containsKey(s)) {
                map.put(s, map.get(s) - 1);
            }
        }

        for (Map.Entry<String, Integer> e : map.entrySet()) {
            if(e.getValue() > 0) {
                return e.getKey();
            }
        }

        // 시간초과
//        Arrays.sort(participant);
//        Arrays.sort(completion);
//        for(int i = 0; i < completion.length; i++) {
//            if(!participant[i].equals(completion[i])) {
//                return participant[i];
//            }
//        }
//        return participant[participant.length - 1];

        return "";
    }
}