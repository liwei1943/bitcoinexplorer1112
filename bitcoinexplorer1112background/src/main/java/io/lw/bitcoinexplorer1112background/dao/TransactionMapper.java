package io.lw.bitcoinexplorer1112background.dao;

import com.github.pagehelper.Page;
import io.lw.bitcoinexplorer1112background.po.Transaction;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TransactionMapper {
    int insert(Transaction record);

    int insertSelective(Transaction record);

    List<Transaction> getTransactionByBlockId(@Param("blockId") Integer blockId);

    Page<Transaction> getTransactionByBlockIdWithPage(@Param("blockId") Integer blockId);

    Transaction getTransactionByTxid(@Param("txid") String txid);

    Page<Transaction> getTransactionByAddressWithPage(@Param("address") String address);
}