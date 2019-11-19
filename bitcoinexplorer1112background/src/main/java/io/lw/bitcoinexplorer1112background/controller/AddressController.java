package io.lw.bitcoinexplorer1112background.controller;

import com.alibaba.fastjson.JSONObject;
import io.lw.bitcoinexplorer1112background.service.DetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/address")
public class AddressController {

    @Autowired
    private DetailService detailService;

    @GetMapping("/getInfoByAddress")
    public JSONObject getInfoByAddress(@RequestParam String address){
        Integer totalByAddress = detailService.getTotalByAddress(address);
        Double receiveByAddress = detailService.getReceiveByAddress(address);
        Double sendByAddress = detailService.getSendByAddress(address);

        Double balance = receiveByAddress + sendByAddress;
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("address",address);
        jsonObject.put("txSize",totalByAddress);
        jsonObject.put("totalReceived",receiveByAddress);
        jsonObject.put("totalSent",Math.abs(sendByAddress));
        jsonObject.put("balance",balance);

        return jsonObject;
    }
}
