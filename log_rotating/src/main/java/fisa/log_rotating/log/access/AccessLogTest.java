package fisa.log_rotating.log.access;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.concurrent.ThreadLocalRandom;

public class AccessLogTest {
    private static final Logger log = LoggerFactory.getLogger(AccessLogTest.class);

    public static void write() {
        // 랜덤 userId (100~999 사이)
        String userId = "user" + ThreadLocalRandom.current().nextInt(100, 1000);
        // 랜덤 IP 생성
        String ip = String.format("192.168.0.%d", ThreadLocalRandom.current().nextInt(1, 255));

        log.info("사용자 로그인: userId={}, ip={}", userId, ip);
        log.info("사용자 로그아웃: userId={}", userId);
    }
}