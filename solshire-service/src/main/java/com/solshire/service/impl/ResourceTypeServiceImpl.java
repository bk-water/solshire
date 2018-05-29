package com.solshire.service.impl;

import com.solshire.model.domain.ResourceType;
import com.solshire.service.ResourceTypeService;
import org.springframework.stereotype.Service;

@Service("resourceTypeService")
public class ResourceTypeServiceImpl extends BaseServiceImpl<ResourceType, Integer> implements ResourceTypeService {
}