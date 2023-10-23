package com.aleman.util;

import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

@Component
public class NumberOfWordsOfLength {

    public void printNumberOfWordsOfLength(ConcurrentHashMap<Integer,Integer> listNumberWordEach){


        for(Integer element : listNumberWordEach.keySet()){
            System.out.println("Number of words of length "+ element + " is " +listNumberWordEach.get(element));
        }


    }
}
