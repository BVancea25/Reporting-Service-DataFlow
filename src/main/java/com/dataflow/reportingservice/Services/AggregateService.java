package com.dataflow.reportingservice.Services;

import com.dataflow.reportingservice.DTO.FactAggregateDTO;
import com.dataflow.reportingservice.Repositories.FactTransactionRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class AggregateService {
    private final FactTransactionRepository repository;

    public AggregateService(FactTransactionRepository repository) {
        this.repository = repository;
    }

    public List<FactAggregateDTO> getDailyAggregate(LocalDate startDate, LocalDate endDate) {
        endDate = endDate == null ? LocalDate.now() : endDate;
        return new ArrayList<>();
    }
}
