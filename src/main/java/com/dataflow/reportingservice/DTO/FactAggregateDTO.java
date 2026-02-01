package com.dataflow.reportingservice.DTO;


import com.dataflow.reportingservice.Utils.Constants.DataTimeMeasure;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

public record FactAggregateDTO(LocalDate startDate, LocalDate endDate, UUID userId, BigDecimal totalAmount, Integer txnCount, DataTimeMeasure dataTimeMeasure) {
//    private LocalDate startDate;
//
//    private LocalDate endDate;
//    private UUID userId;
//    private BigDecimal totalAmount;
//    private Long txnCount;
//
//    public FactAggregateDto() {
//    }
//
//    public FactAggregateDto(LocalDate startDate, LocalDate endDate,UUID userId, BigDecimal totalAmount, Long txnCount) {
//        this.startDate = startDate;
//        this.endDate = endDate;
//        this.userId = userId;
//        this.totalAmount = totalAmount;
//        this.txnCount = txnCount;
//    }
    @Override
    public String toString() {
        return "FactAggregateDto{" +
                "startDate=" + startDate +
                "endDate=" + endDate +
                "dataTimeMeasure=" + dataTimeMeasure +
                ", userId=" + userId +
                ", totalAmount=" + totalAmount +
                ", txnCount=" + txnCount +
                '}';
    }
}
