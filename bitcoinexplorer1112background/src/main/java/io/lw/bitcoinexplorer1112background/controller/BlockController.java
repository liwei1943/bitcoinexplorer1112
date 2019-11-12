package io.lw.bitcoinexplorer1112background.controller;

import io.lw.bitcoinexplorer1112background.dao.BlockMapper;
import io.lw.bitcoinexplorer1112background.po.Block;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/block")
public class BlockController {

    @Autowired
    private BlockMapper blockMapper;

    @GetMapping("/getRecentBlock")
    public List<Block> getRecentBlock(){
        List<Block> blocks =  blockMapper.getRecentBlock();
        return blocks;
    }
}
