package io.lw.bitcoinexplorer1112background.controller;


import com.alibaba.fastjson.JSONObject;
import io.lw.bitcoinexplorer1112background.po.Transaction;
import io.lw.bitcoinexplorer1112background.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transaction")
public class TransactionController {


    @GetMapping("/getRecentUnconfirmed")
    public List<JSONObject> getRecentUnconfirmed(@RequestParam(required = false,defaultValue = "20") Integer size){
        return null;
    }

    @GetMapping("/getByTxhash")
    public JSONObject getByTxhash(@RequestParam String txhash){
        return null;
    }
}
