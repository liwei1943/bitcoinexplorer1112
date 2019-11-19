package io.lw.bitcoinexplorer1112background.service;

import com.alibaba.fastjson.JSONObject;
import io.lw.bitcoinexplorer1112background.po.Detail;

import java.util.List;

public interface DetailService {

    void syncTransactionDetailVout(JSONObject vout, Integer transactionId);

    void syncTransactionDetailVin(JSONObject vin, Integer transactionId);

    List<Detail> getDetailByTransactionId(Integer transactionId);

    Integer getTotalByAddress(String address);

    Double getReceiveByAddress(String address);

    Double getSendByAddress(String address);

}
