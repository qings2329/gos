package org.qings2329.learn;

import org.junit.Test;

import java.math.BigDecimal;
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

    @Test
    public void calculateSubsidy() {
        Long YI = 100000000L;
        BigDecimal q = new BigDecimal(0.5);
        BigDecimal totalCoin = new BigDecimal(500L * YI);
        BigDecimal preminePercent = new BigDecimal(0.95);
        BigDecimal qN = new BigDecimal(Math.pow(0.5, 64));
        BigDecimal divisor = BigDecimal.ONE.subtract(qN);

        BigDecimal subsidy = totalCoin.multiply(BigDecimal.ONE.subtract(preminePercent)).multiply(q).divide(divisor, 10, BigDecimal.ROUND_HALF_UP);
        BigDecimal nSubsidyHalvingInterval = new BigDecimal(4200000);
        System.out.println(subsidy.divide(nSubsidyHalvingInterval, 2, BigDecimal.ROUND_HALF_UP));
    }

}