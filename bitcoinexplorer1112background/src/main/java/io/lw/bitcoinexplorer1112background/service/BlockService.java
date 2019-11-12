package io.lw.bitcoinexplorer1112background.service;

import com.github.pagehelper.Page;
import io.lw.bitcoinexplorer1112background.po.Block;

import java.util.List;

public interface BlockService {
    List<Block> getRecentBlock();

    Page<Block> getWithPage();
}
