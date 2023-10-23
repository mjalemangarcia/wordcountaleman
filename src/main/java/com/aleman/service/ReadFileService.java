package com.aleman.service;

import com.aleman.model.WordModel;
import org.springframework.stereotype.Service;

import java.util.concurrent.ConcurrentHashMap;

@Service
public interface ReadFileService {
    ConcurrentHashMap<String, WordModel> getReadFile(String valuePath);
}
