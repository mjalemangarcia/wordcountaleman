package com.aleman.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;


@Component
public class WordCountModel {

    private String URL;
    private int wordcount;
    private double averageWordLength;

    //hash key , it cannot be repeated. Important
    private ConcurrentHashMap<Integer, Integer> mostFrequentWord = new ConcurrentHashMap<>();
    private ConcurrentHashMap<Integer,Integer>  listNumberWordEach = new ConcurrentHashMap<>();

    public String getURL() {
        return URL;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }

    public int getWordcount() {
        return wordcount;
    }

    public void setWordcount(int wordcount) {
        this.wordcount = wordcount;
    }

    public double getAverageWordLength() {
        return averageWordLength;
    }

    public void setAverageWordLength(double averageWordLength) {
        this.averageWordLength = averageWordLength;
    }

    public ConcurrentHashMap<Integer,Integer> getMostFrequentWord() {
        return mostFrequentWord;
    }

    public void setMostFrequentWord(ConcurrentHashMap<Integer,Integer> mostFrequentWord) {
        this.mostFrequentWord = mostFrequentWord;
    }

    public ConcurrentHashMap<Integer,Integer> getListNumberWordEach() {
        return listNumberWordEach;
    }

    public void setListNumberWordEach(ConcurrentHashMap<Integer,Integer> listNumberWordEach) {
        this.listNumberWordEach = listNumberWordEach;
    }

    //Constructor
    public WordCountModel(String s, int i, double v, String s1, String s2, String s3) {
    }


    public WordCountModel(String URL, int wordcount, double averageWordLength, ConcurrentHashMap<Integer,Integer>  mostFrequentWord, ConcurrentHashMap<Integer,Integer>  listNumberWordEach) {
        this.URL = URL;
        this.wordcount = wordcount;
        this.averageWordLength = averageWordLength;
        this.mostFrequentWord = mostFrequentWord;
        this.listNumberWordEach = listNumberWordEach;
    }

}
