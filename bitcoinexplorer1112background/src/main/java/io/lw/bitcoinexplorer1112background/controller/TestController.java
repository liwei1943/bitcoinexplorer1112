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
        final List<JSONObject> blockHeaders = bitcoinRest.getBlockHeaders(5, "000000004349a36b356411297e008ec996d5d6ab0c5cee5bbcf00007733d33d5");
        final JSONObject blockNoTxDetails = bitcoinRest.getBlockNoTxDetails("0000000003a4f59ce5bd2dbba52f9ef6acb247fa1a15c31fbd0d08eb64743741");
        final JSONObject blockInfo = bitcoinRest.getBlockInfo("0000000003a4f59ce5bd2dbba52f9ef6acb247fa1a15c31fbd0d08eb64743741");
        final JSONObject Transaction = bitcoinRest.getTransaction("d845e55fd5f4d5e166bb0edfa44eaf7607988ca95c06a3c9c3680f98931e6053");
        final JSONObject mempoolInfo = bitcoinRest.getMempoolInfo();
        final JSONObject mempoolContents = bitcoinRest.getMempoolContents();
        final JSONObject utxo = bitcoinRest.getUTXO("e00fd08ec52cc53312a3d97ee91c0662d952c564534aceb84a8e038a73230019", 0);
        return null;
    }
}
