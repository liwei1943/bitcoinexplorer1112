package io.lw.bitcoinexplorer1112background.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import io.lw.bitcoinexplorer1112background.dao.BlockMapper;
import io.lw.bitcoinexplorer1112background.po.Block;
import io.lw.bitcoinexplorer1112background.service.BlockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/block")
public class BlockController {

    @Autowired
    private BlockService blockService;

    @GetMapping("/getRecentBlock")
    public List<Block> getRecentBlock(){
        List<Block> blocks =  blockService.getRecentBlock();
        return blocks;
    }


    @GetMapping("/getWithPage")
    public PageInfo<Block> getWithPage(@RequestParam(required = false, defaultValue = "1") Integer page){
        Page<Block> blockPage = blockService.getWithPage();
        PageInfo<Block> blockPageInfo = blockPage.toPageInfo();
        return blockPageInfo;
    }

    @GetMapping("/getInfoByHash")
    public Block getInfoByHash(String blockhash){
        Block block = blockService.selectByPrimaryKey(blockhash);
        return block;
    }


}
