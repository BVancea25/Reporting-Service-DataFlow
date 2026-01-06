package com.dataflow.reportingservice.Repositories;

import com.dataflow.reportingservice.DTO.FactDailyAggregateDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Repository
public class FactDailyAggregateJdbcRepository {
    private final JdbcTemplate jdbcTemplate;

    public FactDailyAggregateJdbcRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

//    public List<FactDailyAggregateDto> findByDate(LocalDate date) {
//        String sql = "SELECT bucket, user_id, total_amount, txn_count " +
//                "FROM mv_fact_daily_aggregate " +
//                "WHERE bucket = ?";
//
//        return jdbcTemplate.query(sql, new Object[]{date},
//                (rs, rowNum) -> mapRowToDto(rs));
//    }
//
//    private FactDailyAggregateDto mapRowToDto(ResultSet rs) throws SQLException {
//        LocalDate bucket = rs.getDate("bucket").toLocalDate();
//        UUID userId = UUID.fromString(rs.getString("user_id"));
//        java.math.BigDecimal totalAmount = rs.getBigDecimal("total_amount");
//        Long txnCount = rs.getLong("txn_count");
//
//        return new FactDailyAggregateDto(bucket, userId, totalAmount, txnCount);
//    }
}
