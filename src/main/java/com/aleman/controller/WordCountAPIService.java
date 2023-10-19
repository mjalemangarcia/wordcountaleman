package com.aleman.controller;

import com.aleman.model.WordCountModel;
import com.aleman.util.ReadFromUrl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/wordcount")
public class WordCountAPIService {

    @GetMapping("/")
    public WordCountModel getAlemanwordcount(@RequestParam String url) {

        ReadFromUrl readFromUrl = new ReadFromUrl();
        readFromUrl.getReadFromUrl(url);

        return new WordCountModel(url,"getTotalNumberWord","getAverageWordLength","getMostFrequentWord","getListNumberWordEach");
    }



}
