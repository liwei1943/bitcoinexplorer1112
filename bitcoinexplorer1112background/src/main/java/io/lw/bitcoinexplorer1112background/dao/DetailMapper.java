package io.lw.bitcoinexplorer1112background.dao;

import io.lw.bitcoinexplorer1112background.po.Detail;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DetailMapper {
    int insert(Detail record);

    int insertSelective(Detail record);

    List<Detail> getDetailByTransactionId(@Param("transactionId") Integer transactionId);


    Integer getTotalByAddress(@Param("address") String address);

    Double getReceiveByAddress(@Param("address") String address);

    Double getSendByAddress(@Param("address") String address);
}