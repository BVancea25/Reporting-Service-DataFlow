package com.dataflow.reportingservice.Repositories;

import com.dataflow.reportingservice.Models.FactTransaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FactTransactionRepository extends JpaRepository<FactTransaction, String> {


}
