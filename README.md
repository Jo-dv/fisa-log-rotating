# 🚀 금융 로그 수명주기 관리 프로젝트 (Log Rotating)

## 1. 배경 및 목적
- 대규모 트래픽 환경에서 로그로 인한 디스크 고갈 방지
- 장애 대응 속도 향상을 위한 로그 가독성 및 관리 효율 증대

## 2. 핵심 관리 정책 (Implementation)
### logback.xml
- SizeAndTimeBasedRollingPolicy
  ```xml
        <appender name="TRANS_FILE" class="ch.qos.logback.core.rolling.RollingFileAppender">
                <file>${LOG_PATH}/transaction.log</file>
                <rollingPolicy class="ch.qos.logback.core.rolling.SizeAndTimeBasedRollingPolicy">
                    <fileNamePattern>${LOG_PATH}/archived/transaction.%d{yyyy-MM-dd_HH-mm}.%i.log.gz</fileNamePattern>
                    <maxFileSize>1MB</maxFileSize>
                    <maxHistory>90</maxHistory>
                </rollingPolicy>
                <encoder>
                    <pattern>%d{yyyy-MM-dd HH:mm:ss.SSS} [%thread] %-5level - %msg%n</pattern>
                </encoder>
            </appender>
  ```
  - maxFileSize
  : 현재 로그 파일이 maxFileSize를 넘어가면, 현재 기록 중인 파일을 분할(Rolling)하여 ./logs/archived에 저장합니다. 
  - maxHistory
  : 설정한 시간이 지나면 로그를 삭제합니다.
실제 금융 시스템에서는 실시간으로 로그를 DB에 백업한다는 걸 가정하였습니다. 
현재는 테스팅을  위해 fileNamePattern을 yyyy-MM-dd_HH-mm으로 설정하여, maxHistory를 90분으로 설정하였습니다. 
  
- AsyncAppender
  ```xml
        <appender name="ASYNC_TRANS" class="ch.qos.logback.classic.AsyncAppender">
                <appender-ref ref="TRANS_FILE" />
                <queueSize>512</queueSize>
                <discardingThreshold>0</discardingThreshold>
            </appender>
  ```
  : 입출금 요청이 한꺼번에 많이 들어올 경우, 로깅보다는 서비스 처리를 우선으로 진행해야 한다고 생각하여 설정했습니다.
  - queueSize
  : 로그 이벤트 수가 queueSize를 넘어가면, 로깅 작업을 위해 서비스 쓰레드가 대기(Blocking) 상태가 됩니다. 
  
  - discardingThreshold
  : 0으로 설정하여, queue가 꽉 차더라도 로그를 버리지 않도록 했습니다. 
  
