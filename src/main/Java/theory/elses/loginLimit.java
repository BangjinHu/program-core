package theory.elses;

import java.time.LocalTime;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class loginLimit {

    private volatile static Map<String, List<Long>> userMap = new ConcurrentHashMap<>();

    public static void main(String[] args) throws InterruptedException {
        String userId = "123";
        Long timeWindow = 60000L;
        int count = 5;
        while (true) {
            System.out.println(LocalTime.now().toString() + " -> " + canLogin(userId, count, timeWindow));
            Thread.sleep(1000 * new Random().nextInt(10));
        }
    }

    public static boolean canLogin(String userId, int count, long timeWindow) {
        if (userId == null || userId.length() == 0) {
            return false;
        }
        long nowTime = System.currentTimeMillis();
        List<Long> userIdList = userMap.computeIfAbsent(userId, k -> new LinkedList<>());
        if (userIdList.size() < count) {
            userIdList.add(0, nowTime);
            return true;
        }
        long fairTime = userIdList.get(count - 1);
        if (nowTime - fairTime <= timeWindow) {
            return false;
        } else {
            userIdList.remove(count - 1);
            userIdList.add(0, nowTime);
            return true;
        }
    }
}
