package com.dataflow.reportingservice.Models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Table(name = "dim_date")
public class DateDimension {
    @Id
    @Column(name = "date_key")
    private Date dateKey;

    @Column(name = "day")
    private Integer day;

    @Column(name = "month")
    private Integer month;

    @Column(name = "month_name")
    private String monthName;

    @Column(name = "quarter")
    private Integer quarter;

    @Column(name = "year")
    private Integer year;

    @Column(name = "day_of_week")
    private int dayOfWeek;

    @Column(name="weekday_name")
    private String weekDayName;

    @Column(name = "is_weekend")
    private Boolean isWeekend;

    @Column(name = "is_holiday")
    private Boolean isHoliday;
}
