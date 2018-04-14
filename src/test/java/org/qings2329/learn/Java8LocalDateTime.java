package org.qings2329.learn;

import java.time.*;

/**
 * @author limin
 * @date 2018-04-14
 */
public class Java8LocalDateTime {

    public static void main(String agrs[]) {
        // just time
        LocalTime localTime = LocalTime.now();
        System.out.println(localTime);


        System.out.println("****************************");

        // just date
        LocalDate localDate = LocalDate.now();
        System.out.println(localDate);


        System.out.println("second of EpochDay: " + localDate.toEpochDay() * 24 * 60 * 60);

        ZonedDateTime zonedDateTime = localDate.atStartOfDay(ZoneId.systemDefault());


        long epochMilliSecond = zonedDateTime.toInstant().toEpochMilli();
        System.out.println("epochMilliSecond: " + epochMilliSecond);

        long epochSecond = zonedDateTime.toEpochSecond();
        System.out.println("epochSecond: " + epochSecond);
        System.out.println("****************************");


        // date and time
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime);

        localDateTime.toLocalDate();
        localDateTime.toLocalTime();

//        localDateTime.

    }

}
