package com.dataflow.reportingservice.Services;

import com.dataflow.reportingservice.DTO.FactDailyAggregateDto;
import com.dataflow.reportingservice.Repositories.FactDailyAggregateJdbcRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class AggregateService {
    private final FactDailyAggregateJdbcRepository repository;

    public AggregateService(FactDailyAggregateJdbcRepository repository) {
        this.repository = repository;
    }

//    public List<FactDailyAggregateDto> getDailyAggregate(LocalDate date) {
//        return repository.findByDate(date);
//    }
}
