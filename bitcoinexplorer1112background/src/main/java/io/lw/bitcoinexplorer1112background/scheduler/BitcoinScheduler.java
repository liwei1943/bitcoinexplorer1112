package io.lw.bitcoinexplorer1112background.scheduler;

import com.alibaba.fastjson.JSONObject;
import io.lw.bitcoinexplorer1112background.client.BitcoinRest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@Component
public class BitcoinScheduler {

    @Autowired
    private BitcoinRest bitcoinRest;

    private JSONObject oldTx = new JSONObject();

    private List<JSONObject> newTx = new LinkedList<>();

    private Logger logger = LoggerFactory.getLogger(this.getClass());

//    @Scheduled(cron = "${bitcoin.sync.interval}")
//    public void syncData(){
//        logger.info("begin to sync bitcoin data");
//    }

    @Scheduled(cron = "${bitcoin.syncMempoolTx.interval}")
    public void syncMempoolTx(){
        logger.info("begin");

        JSONObject mempoolContents = bitcoinRest.getMempoolContents();

        for (Map.Entry<String,Object> entry: mempoolContents.entrySet()) {
            String key = entry.getKey();
            if(!oldTx.containsKey(key)){
                JSONObject txJSONObject = oldTx.getJSONObject(key);
                txJSONObject.put("txid",key);
                newTx.add(txJSONObject);
            }
        }

        logger.info("new tx: {}",newTx);
        logger.info("new size: {}",newTx.size());

        newTx = new LinkedList<>();
        oldTx = mempoolContents;

        logger.info("end");
    }

}
