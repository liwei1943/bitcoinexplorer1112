package io.lw.bitcoinexplorer1112background.service;

import io.lw.bitcoinexplorer1112background.po.Transaction;

public interface TransactionService {
    void syncTransaction(String txid, Integer blockId, Long time) throws Throwable;
}
