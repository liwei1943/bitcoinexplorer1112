package io.lw.bitcoinexplorer1112background.dao;

import io.lw.bitcoinexplorer1112background.po.Detail;

public interface DetailMapper {
    int insert(Detail record);

    int insertSelective(Detail record);
}