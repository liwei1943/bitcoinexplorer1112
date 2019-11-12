package io.lw.bitcoinexplorer1112background.service.impl;

import io.lw.bitcoinexplorer1112background.dao.TransactionMapper;
import io.lw.bitcoinexplorer1112background.po.Transaction;
import io.lw.bitcoinexplorer1112background.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    private TransactionMapper transactionMapper;

    @Override
    public Transaction getRecentUnconfirmed(Integer size) {
        return transactionMapper.getRecentUnconfirmed(size);
    }
}
