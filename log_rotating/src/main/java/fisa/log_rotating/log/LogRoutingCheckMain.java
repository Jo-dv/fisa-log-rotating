package fisa.log_rotating.log;

import fisa.log_rotating.log.access.AccessLogTest;
import fisa.log_rotating.log.system.SystemLogTest;
import fisa.log_rotating.log.transcation.TransactionLogTest;

public class LogRoutingCheckMain {
    public static void main(String[] args) {
        TransactionLogTest.write();
        AccessLogTest.write();
        SystemLogTest.write();

        System.out.println("DONE. logs 폴더 확인하세요.");
    }
}