package io.lw.bitcoinexplorer1112background.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/address")
public class AddressController {

    public JSONObject getInfoByAddress(@RequestParam String address){
        return null;
    }
}
