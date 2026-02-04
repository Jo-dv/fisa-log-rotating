package fisa.log_rotating.utils;

import ch.qos.logback.classic.pattern.MessageConverter;
import ch.qos.logback.classic.spi.ILoggingEvent;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MaskingConverter extends MessageConverter {

    // 계좌번호 패턴 (예: 123-456 형태)을 찾는 정규식
    private static final String ACCOUNT_PATTERN = "(\\d{3})-(\\d{3})";

    @Override
    public String convert(ILoggingEvent event) {
        String message = event.getFormattedMessage();

        // 정규식을 사용하여 계좌번호 뒷자리를 마스킹
        Pattern pattern = Pattern.compile(ACCOUNT_PATTERN);
        Matcher matcher = pattern.matcher(message);

        if (matcher.find()) {
            // 앞 3자리는 유지하고 뒤 3자리를 ***로 변경
            return matcher.replaceAll("$1-***");
        }

        return message;
    }
}