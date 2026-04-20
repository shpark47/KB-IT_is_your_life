package object;

public class Day {
    String doing;
    int time;
    String location;
    static int count;

    public String getDoing() {
        return doing;
    }

    public void setDoing(String doing) {
        this.doing = doing;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public static int getCount() {
        return count;
    }

    public Day(String doing, int time, String location) {
        //this는 이 클래스로 만든 객체
        this.doing = doing;
        this.time = time;
        this.location = location;
        count++;
    } //생성자

    //toString()을 수정해서 재정의하자.


    @Override
    public String toString() {
        return "Day{" +
                "doing='" + doing + '\'' +
                ", time=" + time +
                ", location='" + location + '\'' +
                '}';
    }
} //클래스