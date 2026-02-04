package fisa.log_rotating.log.transcation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.concurrent.ThreadLocalRandom;

public class TransactionLogTest {
    private static final Logger log = LoggerFactory.getLogger(TransactionLogTest.class);

    public static void write() {
        // 랜덤 계좌번호 (000-000 형태)
        String account = String.format("%03d-%03d", 
            ThreadLocalRandom.current().nextInt(100, 1000),
            ThreadLocalRandom.current().nextInt(100, 1000));
        
        // 랜덤 금액 (1,000원 ~ 1,000,000원 사이, 1,000원 단위)
        int amount = ThreadLocalRandom.current().nextInt(1, 1001) * 1000;

        log.info("TRANS: 입출금 테스트 로그 - 계좌={}, 금액={}", account, amount);
        log.warn("TRANS: 경고 테스트 로그 - 잔액 부족 위험 계좌: {}", account);
    }
}