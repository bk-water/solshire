package com.solshire.service.impl;

import com.solshire.model.domain.ResourceFile;
import com.solshire.service.ResourceFileService;
import org.springframework.stereotype.Service;

@Service("resourceFileService")
public class ResourceFileServiceImpl extends BaseServiceImpl<ResourceFile, Integer> implements ResourceFileService {
}