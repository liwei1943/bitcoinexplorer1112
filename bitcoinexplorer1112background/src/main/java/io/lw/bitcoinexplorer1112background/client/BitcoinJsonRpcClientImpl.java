package io.lw.bitcoinexplorer1112background.client;

import com.alibaba.fastjson.JSONObject;
import com.googlecode.jsonrpc4j.JsonRpcHttpClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Base64;
import java.util.HashMap;

@Service
public class BitcoinJsonRpcClientImpl implements BitcoinJsonRpcClient {


    private JsonRpcHttpClient jsonRpcHttpClient;

    public BitcoinJsonRpcClientImpl(@Value("${bitcoin.jsonrpc.url}") String url,
                                    @Value("${bitcoin.jsonrpc.username}") String username,
                                    @Value("${bitcoin.jsonrpc.password}") String password) throws MalformedURLException {
        jsonRpcHttpClient = new JsonRpcHttpClient(new URL(url));
        HashMap<String, String> hashMap = new HashMap<>();

        String str = username + ":" + password;

        String string = Base64.getEncoder().encodeToString(str.getBytes());

        hashMap.put("Authorization","Basic "+string);
        jsonRpcHttpClient.setHeaders(hashMap);



    }

    @Override
    public JSONObject getTransaction(String txid) throws Throwable {
        JSONObject getrawtransaction = jsonRpcHttpClient.invoke("getrawtransaction", new Object[]{txid, true}, JSONObject.class);
        return getrawtransaction;
    }
}
