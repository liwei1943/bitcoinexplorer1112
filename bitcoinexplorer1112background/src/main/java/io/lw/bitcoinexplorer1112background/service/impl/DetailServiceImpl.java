package io.lw.bitcoinexplorer1112background.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import io.lw.bitcoinexplorer1112background.client.BitcoinJsonRpcClientImpl;
import io.lw.bitcoinexplorer1112background.client.BitcoinRest;
import io.lw.bitcoinexplorer1112background.dao.DetailMapper;
import io.lw.bitcoinexplorer1112background.enumerate.TransactionDetailType;
import io.lw.bitcoinexplorer1112background.po.Detail;
import io.lw.bitcoinexplorer1112background.service.DetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DetailServiceImpl implements DetailService {

    @Autowired
    private BitcoinRest bitcoinRest;

    @Autowired
    private DetailMapper detailMapper;

    @Autowired
    private BitcoinJsonRpcClientImpl bitcoinJsonRpcClient;
    @Override
    public void syncTransactionDetailVout(JSONObject vout, Integer transactionId) {
        Detail detail = new Detail();
        JSONObject scriptPubKey = vout.getJSONObject("scriptPubKey");
        JSONArray addresses = scriptPubKey.getJSONArray("addresses");
        if (addresses != null){
             String address = (String) addresses.get(0);
             detail.setAddress(address);
             detail.setType((byte) TransactionDetailType.Receive.ordinal());
             detail.setAmount(vout.getDouble("value"));
             detail.setTransactionId(transactionId);

             detailMapper.insert(detail);
        }
    }

    @Override
    public void syncTransactionDetailVin(JSONObject vin, Integer transactionId){
        Detail detail = new Detail();
        detail.setTransactionId(transactionId);
        detail.setType((byte) TransactionDetailType.Send.ordinal());
        String txidVin = vin.getString("txid");
        Integer n = vin.getInteger("n");

        if(txidVin != null && n != null){
            try{
                JSONObject transaction = bitcoinJsonRpcClient.getTransaction(txidVin);
                JSONArray vouts = transaction.getJSONArray("vout");
                JSONObject vout = vouts.getJSONObject(n);
                Double amount = vout.getDouble("value");
                detail.setAmount(amount);
                JSONObject scriptPubKey = vout.getJSONObject("scriptPubKey");
                JSONArray addresses = scriptPubKey.getJSONArray("addresses");
                if(addresses != null){
                    String address = addresses.getString(0);
                    detail.setAddress(address);
                    detailMapper.insert(detail);
                }
            }catch (Throwable throwable){
                throwable.printStackTrace();
            }



        }
    }
}
