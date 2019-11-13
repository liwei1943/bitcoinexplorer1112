package io.lw.bitcoinexplorer1112background.service.impl;


import com.alibaba.fastjson.JSONObject;
import io.lw.bitcoinexplorer1112background.client.BitcoinRest;
import io.lw.bitcoinexplorer1112background.dao.BlockMapper;
import io.lw.bitcoinexplorer1112background.po.Block;
import io.lw.bitcoinexplorer1112background.service.BlockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class BlockServiceImpl implements BlockService {

    @Autowired
    private BlockMapper blockMapper;

    @Autowired
    private BitcoinRest bitcoinRest;

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

        String nextblockhash = ((JSONObject) blockJson).getString("nextblockhash");
        return nextblockhash;
    }

    @Override
    public void syncBlocks(String fromBlockhash) {
        String tempBlockhash = fromBlockhash;
        while (tempBlockhash != null){
            tempBlockhash = syncBlock(tempBlockhash);
        }
    }
}
