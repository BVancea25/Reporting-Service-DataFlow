package com.dataflow.reportingservice.Services;

import com.dataflow.reportingservice.DTO.FactTransactionDTO;
import com.dataflow.reportingservice.Models.FactTransaction;
import com.dataflow.reportingservice.Repositories.FactTransactionRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class FactTransactionSerivce {
    private final FactTransactionRepository factTransactionRepository;

    public FactTransactionSerivce(FactTransactionRepository factTransactionRepository) {
        this.factTransactionRepository = factTransactionRepository;
    }
    @Transactional
    public void syncTransactions(List<FactTransactionDTO> dtos) {
        if (dtos == null || dtos.isEmpty()) return;

        for (FactTransactionDTO dto : dtos) {
            switch (dto.getOperation()) {
                case CREATE -> handleCreate(dto);
                case UPDATE -> handleUpdate(dto);
                case DELETE -> handleDelete(dto);
            }
        }
    }

    private void handleCreate(FactTransactionDTO dto) {
        if (factTransactionRepository.existsById(dto.getId())) {
            // idempotency: ignore duplicate CREATE
            return;
        }

        System.out.println(mapToEntity(dto));

        factTransactionRepository.save(mapToEntity(dto));
    }

    private void handleUpdate(FactTransactionDTO dto) {
        FactTransaction existing = factTransactionRepository.findById(dto.getId())
                .orElseThrow(() ->
                        new RuntimeException("FactTransaction not found: " + dto.getId())
                );

        applyUpdates(existing, dto);
        factTransactionRepository.save(existing);
    }

    private void handleDelete(FactTransactionDTO dto) {
        if (!factTransactionRepository.existsById(dto.getId())) return;
        factTransactionRepository.deleteById(dto.getId());
    }

    private FactTransaction mapToEntity(FactTransactionDTO dto) {
        FactTransaction ft = new FactTransaction();
        ft.setTransactionId(dto.getId());
        ft.setAmount(dto.getAmount());
        ft.setCategory(dto.getCategory());
        ft.setCurrencyCode(dto.getCurrencyCode());
        ft.setTransaction_date(dto.getTransaction_date());
        ft.setPaymentMode(dto.getPaymentMode());
        ft.setUserId(dto.getUserId());
        return ft;
    }

    private void applyUpdates(FactTransaction existing, FactTransactionDTO dto) {
        existing.setAmount(dto.getAmount());
        existing.setCategory(dto.getCategory());
        existing.setCurrencyCode(dto.getCurrencyCode());
        existing.setTransaction_date(dto.getTransaction_date());
        existing.setPaymentMode(dto.getPaymentMode());
    }
}
