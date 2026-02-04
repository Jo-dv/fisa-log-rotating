package fisa.log_rotating.log.system;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SystemLogTest {
    private static final Logger log = LoggerFactory.getLogger(SystemLogTest.class);

    public static void write() {
        log.info("SYSTEM: 일반 정보 로그");
        log.debug("SYSTEM: 디버그 로그(루트가 INFO면 안 보일 수 있음)");
        log.error("SYSTEM: 에러 로그(예외 테스트)", new RuntimeException("테스트 예외"));
    }
}