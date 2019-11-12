package io.lw.bitcoinexplorer1112background.dao;

import io.lw.bitcoinexplorer1112background.po.Transaction;

public interface TransactionMapper {
    int insert(Transaction record);

    int insertSelective(Transaction record);
}