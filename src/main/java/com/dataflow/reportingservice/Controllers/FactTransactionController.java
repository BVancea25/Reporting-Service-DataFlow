package com.dataflow.reportingservice.Controllers;

import com.dataflow.reportingservice.DTO.FactTransactionDTO;
import com.dataflow.reportingservice.Services.FactTransactionSerivce;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/api/transactions")
public class FactTransactionController {
    private final FactTransactionSerivce factTransactionSerivce;

    public FactTransactionController(FactTransactionSerivce factTransactionSerivce) {
        this.factTransactionSerivce = factTransactionSerivce;
    }

    @PostMapping("/sync")
    public ResponseEntity<Void> syncTransactions(
            @RequestBody List<FactTransactionDTO> dtos
    ) {
        factTransactionSerivce.syncTransactions(dtos);
        return ResponseEntity.ok().build();
    }
}
