package io.lw.bitcoinexplorer1112background.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import io.lw.bitcoinexplorer1112background.client.BitcoinRest;
import io.lw.bitcoinexplorer1112background.config.PageConfig;
import io.lw.bitcoinexplorer1112background.dao.TransactionMapper;
import io.lw.bitcoinexplorer1112background.po.Transaction;
import io.lw.bitcoinexplorer1112background.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    private BitcoinRest bitcoinRest;

    @Autowired
    private TransactionMapper transactionMapper;

    @Autowired
    private DetailServiceImpl detailService;
    @Override
    public void syncTransaction(String txid, Integer blockId, Long time){
        JSONObject transactionJson = bitcoinRest.getTransaction(txid);
        Transaction transaction = new Transaction();
        //set amount
        transaction.setBlockId(blockId);
        transaction.setSizeondisk(transactionJson.getInteger("size"));
        transaction.setStatus(0);
        transaction.setTime(time);
        transaction.setTxhash(transactionJson.getString("hash"));
        transaction.setTxid(transactionJson.getString("txid"));
        transaction.setWeight(transactionJson.getInteger("weight"));

        transactionMapper.insert(transaction);

        Integer transactionId = transaction.getTransactionId();

        //transaction detail vout
        List<JSONObject> vouts = transactionJson.getJSONArray("vout").toJavaList(JSONObject.class);
        for (JSONObject vout: vouts) {
            detailService.syncTransactionDetailVout(vout,transactionId);
        }

        //transaction detail vin
        List<JSONObject> vins = transactionJson.getJSONArray("vin").toJavaList(JSONObject.class);
        for (JSONObject vin : vins) {
            detailService.syncTransactionDetailVin(vin,transactionId);
        }

    }

    @Override
    public List<Transaction> getTransactionByBlockId(Integer blockId) {
        List<Transaction> transactions = transactionMapper.getTransactionByBlockId(blockId);
        return transactions;
    }

    @Override
    public Page<Transaction> getTransactionByBlockIdWithPage(Integer blockId, Integer page) {
        PageHelper.startPage(page, PageConfig.PAGE_SIZE);
        Page<Transaction> transactions = transactionMapper.getTransactionByBlockIdWithPage(blockId);
        return transactions;
    }

    @Override
    public Transaction getTransactionByTxid(String txid) {
        Transaction transaction = transactionMapper.getTransactionByTxid(txid);
        return transaction;
    }

    @Override
    public Page<Transaction> getTransactionByAddressWithPage(String address,Integer page) {
        Page<Transaction> transactions = transactionMapper.getTransactionByAddressWithPage(address);
        return transactions;
    }
}
