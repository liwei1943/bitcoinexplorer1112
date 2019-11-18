package io.lw.bitcoinexplorer1112background.service;

import com.github.pagehelper.Page;
import io.lw.bitcoinexplorer1112background.po.Transaction;

import java.util.List;

public interface TransactionService {
    void syncTransaction(String txid, Integer blockId, Long time);

    List<Transaction> getTransactionByBlockId(Integer blockId);

    Page<Transaction> getTransactionByBlockIdWithPage(Integer blockId, Integer page);

    Transaction getTransactionByTxid(String txid);
}
