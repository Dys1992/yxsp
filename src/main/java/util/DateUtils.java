package util;


import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author fanyu
 * @Date: 2018/5/17 11:03
 */
public class DateUtils {


    /** seconds of day */
    public final static long    ONE_DAY_SECONDS      = 86400;

    /** milliseconds of day */
    public final static long    ONE_DAY_MILL_SECONDS = 86400000;

    /** yyyyMMdd日期格式 */
    public final static String  SHORT_FORMAT          = "yyyyMMdd";

    /** yyyyMMddHHmmss日期格式 */
    public final static String  LONG_FORMAT           = "yyyyMMddHHmmss";

    /** yyyy-MM-dd日期格式 */
    public final static String  WEB_FORMAT            = "yyyy-MM-dd";

    /** HHmmss日期格式 */
    public final static String  TIME_FORMAT           = "HHmmss";

    /** yyyyMM日期格式 */
    public final static String  MONTH_FORMAT          = "yyyyMM";

    /** yyyy年MM月dd日 日期格式 */
    public final static String  CHINESEDT_FORMAT      = "yyyy年MM月dd日";

    /** yyyy-MM-dd HH:mm:ss日期格式 */
    public final static String  NEW_FORMAT            = "yyyy-MM-dd HH:mm:ss";

    /** yyyy-MM-dd HH:mm日期格式 */
    public final static String  NOSECOND_FORMAT       = "yyyy-MM-dd HH:mm";

    /** HH:mm日期格式 */
    public final static String  NOSECOND_TIME_FORMAT     = "HH:mm";



    /**
     * 私有构造函数
     */
    private DateUtils(){
    }

    /**
     * @param pattern 日期格式
     * @return 日期格式
     */
    private static DateFormat getNewDateFormat(String pattern) {
        DateFormat df = new SimpleDateFormat(pattern);
        df.setLenient(false);
        return df;
    }


    /**
     * @param pattern 日期格式
     * @return string
     * */
    public static String getToday(String pattern){
        DateFormat dateFormat = getNewDateFormat(pattern);
        Calendar calendar = Calendar.getInstance();
        return  dateFormat.format(calendar.getTime());
    }


    /**
     * @param addDay 间隔的天数
     * @return
     * 2018-01-25格式日期
     */
    public static String getNextDay(int addDay,String pattern) {
        DateFormat dateFormat = getNewDateFormat(pattern);
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_MONTH,addDay);
        return dateFormat.format(calendar.getTime());
    }

    /**
     * @param addHour 增加几个小时
     * @param pattern 日期格式
     * @return 日期
     * */
    public static String getNextHour(int addHour,String pattern) {

        DateFormat dateFormat = getNewDateFormat(pattern);
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.HOUR_OF_DAY,addHour);
        return dateFormat.format(calendar.getTime());

    }

    /**
     * 当前yyyy-MM-dd HH:mm 格式的日期
     * @return HH:mm格式时间
     **/
    public static String getNoSecondTime(){

        DateFormat dateFormat = getNewDateFormat(NOSECOND_TIME_FORMAT);
        Date date = new Date();
        return  dateFormat.format(date);

    }

    /**
     * @param dateStr 时间
     * @param pattern 日期格式
     * @return 指定时间的13位时间戳
     * */
    public static String getTimeStamp(String dateStr,String pattern) throws ParseException {

        DateFormat dateFormat = getNewDateFormat(pattern);
        return String.valueOf(dateFormat.parse(dateStr).getTime());

    }

    /**
     * @param dateStr 时间
     * @param pattern 日期格式
     * @return 10位时间戳
     * */
    public static String getTenTimeStamp(String dateStr,String pattern) throws ParseException {

        DateFormat dateFormat = getNewDateFormat(pattern);
        return String.valueOf(dateFormat.parse(dateStr).getTime() / 1000);

    }


    /**
     * @return 10位时间戳
     * */
    public static String getNowTenTimeStamp(){

        long time = System.currentTimeMillis();
        return String.valueOf(time / 1000);

    }

    /**
     * @return 13位时间戳
     * */
    public static String getNowTimeStamp(){

        long time = System.currentTimeMillis();
        return String.valueOf((time / 1000) *1000);

    }

}
