package com.aleman.util;

import com.aleman.model.WordCountModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

@Component
public class MostFrequentWord {

    public ConcurrentHashMap<Integer,Integer>  printMostFrequentWord(ConcurrentHashMap<Integer,Integer> listNumberWordEach ){

        //stream Lambda
        ConcurrentHashMap<Integer,Integer> mostFreqWord = new ConcurrentHashMap<>();
        int maxFq = listNumberWordEach.values().stream().max(Integer::compareTo).orElse(0);
        mostFreqWord = listNumberWordEach.entrySet().stream().filter(element -> element.getValue().equals(maxFq)).collect(Collectors.toMap(Map.Entry::getKey,Map.Entry::getValue,(e1, e2) -> e1,ConcurrentHashMap::new));

        System.out.println("The most frequently occuring word length is  "+ maxFq);
        for(Integer element : mostFreqWord.keySet()){
            System.out.println(", for word lengths of  " +element);
        }
        return mostFreqWord;
    }
}
