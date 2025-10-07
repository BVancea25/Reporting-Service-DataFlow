package com.dataflow.reportingservice.Controllers;

import com.dataflow.reportingservice.DTO.FactDailyAggregateDto;
import com.dataflow.reportingservice.Services.AggregateService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/aggregates")
public class AggregateController {
    private final AggregateService service;

    public AggregateController(AggregateService service) {
        this.service = service;
    }

    @GetMapping("/daily")
    public List<FactDailyAggregateDto> getDailyAggregate(@RequestParam("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        return service.getDailyAggregate(date);
    }
}
