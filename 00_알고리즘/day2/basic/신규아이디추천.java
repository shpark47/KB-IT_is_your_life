class Solution {
    public String solution(String s) {
        s = s.toLowerCase();

        s = s.replaceAll("[^a-z0-9_.-]", "");

        s = s.replaceAll("[.]{2,}", ".");

        if(s.startsWith(".")) {
            s = s.substring(1, s.length());
        }

        if(s.endsWith(".")) {
            s = s.substring(0, s.length() - 1);
        }

        if(s.equals("")) s = "a";

        if(s.length() > 15) {
            s = s.substring(0, 15);
            if(s.charAt(s.length() - 1) == '.') s = s.substring(0, 14);
        }

        while(s.length() < 3) {
            s = s + s.charAt(s.length() - 1);
        }

        return s;
    }
}