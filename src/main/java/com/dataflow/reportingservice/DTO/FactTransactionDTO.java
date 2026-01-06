package com.dataflow.reportingservice.DTO;


import com.dataflow.reportingservice.Utils.Constants.SyncOperations;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FactTransactionDTO {
    private String id;               // transactionId
    private BigDecimal amount;
    private String category;
    private String currencyCode;
    private LocalDateTime transaction_date;
    private String paymentMode;
    private SyncOperations operation;
    private String userId;
}
