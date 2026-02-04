package fisa.log_rotating.log.access;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AccessLogTest  {
    private static final Logger log = LoggerFactory.getLogger(AccessLogTest.class);

    public static void write() {
        log.info("사용자 로그인: userId=test01, ip=127.0.0.1");
        log.info("사용자 로그아웃: userId=test01");
    }
}