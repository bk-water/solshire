package com.solshire.service.impl;

import com.solshire.model.domain.Context;
import com.solshire.service.ContextService;
import org.springframework.stereotype.Service;

@Service("contextService")
public class ContextServiceImpl extends BaseServiceImpl<Context, Integer> implements ContextService {
}