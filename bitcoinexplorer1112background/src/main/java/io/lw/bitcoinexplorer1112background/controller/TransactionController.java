package io.lw.bitcoinexplorer1112background.controller;


import io.lw.bitcoinexplorer1112background.po.Transaction;
import io.lw.bitcoinexplorer1112background.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transaction")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @GetMapping("/getRecentUnconfirmed")
    public Transaction getRecentUnconfirmed(@RequestBody Integer size){
        Transaction transactions = transactionService.getRecentUnconfirmed(size);
        return transactions;
    }
}
