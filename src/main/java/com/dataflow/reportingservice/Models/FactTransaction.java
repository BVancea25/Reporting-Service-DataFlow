package com.dataflow.reportingservice.Models;

import com.dataflow.reportingservice.Utils.Constants.TransactionType;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "fact_transactions",
        indexes = {
                @Index(name = "idx_ft_user_date_currency", columnList = "user_id, date_key, currency_code"),
                @Index(name = "idx_category",  columnList = "category"),
                @Index(name = "idx_payment_method", columnList = "payment_mode")
        })
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FactTransaction {

    @Id
    @Column(name = "transaction_id", nullable = false, updatable = false)
    private String transactionId;

    @Column(name = "user_id", nullable = false)
    private String userId;

    @Column(name = "date_key", nullable = true)
    private LocalDate dateKey;

    @Column(name = "category", nullable = false, length = 100)
    private String category;

    @Column(name = "amount", nullable = false, precision = 18, scale = 4)
    private BigDecimal amount;

    @Column(name = "currency_code", nullable = false, length = 3)
    private String currencyCode;

    @Column(name = "payment_mode", length = 50)
    private String paymentMode;

    @Column(name = "transaction_date", nullable = false)
    private LocalDateTime transaction_date;

    @Enumerated(EnumType.STRING)
    @Column(name="type", nullable = false)
    private TransactionType type = TransactionType.INCOME;

    @PrePersist
    public void prePersist() {
        if (type == null) {
            type = TransactionType.INCOME;
        }
    }

}