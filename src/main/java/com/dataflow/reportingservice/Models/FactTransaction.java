package com.dataflow.reportingservice.Models;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "fact_transactions",
        indexes = {
                @Index(name = "idx_ft_user_date", columnList = "user_id, date_key"),
                @Index(name = "idx_ft_date_cat",  columnList = "date_key, category")
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


}