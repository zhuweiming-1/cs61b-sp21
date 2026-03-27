package cn.zhu;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.TimeZone;

public class JavaTimestamp {
    private static final DateTimeFormatter UTC_FORMATTER = DateTimeFormatter
            .ofPattern("yyyy-MM-dd HH:mm:ss")
            .withZone(ZoneId.of("Asia/Shanghai"));

    public static void main(String[] args) {
//        long milliTs = -62135625600000L;
        long milliTs = -62135625600000L;
        String utcStr1 = convertMilliTsToUtcStr(milliTs);
        System.out.println("毫秒级时间戳转UTC字符串：" + utcStr1);

//        Timestamp ts = new Timestamp(-62135596800000L);
        Timestamp ts = new Timestamp(-62135625600000L);
        System.out.println(ts);


        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        // 【关键】在这里设置时区，而不是在 ts 上设置
        sdf.setTimeZone(TimeZone.getTimeZone("UTC"));

        System.out.println("强制 UTC 显示: " + sdf.format(ts));

    }

    public static String convertMilliTsToUtcStr(long milliTs) {
        // 直接关联 UTC 时区 + 格式化
        return Instant.ofEpochMilli(milliTs)
//                .atZone(ZoneId.of("UTC"))
                .atZone(ZoneId.of("Asia/Shanghai"))
                .format(UTC_FORMATTER);
    }
}
