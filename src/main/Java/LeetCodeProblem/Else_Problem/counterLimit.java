package LeetCodeProblem.Else_Problem;

import java.util.concurrent.atomic.AtomicLong;

public class counterLimit {

    public static void main(String[] args) {
        AtomicLong zero = new AtomicLong(0);
        AtomicLong count = zero;
        long basicTime = System.currentTimeMillis();
        long upTimeLimt = 1000;
        long permits = 10;
        System.out.println(countRateLimit(basicTime, upTimeLimt, count, permits, zero));
    }

    public static boolean countRateLimit(long basicTime, long upTimeLimit, AtomicLong count,
                                         long permits, AtomicLong zero) {
        long nowTime = System.currentTimeMillis();
        if (nowTime - basicTime < upTimeLimit) {
            if (count.get() < permits) {
                count.incrementAndGet();
                return true;
            } else {
                return false;
            }
        } else {
            count = zero;
            basicTime = nowTime;
            return false;
        }
    }
}
