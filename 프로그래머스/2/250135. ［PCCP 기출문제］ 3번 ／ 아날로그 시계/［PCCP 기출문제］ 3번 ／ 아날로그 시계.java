class Solution {

    public int solution(int h1, int m1, int s1, int h2, int m2, int s2) {
        int answer = 0;

        // 시간 차이 (밀리초 단위)
        int gapToMilliseconds = ((h2 - h1) * 60 * 60 + (m2 - m1) * 60 + (s2 - s1)) * 1000;

        // 각도 증가량 (밀리초당)
        double degreePerMillisecondOfSecond = 360.0 / (60 * 1000);        // 초침: 360도 / 60초 / 1000ms
        double degreePerMillisecondOfMinute = 360.0 / (60 * 60 * 1000);   // 분침
        double degreePerMillisecondOfHour = 360.0 / (12 * 60 * 60 * 1000);// 시침

        // 초기 각도
        double hourDegree = ((h1 % 12) * 3600 + m1 * 60 + s1) * 1000 * degreePerMillisecondOfHour;
        double minuteDegree = (m1 * 60 * 1000 + s1 * 1000) * degreePerMillisecondOfMinute;
        double secondDegree = s1 * 1000 * degreePerMillisecondOfSecond;

        if (isOverlapped(hourDegree, secondDegree) || isOverlapped(minuteDegree, secondDegree)) {
            answer++;
        }

        for (int i = 1; i <= gapToMilliseconds; i++) {
            hourDegree = (hourDegree + degreePerMillisecondOfHour) % 360;
            minuteDegree = (minuteDegree + degreePerMillisecondOfMinute) % 360;
            secondDegree = (secondDegree + degreePerMillisecondOfSecond) % 360;

            if (isOverlapped(hourDegree, secondDegree) || isOverlapped(minuteDegree, secondDegree)) {
                answer++;
            }
        }

        return answer;
    }

    private boolean isOverlapped(double target, double secondDegree) {
        return Math.abs(target - secondDegree) <= 0.002999;
    }
}
