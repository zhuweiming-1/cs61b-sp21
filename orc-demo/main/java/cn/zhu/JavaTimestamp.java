package cn.zhu;

import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class JavaTimestamp {
    private static final DateTimeFormatter UTC_FORMATTER = DateTimeFormatter
            .ofPattern("yyyy-MM-dd HH:mm:ss")
            .withZone(ZoneId.of("UTC"));
    public static void main(String[] args) {
        long milliTs = -62135596800000L;
        String utcStr1 = convertMilliTsToUtcStr(milliTs);
        System.out.println("毫秒级时间戳转UTC字符串：" + utcStr1);
    }

    public static String convertMilliTsToUtcStr(long milliTs) {
        // 直接关联 UTC 时区 + 格式化
        return Instant.ofEpochMilli(milliTs)
                .atZone(ZoneId.of("UTC"))
                .format(UTC_FORMATTER);
    }
}
