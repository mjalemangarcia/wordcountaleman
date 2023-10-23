package com.aleman.controller;

import com.aleman.model.WordCountModel;
import com.aleman.util.MostFrequentWord;
import com.aleman.util.NumberOfWordsOfLength;
import com.aleman.service.ReadFromUrlImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/wordcount")
public class WordCountAPIService {

    @Autowired
    private WordCountModel wordCountModel;

    @Autowired
    private NumberOfWordsOfLength numberOfWordsOfLength;

    @Autowired
    private MostFrequentWord mostFrequentWord;
    @GetMapping("/")
    public WordCountModel getAlemanwordcount(@RequestParam String url) {

        ReadFromUrlImpl readFromUrlService = new ReadFromUrlImpl(wordCountModel);
        readFromUrlService.getReadFile(url);
        System.out.println("===PRINT");
        System.out.println("Count word =" + wordCountModel.getWordcount());
        System.out.println("Average word length =" + wordCountModel.getAverageWordLength());
        numberOfWordsOfLength.printNumberOfWordsOfLength(wordCountModel.getListNumberWordEach());
        mostFrequentWord.printMostFrequentWord(wordCountModel.getMostFrequentWord());
        return new WordCountModel(url,wordCountModel.getWordcount(), wordCountModel.getAverageWordLength(), wordCountModel.getMostFrequentWord(),wordCountModel.getListNumberWordEach());
    }



}
