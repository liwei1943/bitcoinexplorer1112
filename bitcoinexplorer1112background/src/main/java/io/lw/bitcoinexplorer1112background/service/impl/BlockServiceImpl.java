package io.lw.bitcoinexplorer1112background.service.impl;


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



}
