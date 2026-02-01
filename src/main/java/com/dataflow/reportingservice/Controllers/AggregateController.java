package com.dataflow.reportingservice.Controllers;

import com.dataflow.reportingservice.DTO.FactAggregateDTO;
import com.dataflow.reportingservice.Services.AggregateService;
import jakarta.annotation.Nullable;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api")
public class AggregateController {
    private final AggregateService service;

    public AggregateController(AggregateService service) {
        this.service = service;
    }

    @GetMapping("/aggregates")
    public List<FactAggregateDTO> getDailyAggregate(@RequestParam("start_date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
                                                    @RequestParam("end_date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) @Nullable LocalDate endDate
    ) {
        return service.getDailyAggregate(startDate, endDate);
    }
}
