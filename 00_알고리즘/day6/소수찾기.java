import java.util.*;

class Solution {
    Set<Integer> set;
    boolean[] visited;
    public int solution(String numbers) {
        set = new HashSet();
        visited = new boolean[numbers.length()];
        backtrack(numbers, visited, "");
        return set.size();
    }

    void backtrack(String numbers, boolean[] visited, String cur) {
        if(cur.length() != 0) {
            int num = Integer.parseInt(cur);
            if(isPrime(num)) set.add(num);
        }
        for(int i = 0; i < numbers.length(); i++) {
            if(!visited[i]) {
                visited[i] = true;
                backtrack(numbers, visited, cur + numbers.charAt(i));
                visited[i] = false;
            }
        }
    }

    boolean isPrime(int num) {
        if(num < 2) return false;
        for(int i = 2; i * i <= num; i++){
            if(num % i == 0) return false;
        }
        return true;
    }
}