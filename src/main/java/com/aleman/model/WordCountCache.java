package com.aleman.model;

import org.springframework.stereotype.Component;

import java.util.concurrent.ConcurrentHashMap;

/**
 * Cache Map
 */
@Component
public class WordCountCache {

    ConcurrentHashMap<String,WordCountModel> wordCountMap = new ConcurrentHashMap<>();

    public ConcurrentHashMap<String, WordCountModel> getWordCountMap() {
        return wordCountMap;
    }

    public void setWordCountMap(ConcurrentHashMap<String, WordCountModel> wordCountMap) {
        this.wordCountMap = wordCountMap;
    }

}
