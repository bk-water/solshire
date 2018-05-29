package com.solshire.service.impl;

import com.solshire.model.domain.Level;
import com.solshire.service.LevelService;
import org.springframework.stereotype.Service;

@Service("levelService")
public class LevelServiceImpl extends BaseServiceImpl<Level, Integer> implements LevelService {
}