package io.lw.bitcoinexplorer1112background.controller;

import com.alibaba.fastjson.JSONObject;
import io.lw.bitcoinexplorer1112background.po.Block;
import io.lw.bitcoinexplorer1112background.service.BlockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/block")
public class BlockController {

    @Autowired
    private BlockService blockService;

    @GetMapping("/getRecentBlock")
    public List<JSONObject> getRecentBlock(){
        List<Block> block= blockService.getRecentBlock();
        List<JSONObject> blockJsons = block.stream().map(block1 -> {
            JSONObject blockJson = new JSONObject();
            blockJson.put("height", block1.getHeight());
            blockJson.put("blockhash", block1.getBlockhash());
            blockJson.put("time", block1.getTime());
            blockJson.put("miner", block1.getMiner());
            blockJson.put("size", block1.getSizeondisk());
            return blockJson;
        }).collect(Collectors.toList());

        return blockJsons;
    }

    @GetMapping("/getWithPage")
    public List<JSONObject> getWithPage(@RequestParam(required = false, defaultValue = "1") Integer page){
        return null;
    }

    @GetMapping("/getInfoByHash")
    public JSONObject getInfoByHash(@RequestParam String blockhash){
        return null;
    }

    @GetMapping("/getInfoByHeight")
    public JSONObject getInfoByHeight(@RequestParam Integer height){
        return null;
    }


}
