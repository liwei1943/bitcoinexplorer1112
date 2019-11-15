package io.lw.bitcoinexplorer1112background.client;

import com.alibaba.fastjson.JSONObject;

public interface BitcoinJsonRpcClient {

    JSONObject getTransaction(String txid) throws Throwable;
}
