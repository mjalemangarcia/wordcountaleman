package com.aleman.service;

import com.aleman.model.WordModel;

import java.util.concurrent.ConcurrentHashMap;

public interface ReadFileService {
    ConcurrentHashMap<String, WordModel> getReadFile(String valuePath);
}
