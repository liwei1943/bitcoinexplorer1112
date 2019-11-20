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
@CrossOrigin
public class TransactionController {

    @Autowired
    private BlockService blockService;

    @Autowired
    private TransactionService transactionService;

    @Autowired
    private DetailService detailService;

    @GetMapping("/getRecentUnconfirmed")
    public List<JSONObject> getRecentUnconfirmed(@RequestParam(required = false,defaultValue = "20") Integer size){
        List<Transaction> transaction= transactionService.getRecentUnconfirmed(size);
        List<JSONObject> transactionJsons = transaction.stream().map(transaction1 -> {
            JSONObject transactionJson = new JSONObject();
            transactionJson.put("txhash", transaction1.getTxhash());
            transactionJson.put("time", transaction1.getTime());
            return transactionJson;
        }).collect(Collectors.toList());

        return transactionJsons;
    }

    @GetMapping("/getByTxhash")
    public JSONObject getByTxhash(@RequestParam String txhash){
        JSONObject transactionJson = new JSONObject();

        Transaction transaction = transactionService.getByTxhash(txhash);
        transactionJson.put("txhash",transaction.getTxhash());
        transactionJson.put("status",transaction.getStatus());
        transactionJson.put("time",transaction.getTime());
        transactionJson.put("weight",transaction.getWeight());
        transactionJson.put("confirmations",transaction.getConfirmations());
        transactionJson.put("totalInput",transaction.getTotalInput());
        transactionJson.put("totalOutput",transaction.getTotalOutput());
        transactionJson.put("fees",transaction.getFees());
        transactionJson.put("feePerByte",transaction.getFeePerByte());
        transactionJson.put("feePerWeight",transaction.getFeePerWeight());
        transactionJson.put("sizeOnDisk",transaction.getSizeondisk());

        return transactionJson;
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

    @GetMapping("/getTransactionByTxid")
    public JSONObject getTransactionByTxid(@RequestParam String txid){
        Transaction tx = transactionService.getTransactionByTxid(txid);

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
    }

    @GetMapping("/getTransactionByAddressWithPage")
    public PageDTO<JSONObject> getTransactionByAddressWithPage(@RequestParam String address,
                                                                @RequestParam(required = false,defaultValue = "1") Integer page){
        Page<Transaction> transactions = transactionService.getTransactionByAddressWithPage(address, page);

        PageDTO<JSONObject> pageDTO = getPageDTOByPageTransaction(transactions);
        return pageDTO;
    }

    private PageDTO<JSONObject> getPageDTOByPageTransaction(Page<Transaction> transactions) {
        List<JSONObject> transactionJson = transactions.stream().map(tx -> {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("txhash", tx.getTxhash());
            jsonObject.put("txid",tx.getTransactionId());
            jsonObject.put("totalOutput", tx.getTotalOutput());

            jsonObject.put("fees", tx.getFees());
            jsonObject.put("time", tx.getTime());

            List<Detail> txDetails = detailService.getDetailByTransactionId(tx.getTransactionId());
            List<JSONObject> txDetailJsons = txDetails.stream().map(txDetail -> {
                JSONObject txDetailJson = new JSONObject();
                txDetailJson.put("address", txDetail.getAddress());
                txDetailJson.put("type", txDetail.getType());
                txDetailJson.put("amount", Math.abs(txDetail.getAmount()));
                return txDetailJson;
        }).collect(Collectors.toList());
            jsonObject.put("txDetails", txDetailJsons);
            return jsonObject;
        }).collect(Collectors.toList());
        PageDTO<JSONObject> pageDTO = new PageDTO<>();
        pageDTO.setTotal(transactions.getTotal());
        pageDTO.setPageSize(PageConfig.PAGE_SIZE);
        pageDTO.setCurrentPage(transactions.getPageNum());
        pageDTO.setList(transactionJson);

        return pageDTO;
    }

    }

