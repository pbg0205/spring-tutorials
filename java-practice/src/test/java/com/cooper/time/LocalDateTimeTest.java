package com.cooper.time;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;

public class LocalDateTimeTest {

    @Test
    @DisplayName("LocalDateTime 에서 Date 타입으로 변환")
    void localDateTimeToDate() {
        LocalDateTime nowDateTime = LocalDateTime.now();
        Date nowDate = Timestamp.valueOf(nowDateTime);

        assertThat(nowDate).isInstanceOf(Date.class);
    }

    @Test
    @DisplayName("6개월 이내 날짜 판단 여부 확인")
    void isSixMonthsAgoDate() {
        LocalDateTime firstDateTimeOf2023 = LocalDateTime.of(2023, 1, 1, 0, 0);
        LocalDateTime sixMonthsAgoFirstDateTimeOf2023 = firstDateTimeOf2023.minusMonths(6);
        LocalDateTime aHundredDaysAgoFirstDateTimeOf2023 = firstDateTimeOf2023.minusDays(180);

        System.out.println(sixMonthsAgoFirstDateTimeOf2023); // 6개월 != 180일
        System.out.println(aHundredDaysAgoFirstDateTimeOf2023);

        Assertions.assertAll(
                () -> assertThat(aHundredDaysAgoFirstDateTimeOf2023).isNotEqualTo(sixMonthsAgoFirstDateTimeOf2023),
                () -> assertThat(sixMonthsAgoFirstDateTimeOf2023.isBefore(LocalDateTime.of(2022, 7, 1, 0, 0))).isFalse(),
                () -> assertThat(sixMonthsAgoFirstDateTimeOf2023.isEqual(LocalDateTime.of(2022, 7, 1, 0, 0))).isTrue(),
                () -> assertThat(sixMonthsAgoFirstDateTimeOf2023.isBefore(LocalDateTime.of(2022, 8, 1, 0, 0))).isTrue(),
                () -> assertThat(sixMonthsAgoFirstDateTimeOf2023.isBefore(LocalDateTime.of(2022, 1, 1, 0, 0))).isFalse()
        );
    }

    @Test
    @DisplayName("1년 뒤 날짜 확인")
    void plusOneYear() {
        LocalDateTime firstDateTimeOf2023 = LocalDateTime.of(2023, 1, 1, 0, 0);
        LocalDateTime plus365Days = firstDateTimeOf2023.plusDays(365);
        LocalDateTime plus1Years = firstDateTimeOf2023.plusYears(1);

        System.out.println(plus365Days);
        System.out.println(plus1Years);

        Assertions.assertAll(
                () -> assertThat(plus365Days).isEqualTo(LocalDateTime.of(2024, 1, 1, 0, 0)),
                () -> assertThat(plus1Years).isEqualTo(LocalDateTime.of(2024, 1, 1, 0, 0)),
                () -> assertThat(plus1Years).isEqualTo(plus365Days)
        );


    }

}
