package io.lw.bitcoinexplorer1112background.controller;


import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.Page;
import io.lw.bitcoinexplorer1112background.config.PageConfig;
import io.lw.bitcoinexplorer1112background.dto.PageDTO;
import io.lw.bitcoinexplorer1112background.po.Block;
import io.lw.bitcoinexplorer1112background.po.Detail;
import io.lw.bitcoinexplorer1112background.po.Transaction;
import io.lw.bitcoinexplorer1112background.service.BlockService;
import io.lw.bitcoinexplorer1112background.service.DetailService;
import io.lw.bitcoinexplorer1112background.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/transaction")
public class TransactionController {

    @Autowired
    private BlockService blockService;

    @Autowired
    private TransactionService transactionService;

    @Autowired
    private DetailService detailService;

    @GetMapping("/getRecentUnconfirmed")
    public List<JSONObject> getRecentUnconfirmed(@RequestParam(required = false,defaultValue = "20") Integer size){
        return null;
    }

    @GetMapping("/getByTxhash")
    public JSONObject getByTxhash(@RequestParam String txhash){
        return null;
    }

    @GetMapping("/getTransactionByBlockId")
    public List<Transaction> getTransactionByBlockId(@RequestParam Integer blockId){
        List<Transaction> transactions = transactionService.getTransactionByBlockId(blockId);
        return transactions;
    }

    @GetMapping("/getTransactionByBlockhashWithPage")
    public PageDTO<JSONObject> getByBlockhashWithPage(@RequestParam String blockhash,
                                                      @RequestParam(required = false, defaultValue = "1") Integer page){
        Block block = blockService.getBlockByBlockhash(blockhash);
        Integer blockId = block.getBlockId();
        Page<Transaction> pageTx = transactionService.getTransactionByBlockIdWithPage(blockId, page);

        List<JSONObject> txJsons = pageTx.stream().map(tx -> {
            JSONObject txJson = new JSONObject();
            txJson.put("txid", tx.getTxid());
            txJson.put("txhash", tx.getTxhash());
            txJson.put("time", tx.getTime());
            txJson.put("fees", tx.getFees());
            txJson.put("totalOutput", tx.getTotalOutput());

            List<Detail> txDetails = detailService.getDetailByTransactionId(tx.getTransactionId());
            List<JSONObject> txDetailJsons = txDetails.stream().map(txDetail -> {
                JSONObject txDetailJson = new JSONObject();
                txDetailJson.put("address", txDetail.getAddress());
                txDetailJson.put("type", txDetail.getType());
                txDetailJson.put("amount", Math.abs(txDetail.getAmount()));
                return txDetailJson;
            }).collect(Collectors.toList());
            txJson.put("txDetails", txDetailJsons);
            return txJson;
        }).collect(Collectors.toList());


        PageDTO<JSONObject> pageDTO = new PageDTO<>();
        pageDTO.setTotal(pageTx.getTotal());
        pageDTO.setPageSize(PageConfig.PAGE_SIZE);
        pageDTO.setCurrentPage(pageTx.getPageNum());
        pageDTO.setList(txJsons);

        return pageDTO;

    }
}
