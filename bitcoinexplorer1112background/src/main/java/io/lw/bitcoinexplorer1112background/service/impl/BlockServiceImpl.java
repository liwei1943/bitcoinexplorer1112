package io.lw.bitcoinexplorer1112background.service.impl;


import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import io.lw.bitcoinexplorer1112background.client.BitcoinRest;
import io.lw.bitcoinexplorer1112background.dao.BlockMapper;
import io.lw.bitcoinexplorer1112background.po.Block;
import io.lw.bitcoinexplorer1112background.service.BlockService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BlockServiceImpl implements BlockService {

    @Autowired
    private BlockMapper blockMapper;

    @Autowired
    private BitcoinRest bitcoinRest;

    @Autowired
    private TransactionServiceImpl transactionServiceImpl;


    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public String syncBlock(String blockhash) {
        JSONObject blockJson = bitcoinRest.getBlockNoTxDetails(blockhash);
        Block block = new Block();
        block.setBlockhash(blockJson.getString("hash"));
        block.setConfirmations(blockJson.getInteger("confirmations"));
        block.setHeight(blockJson.getInteger("height"));
        block.setTime(blockJson.getLong("time"));
        block.setDifficulty(blockJson.getDouble("difficulty"));
        block.setSizeondisk(blockJson.getInteger("size"));
        block.setMerkleRoot(blockJson.getString("merkleroot"));
        block.setTxnumber(blockJson.getInteger("nTx"));
        block.setVersion(blockJson.getString("versionHex"));
        block.setNonce(blockJson.getString("nonce"));
        block.setWeight(blockJson.getInteger("weight"));
        block.setBits(blockJson.getString("bits"));
        //todo get block reward
        //todo change bits to string
        //todo calculate tx volume, fee

        blockMapper.insert(block);

        Integer blockId = block.getBlockId();
        Long time = block.getTime();

        ArrayList<String> txids = (ArrayList<String>) blockJson.get("tx");
        for (String txid : txids) {

                transactionServiceImpl.syncTransaction(txid, blockId, time);

        }

        String nextblockhash = blockJson.getString("nextblockhash");
        return nextblockhash;
    }

    @Override
    @Async
    public void syncBlocks(String fromBlockhash) {
        logger.info("begin to sync blocks");
        String tempBlockhash = fromBlockhash;
        while (tempBlockhash != null){
            tempBlockhash = syncBlock(tempBlockhash);
        }
        logger.info("end to sync blocks");
    }

    @Override
    public List<Block> getRecentBlock() {
        List<Block> block = blockMapper.getRecentBlock();
        return block;
    }

    @Override
    public Page<Block> getWithPage(Integer page) {
        PageHelper.startPage(page, 20);
        Page<Block> blocks = blockMapper.getWithPage();
        return blocks;
    }

    @Override
    public Block getBlockByBlockhash(String blockhash) {
        Block block = blockMapper.getBlockByBlockhash(blockhash);
        return block;
    }

    @Override
    public Block getInfoByHeight(Integer height) {
        Block block = blockMapper.getInfoByHeight(height);
        return block;
    }
}
