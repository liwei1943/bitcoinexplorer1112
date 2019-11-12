package io.lw.bitcoinexplorer1112background.service.impl;

import com.github.pagehelper.Page;
import io.lw.bitcoinexplorer1112background.dao.BlockMapper;
import io.lw.bitcoinexplorer1112background.po.Block;
import io.lw.bitcoinexplorer1112background.service.BlockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlockServiceImpl implements BlockService {

    @Autowired
    private BlockMapper blockMapper;


    @Override
    public List<Block> getRecentBlock() {
        return blockMapper.getRecentBlock();
    }

    @Override
    public Page<Block> getWithPage() {
        return blockMapper.getWithPage();
    }

    @Override
    public Block selectByPrimaryKey(String blockhash) {
        return blockMapper.selectByPrimaryKey(blockhash);
    }
}
