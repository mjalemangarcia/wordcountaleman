package com.aleman.model;

public class WordCountModel {

    private String URL;

    private String wordcount;
    private String averageWordLength;
    private String mostFrequentWord;
    private String listNumberWordEach;



    public String getURL() {
        return URL;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }

    public String getWordcount() {
        return wordcount;
    }

    public void setWordcount(String wordcount) {
        this.wordcount = wordcount;
    }

    public String getAverageWordLength() {
        return averageWordLength;
    }

    public void setAverageWordLength(String averageWordLength) {
        this.averageWordLength = averageWordLength;
    }

    public String getMostFrequentWord() {
        return mostFrequentWord;
    }

    public void setMostFrequentWord(String mostFrequentWord) {
        this.mostFrequentWord = mostFrequentWord;
    }

    public String getListNumberWordEach() {
        return listNumberWordEach;
    }

    public void setListNumberWordEach(String listNumberWordEach) {
        this.listNumberWordEach = listNumberWordEach;
    }

    public WordCountModel(String URL, String wordcount, String averageWordLength, String mostFrequentWord, String listNumberWordEach) {
        this.URL = URL;
        this.wordcount = wordcount;
        this.averageWordLength = averageWordLength;
        this.mostFrequentWord = mostFrequentWord;
        this.listNumberWordEach = listNumberWordEach;
    }



}
