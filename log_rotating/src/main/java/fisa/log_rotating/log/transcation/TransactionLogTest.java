package fisa.log_rotating.log.transcation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TransactionLogTest {
    private static final Logger log = LoggerFactory.getLogger(TransactionLogTest.class);

    public static void write() {
        log.info("TRANS: 입출금 테스트 로그 - 계좌=123-456, 금액=10000");
        log.warn("TRANS: 경고 테스트 로그");
    }
}