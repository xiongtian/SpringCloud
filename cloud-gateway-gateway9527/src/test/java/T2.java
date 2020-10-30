import java.time.ZoneId;
import java.time.ZonedDateTime;

/**
 * @author xiongtian
 * @version 1.0
 * @date 2020/10/30 14:18
 */
public class T2 {

    public static void main(String[] args) {
        ZonedDateTime zbj = ZonedDateTime.now();
        System.out.println( zbj);
        /*ZonedDateTime zny = ZonedDateTime.now(ZoneId.of("America/New_York"));//用指定时区获取当前时间
        System.out.println(zny);*/
        /*
        * 运行结果：
        * 2020-10-30T14:21:27.997+08:00[Asia/Shanghai]
        * 2020-10-30T02:21:28-04:00[America/New_York]
        * */
    }
}
