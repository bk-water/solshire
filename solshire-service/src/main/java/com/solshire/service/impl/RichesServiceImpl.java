package com.solshire.service.impl;

import com.solshire.model.domain.Riches;
import com.solshire.service.RichesService;
import org.springframework.stereotype.Service;

@Service("richesService")
public class RichesServiceImpl extends BaseServiceImpl<Riches, Integer> implements RichesService {
}