package com.pet.lovepet.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtils {

    private final static SimpleDateFormat NORM_DATETIME_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private final static SimpleDateFormat NORM_DATETIME_FORMAT2 = new SimpleDateFormat("yyyyMMddHHmmss");
    private final static SimpleDateFormat NORM_DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");
    private final static SimpleDateFormat NORM_DATE_FORMAT2 = new SimpleDateFormat("yyyy/MM/dd");
    private final static SimpleDateFormat NORM_DATE_FORMAT3 = new SimpleDateFormat("MM-dd HH:mm");
    private final static SimpleDateFormat NORM_DATE_FORMAT4 = new SimpleDateFormat("HH");
    private final static SimpleDateFormat NORM_DATE_FORMAT5 = new SimpleDateFormat("HH:mm:ss");
    private final static SimpleDateFormat NORM_DATE_FORMAT6 = new SimpleDateFormat("yyyy");

    private final static SimpleDateFormat NORM_DATE_FORMAT7 = new SimpleDateFormat("MM-dd");
    private final static SimpleDateFormat CN_NORM_DATE_FORMAT = new SimpleDateFormat("yyyy年MM月dd日");

    private static Calendar calendar = null;

    /**
     * 当前时间，格式 yyyy-MM-dd HH:mm:ss
     *
     * @return 当前时间的标准形式字符串
     */
    public static String now() {
        return formatDateTime(new Date());
    }

    public static String now2(){
        return NORM_DATE_FORMAT.format(new Date());
    }

    public static String formatDateTime5() {
        return NORM_DATETIME_FORMAT2.format(new Date());
    }


    public static String formatYM(Date date){
        return NORM_DATE_FORMAT7.format(date);
    }


    public static String formatDateTime(Date date) {
        return NORM_DATETIME_FORMAT.format(date);
    }

    public static Date formatTimeDate(String time) {
        try {
          return NORM_DATETIME_FORMAT.parse(time);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Date formatTimeDate2(String time) {
        try {
            return NORM_DATE_FORMAT.parse(time);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String formatDateTime4(Date date) {
        return NORM_DATE_FORMAT4.format(date);
    }

    public static String formatDate(Date date) {
        if (date == null) {
            return "";
        } else {
            return NORM_DATE_FORMAT.format(date);
        }
    }


    public static String formatCNDate(Date date) {
        if (date == null) {
            return "";
        } else {
            return CN_NORM_DATE_FORMAT.format(date);
        }
    }

    public static String formatDate6(Date date) {
        if (date == null) {
            return "";
        } else {
            return NORM_DATE_FORMAT6.format(date);
        }
    }

    public static String formatDate2(Date date) {
        return NORM_DATE_FORMAT2.format(date);
    }

    public static String formatDate5(Date date) {
        return NORM_DATE_FORMAT5.format(date);
    }
    /**
     * MM-dd HH:mm
     *
     * @param date
     * @return 12-05 12:32
     */
    public static String formatDate3(Date date) {
        if (date == null) {
            return "";
        } else {
            return NORM_DATE_FORMAT3.format(date);
        }

    }

    /**
     * yyyy-MM-dd
     *
     * @param str
     * @return
     */
    public static Date StrToDate(String str) {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;

        if (null != str && !("null".equals(str))) {
            try {
                date = sdf.parse(str);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }

        return date;
    }

    /**
     * yyyy/MM/dd
     *
     * @param str
     * @return
     */
    public static Date StrToDate22(String str) {

        Date date = null;

        if (null != str && !("null".equals(str))) {
            try {
                date = NORM_DATE_FORMAT2.parse(str);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }

        return date;
    }

    /**
     * @param str
     * @return yyyy-MM-dd HH:mm:ss
     * @throws ParseException
     */
    public static Date StrToDate1(String str) throws ParseException {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = null;
        if (null != str && !("null".equals(str))) {

            date = sdf.parse(str);
        }
        return date;
    }





    public static String getAppointTime(Integer time) {
        Date dBefore = new Date();
        Date dNow = new Date();   //当前时间
        Calendar calendar = Calendar.getInstance(); //得到日历
        calendar.setTime(dNow);//把当前时间赋给日历
        calendar.add(Calendar.DATE, time);
        dBefore = calendar.getTime();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); //设置时间格式
        return sdf.format(dBefore);
    }

    /**
     * 得到指定日期的年份
     *
     * @param df
     * @return
     */
    public static String getYear(Date df) {
        calendar = Calendar.getInstance();
        calendar.setTime(df);
        return "" + calendar.get(Calendar.YEAR);
    }

    /**
     * 得到指定日期的日期
     *
     * @param df
     * @return
     */
    public static String getDay(Date df) {
        calendar = Calendar.getInstance();
        calendar.setTime(df);
        return getNum(calendar.get(Calendar.DAY_OF_MONTH));
    }

    /**
     * 得到指定日期的月份
     *
     * @param df
     * @return
     */
    public static String getMoon(Date df) {
        calendar = Calendar.getInstance();
        calendar.setTime(df);
        return getNum((calendar.get(Calendar.MONTH) + 1));
    }

    /**
     * 补零
     *
     * @param i
     * @return
     */
    public static String getNum(int i) {
        return i > 9 ? "" + i : "0" + i;
    }

    /**
     * 获取前一天时间 年月日
     *
     * @return
     */
    public static String getYesterday() {
        Date dNow = new Date();   //当前时间
        Date dBefore = new Date();

        Calendar calendar = Calendar.getInstance();  //得到日历
        calendar.setTime(dNow);//把当前时间赋给日历
        calendar.add(Calendar.DAY_OF_MONTH, -1);  //设置为前一天
        dBefore = calendar.getTime();   //得到前一天的时间

        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd"); //设置时间格式
        String defaultStartDate = sdf.format(dBefore);    //格式化前一天

        return defaultStartDate;
    }

    /**
     * 获取7天前的时间
     * @return
     */
    public static String getLastSevenDay() {
        Date dNow = new Date();   //当前时间
        Date dBefore = new Date();

        Calendar calendar = Calendar.getInstance();  //得到日历
        calendar.setTime(dNow);//把当前时间赋给日历
        calendar.add(Calendar.DAY_OF_MONTH, -7);  //设置为前一天
        dBefore = calendar.getTime();   //得到前一天的时间

        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd"); //设置时间格式
        String defaultStartDate = sdf.format(dBefore);    //格式化前一天

        return defaultStartDate;
    }

    /**
     * 获取上个月的今天
     *
     * @throws Exception
     */
    public static String getLastMonthToday() {
        Date today = new Date();
        Calendar calendar = Calendar.getInstance();  //得到日历
        calendar.setTime(today);//把当前时间赋给日历
        calendar.add(Calendar.MONTH, -1);  //设置为前一天
        calendar.get(Calendar.DAY_OF_MONTH);
        Date time = calendar.getTime();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMM15"); //设置时间格式
        String defaultDate = sdf.format(time); //格式化当前时间

        return defaultDate;
    }

    /**
     * 获取本月的第一天
     * @return
     */
    public static Date getThisMouthFirstDay() {
        Calendar calendar= Calendar.getInstance();
        calendar.add(Calendar.MONTH, 0);
        calendar.set(Calendar.DAY_OF_MONTH,1);
        calendar.set(Calendar.MINUTE,0);
        calendar.set(Calendar.SECOND,0);
        calendar.set(Calendar.HOUR_OF_DAY,0);
        return calendar.getTime();
    }


    /**
     * 获取上个月的第一天
     * @return
     */
    public static String getLastMouthFirstDay() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd"); //设置时间格式
        Calendar calendar1 = Calendar.getInstance();
        calendar1.add(Calendar.MONTH, -1);
        calendar1.set(Calendar.DAY_OF_MONTH,1);
        return sdf.format(calendar1.getTime());
    }

    /**
     * 获取上个月的最后一天
     * @return
     */
    public static String getLastMouthLastDay() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd"); //设置时间格式
        Calendar calendar2 = Calendar.getInstance();
        calendar2.set(Calendar.DAY_OF_MONTH, 0);
        return sdf.format(calendar2.getTime());
    }

    public static Date last(Date date){
        Calendar paycal= Calendar.getInstance();

        paycal.setTime(date);

        paycal.add(Calendar.DATE, 1);

        Date startdate = paycal.getTime();

        paycal.set(Calendar.DATE, paycal.getActualMaximum(Calendar.DATE));

        Date enddate = paycal.getTime();
        return enddate;
    }

    public static Date getStartDateTime(String date){
        try {
            return NORM_DATETIME_FORMAT.parse(date+" 00:00:00");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Date getEndDateTime(String date){
        try {
            return NORM_DATETIME_FORMAT.parse(date+" 23:59:59");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 往前推12个月
     * @param date
     * @return
     */
    public static String getOldYearDate(Date date){

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        //获取前一年
        calendar.add(Calendar.YEAR,-1);
        calendar.add(Calendar.MONTH, +1);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(calendar.getTime());
    }

    /**
     * 往前推32天
     * @param date
     * @return
     */
    public static String getOldDayDate(Date date){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        //获取前一年
        calendar.add(Calendar.DAY_OF_YEAR, -15);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(calendar.getTime());
    }

    /**
     * 往前推13个月
     * @param date
     * @return
     */
    public static String getOldThirsteenDate(Date date){

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        //获取前一年
        calendar.add(Calendar.YEAR,-1);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(calendar.getTime());
    }

    /**
     * 获取今日00:00:00
     * @return
     */
    public static Date getTodayStart(){
        return getStartDateTime(now2());
    }

    /**
     * 获取今日23:59:59
     * @return
     */
    public static Date getTodayEnd(){
        return getEndDateTime(now2());
    }

    /**
     * 计算给定日期与今日之间相差的天数
     * @param date
     * @return
     */
    public static int betweenDays(Date date){
        Date today = getTodayStart();
        long betweenDays = (date.getTime() - today.getTime()) / (1000L*3600L*24L)+1;
        return (int)betweenDays;
    }

    /**
     * 计算给定日期到今日的月数
     * @param d1
     * @return
     */
    public static int betweenMonths(Date d1) {
        Calendar c1 = Calendar.getInstance();
        c1.setTime(d1);
        Calendar c2 = Calendar.getInstance();
        Date d2 = getTodayStart();
        c2.setTime(d2);
        if(c1.getTimeInMillis() < c2.getTimeInMillis()) return 0;
        int year1 = c1.get(Calendar.YEAR);
        int year2 = c2.get(Calendar.YEAR);
        int month1 = c1.get(Calendar.MONTH);
        int month2 = c2.get(Calendar.MONTH);
        int day1 = c1.get(Calendar.DAY_OF_MONTH);
        int day2 = c2.get(Calendar.DAY_OF_MONTH);
        // 获取年的差值 假设 d1 = 2015-8-16  d2 = 2011-9-30
        int yearInterval = year1 - year2;
        // 如果 d1的 月-日 小于 d2的 月-日 那么 yearInterval-- 这样就得到了相差的年数
        if(month1 < month2 || month1 == month2 && day1 < day2) yearInterval --;
        // 获取月数差值
        int monthInterval =  (month1 + 12) - month2  ;
        if(day1 < day2) monthInterval --;
        monthInterval %= 12;
        return yearInterval * 12 + monthInterval;
    }

    /**
     * 根据所给日期累加天数，返回累加后日期 yyyy-mm-dd HH:mm:ss
     * @param date
     * @param num
     * @return
     */
    public static Date addDays(Date date,int num){
        Calendar ca = Calendar.getInstance();
        ca.add(Calendar.DATE, num);
        date = ca.getTime();

        return getStartDateTime(formatDate(date));
    }

    /**
     * 根据所给日期累加月数，返回累加后日期 yyyy-mm-dd HH:mm:ss
     * @param date
     * @param num
     * @return
     */
    public static Date addMonths(Date date,int num){
        Calendar ca = Calendar.getInstance();
        ca.add(Calendar.MONTH, num);
        date = ca.getTime();

        return getStartDateTime(formatDate(date));
    }

    /**
     * 获取给定日期第二天时间 yyyy-MM-dd 00:00:00
     * @param date
     * @return
     */
    public static Date nextDate(String date){
        Date beforeDate = formatTimeDate2(date);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(beforeDate);
        calendar.add(calendar.DATE,1);
        beforeDate = calendar.getTime();
        return getStartDateTime(formatDate(beforeDate));
    }


    public static void main(String[] args) throws Exception{
    }

}
