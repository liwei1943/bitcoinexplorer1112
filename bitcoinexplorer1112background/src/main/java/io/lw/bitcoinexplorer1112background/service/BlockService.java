package io.lw.bitcoinexplorer1112background.service;


import com.github.pagehelper.Page;
import io.lw.bitcoinexplorer1112background.po.Block;
import org.springframework.scheduling.annotation.Async;

import java.util.List;

public interface BlockService {

    String syncBlock(String blockhash);

    @Async
    void syncBlocks(String fromBlockhash);

    List<Block> getRecentBlock();

    Page<Block> getWithPage(Integer page);

    Block getBlockByBlockhash(String blockhash);

    Block getInfoByHeight(Integer height);
}
