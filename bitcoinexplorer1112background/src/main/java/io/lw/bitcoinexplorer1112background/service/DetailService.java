package io.lw.bitcoinexplorer1112background.service;

import com.alibaba.fastjson.JSONObject;

public interface DetailService {

    void syncTransactionDetailVout(JSONObject vout, Integer transactionId);

    void syncTransactionDetailVin(JSONObject vin, Integer transactionId) throws Throwable;
}
