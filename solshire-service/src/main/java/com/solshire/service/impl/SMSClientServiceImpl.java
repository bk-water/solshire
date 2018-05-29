package com.solshire.service.impl;

import com.solshire.model.domain.SMSClient;
import com.solshire.service.SMSClientService;
import org.springframework.stereotype.Service;

@Service("sMSClientService")
public class SMSClientServiceImpl extends BaseServiceImpl<SMSClient, Integer> implements SMSClientService {
}