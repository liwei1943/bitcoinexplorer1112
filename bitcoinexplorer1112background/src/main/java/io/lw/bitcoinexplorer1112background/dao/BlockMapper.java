package io.lw.bitcoinexplorer1112background.dao;


import com.github.pagehelper.Page;
import io.lw.bitcoinexplorer1112background.po.Block;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BlockMapper {
    int deleteByPrimaryKey(String blockhash);

    int insert(Block record);

    int insertSelective(Block record);

    Block selectByPrimaryKey(String blockhash);

    int updateByPrimaryKeySelective(Block record);

    int updateByPrimaryKey(Block record);



    List<Block> getRecentBlock();

    Page<Block> getWithPage();

    Block getBlockByBlockhash(@Param("blockhash") String blockhash);

}