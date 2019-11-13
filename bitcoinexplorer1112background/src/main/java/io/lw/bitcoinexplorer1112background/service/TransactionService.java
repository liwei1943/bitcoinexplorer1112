package io.lw.bitcoinexplorer1112background.service;

import io.lw.bitcoinexplorer1112background.po.Transaction;

public interface TransactionService {
    Transaction getRecentUnconfirmed(Integer size);
}
