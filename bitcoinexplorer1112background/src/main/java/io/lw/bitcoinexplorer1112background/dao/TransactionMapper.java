package io.lw.bitcoinexplorer1112background.dao;

import io.lw.bitcoinexplorer1112background.po.Transaction;

import java.util.List;

public interface TransactionMapper {
    int insert(Transaction record);

    int insertSelective(Transaction record);

    Transaction getRecentUnconfirmed(Integer size);
}