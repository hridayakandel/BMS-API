package com.miu.bmsapi.service;

import com.miu.bmsapi.domain.Transaction;
import org.springframework.http.ResponseEntity;

public interface TransactionService extends GenericService<Transaction>{
    ResponseEntity<?> validateAndSave(Integer badgeId, Integer locationId);
}
