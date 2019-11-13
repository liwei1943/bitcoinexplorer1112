package io.lw.bitcoinexplorer1112background.controller;

import com.alibaba.fastjson.JSONObject;
import io.lw.bitcoinexplorer1112background.client.BitcoinRest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private BitcoinRest bitcoinRest;

    @GetMapping("/hello")
    public String hello(){
        final JSONObject chainInfo = bitcoinRest.getChainInfo();
        final JSONObject blockhashByHeight = bitcoinRest.getBlockhashByHeight(10);
        final List<JSONObject> blockHeaders = bitcoinRest.getBlockHeaders(5, "000000000002b6a6930b4c139ed50bcb64547f5070256b80c441c31275e7a761");
        final JSONObject blockNoTxDetails = bitcoinRest.getBlockNoTxDetails("000000000007ef560e5f659712555d18b9e58e5b2ef4d6b57928e3930044348e");
        final JSONObject blockInfo = bitcoinRest.getBlockInfo("000000000007ef560e5f659712555d18b9e58e5b2ef4d6b57928e3930044348e");
        final JSONObject Transaction = bitcoinRest.getTransaction("0828be2c9c57febf321154c860d09256ecf2ed87044047de69b0d6a0f764e4b5");
        final JSONObject mempoolInfo = bitcoinRest.getMempoolInfo();
        final JSONObject mempoolContents = bitcoinRest.getMempoolContents();
        final JSONObject utxo = bitcoinRest.getUTXO("0828be2c9c57febf321154c860d09256ecf2ed87044047de69b0d6a0f764e4b5", 0);
        return null;
    }
}
