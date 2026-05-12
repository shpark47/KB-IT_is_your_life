import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        Map<String, Integer> id = new HashMap();
        Map<String, Integer> re = new HashMap();

        for(String s : id_list) {
            id.put(s, 0);
            re.put(s, 0);
        }

        Set<String> set = new HashSet(Arrays.asList(report));
        for(String s : set) {
            String r = s.split(" ")[1];
            if(re.containsKey(r)) {
                re.put(r, re.get(r) + 1);
            }
        }

        for(String a : set) {
            if(re.get(a.split(" ")[1]) >= k) {
                id.put(a.split(" ")[0], id.get(a.split(" ")[0]) + 1);
            }
        }

        for(int i = 0; i < id.size(); i++) {
            answer[i] = id.get(id_list[i]);
        }

        return answer;
    }
}