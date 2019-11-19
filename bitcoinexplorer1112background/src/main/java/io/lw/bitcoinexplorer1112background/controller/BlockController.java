package io.lw.bitcoinexplorer1112background.controller;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.Page;
import io.lw.bitcoinexplorer1112background.dto.PageDTO;
import io.lw.bitcoinexplorer1112background.po.Block;
import io.lw.bitcoinexplorer1112background.service.BlockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/block")
@CrossOrigin
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
    public PageDTO<JSONObject> getWithPage(@RequestParam(required = false, defaultValue = "1") Integer page){
        Page<Block> blocks = blockService.getWithPage(page);
        List<JSONObject> blockJsons = blocks.stream().map(block -> {
            JSONObject blockJson = new JSONObject();
            blockJson.put("height", block.getHeight());
            blockJson.put("blockhash", block.getBlockhash());
            blockJson.put("time", block.getTime());
            blockJson.put("miner", block.getMiner());
            blockJson.put("size", block.getSizeondisk());
            return blockJson;
        }).collect(Collectors.toList());

        PageDTO<JSONObject> pageDTO = new PageDTO<>();
        pageDTO.setList(blockJsons);
        pageDTO.setTotal(blocks.getTotal());
        pageDTO.setPageSize(blocks.getPageSize());
        pageDTO.setCurrentPage(blocks.getPageNum());

        return pageDTO;
    }

    @GetMapping("/getInfoByHash")
    public JSONObject getInfoByHash(@RequestParam String blockhash){
        JSONObject blockInfoJson = new JSONObject();

        Block block = blockService.getBlockByBlockhash(blockhash);
        blockInfoJson.put("blockhash",block.getBlockhash());
        blockInfoJson.put("confirmations",null);
        blockInfoJson.put("time",block.getTime());
        blockInfoJson.put("height",block.getHeight());
        blockInfoJson.put("miner",block.getMiner());
        blockInfoJson.put("txSize",block.getTxnumber());
        blockInfoJson.put("difficulty",block.getDifficulty());
        blockInfoJson.put("merkleroot",block.getMerkleRoot());
        blockInfoJson.put("version",block.getVersion());
        blockInfoJson.put("bits",block.getBits());
        blockInfoJson.put("weight",block.getWeight());
        blockInfoJson.put("sizeOnDisk",block.getSizeondisk());
        blockInfoJson.put("nonce",block.getNonce());
        blockInfoJson.put("txVol",block.getTxvolume());
        blockInfoJson.put("blockReward",block.getBlockReward());
        blockInfoJson.put("feeReward",block.getFeeReward());

        return blockInfoJson;
    }

    @GetMapping("/getInfoByHeight")
    public JSONObject getInfoByHeight(@RequestParam Integer height){
        return null;
    }


}
