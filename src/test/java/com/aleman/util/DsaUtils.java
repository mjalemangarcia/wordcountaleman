package com.aleman.util;

import com.aleman.model.WordModel;

import java.util.concurrent.ConcurrentHashMap;

public class DsaUtils {

    public static ConcurrentHashMap<Integer,Integer> mostFreqWord() {
        ConcurrentHashMap<Integer,Integer> mostFreqWord = new ConcurrentHashMap<>();
            mostFreqWord.put(2,2);
        return mostFreqWord;
    }
    public static ConcurrentHashMap<Integer, Integer> listNumberWordEach() {
        ConcurrentHashMap<Integer, Integer> listNumberWordEach = new ConcurrentHashMap<>();
            listNumberWordEach.put(1,1);
            listNumberWordEach.put(2,2);
            listNumberWordEach.put(3,2);
        return listNumberWordEach;
    }
    public static ConcurrentHashMap<String, WordModel> wordModelConcurrentHashMap() {
        ConcurrentHashMap<String, WordModel> wordModelConcurrentHashMap = new ConcurrentHashMap<>();
            wordModelConcurrentHashMap.put("Hello", new WordModel(5,1));
            wordModelConcurrentHashMap.put("world", new WordModel(5,1));
            wordModelConcurrentHashMap.put("&", new WordModel(1,1));
            wordModelConcurrentHashMap.put("good", new WordModel(5,1));
            wordModelConcurrentHashMap.put("morning", new WordModel(7,1));
            wordModelConcurrentHashMap.put("The", new WordModel(3,1));
            wordModelConcurrentHashMap.put("is", new WordModel(2,1));
            wordModelConcurrentHashMap.put("18/05/2016", new WordModel(10,1));
        return wordModelConcurrentHashMap;
    }
}
