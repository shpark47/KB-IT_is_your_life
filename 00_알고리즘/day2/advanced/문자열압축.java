class Solution {
    public int solution(String s) {
        int answer = 100000;
        int len = s.length();

        if(len == 1) return 1;

        for(int i = 1; i <= len / 2; i++) {
            StringBuilder sb = new StringBuilder();
            String prev = "";
            int count = 1;

            for(int j = 0; j <= len - i; j += i) {
                String str = s.substring(j, j + i);

                if(prev.equals(str)) {
                    count++;
                    continue;
                } else if(count > 1) {
                    sb.append(count + prev);
                    count = 1;
                } else {
                    sb.append(prev);
                }
                prev = str;
            }

            sb.append(count > 1 ? count + prev : prev);

            if(len % i != 0) {
                sb.append(s.substring(len - len % i, len));
            }

            answer = Math.min(answer, sb.length());
            sb = new StringBuilder();
        }
        return answer;
    }
}