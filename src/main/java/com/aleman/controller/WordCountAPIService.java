package com.aleman.controller;

import com.aleman.model.WordCountModel;
import com.aleman.model.WordModel;
import com.aleman.service.ReadFileService;
import com.aleman.util.MostFrequentWord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ConcurrentHashMap;

@RestController
@RequestMapping("/wordcount")
public class WordCountAPIService {

    @Autowired
    private WordCountModel wordCountModel;

    @Autowired
    private MostFrequentWord mostFrequentWord;

    @Autowired
    ReadFileService readFileService;

    @GetMapping("/")
    public WordCountModel getAlemanwordcount(@RequestParam String url) {

        ConcurrentHashMap<String, WordModel> wordReadModel = new ConcurrentHashMap<>();

        wordReadModel = readFileService.getReadFile(url);

        System.out.println("===PRINT");
        System.out.println("Count word =" + wordReadModel.size());
        System.out.println("Average word length =" + wordCountModel.getAverageWordLength());
        return new WordCountModel(url,wordCountModel.getWordcount(), wordCountModel.getAverageWordLength(),mostFrequentWord.printMostFrequentWord(wordCountModel.getMostFrequentWord()),wordCountModel.getListNumberWordEach());
    }



}
