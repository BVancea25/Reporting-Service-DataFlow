package com.dataflow.reportingservice.DTO;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

public class FactDailyAggregateDto {
    private LocalDate bucket;
    private UUID userId;
    private BigDecimal totalAmount;
    private Long txnCount;

    public FactDailyAggregateDto() {
    }

    public FactDailyAggregateDto(LocalDate bucket, UUID userId, BigDecimal totalAmount, Long txnCount) {
        this.bucket = bucket;
        this.userId = userId;
        this.totalAmount = totalAmount;
        this.txnCount = txnCount;
    }

    // Getters and setters
    public LocalDate getBucket() { return bucket; }
    public void setBucket(LocalDate bucket) { this.bucket = bucket; }

    public UUID getUserId() { return userId; }
    public void setUserId(UUID userId) { this.userId = userId; }

    public BigDecimal getTotalAmount() { return totalAmount; }
    public void setTotalAmount(BigDecimal totalAmount) { this.totalAmount = totalAmount; }

    public long getTxnCount() { return txnCount; }
    public void setTxnCount(long txnCount) { this.txnCount = txnCount; }

    @Override
    public String toString() {
        return "FactDailyAggregateDto{" +
                "dateKey=" + bucket +
                ", userId=" + userId +
                ", totalAmount=" + totalAmount +
                ", txnCount=" + txnCount +
                '}';
    }
}
