package com.aleman.service;

import com.aleman.model.WordCountModel;
import com.aleman.model.WordModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class ReadFromUrlImpl implements ReadFileService {

    private WordCountModel wordCountModel;

    @Autowired
    public ReadFromUrlImpl(WordCountModel wordCountModel) {
        this.wordCountModel = wordCountModel;
    }
    public ConcurrentHashMap<String, WordModel> getReadFile(String url) {

        int countWord = 0;
        double sum = 0;
        double averageWordLength = 0;


        ConcurrentHashMap<String, WordModel> wordLength = new ConcurrentHashMap<>();
        ConcurrentHashMap<Integer,Integer> listNumberWordEach =  new ConcurrentHashMap<>();

        try {
            URL urlObject = new URL(url);
            BufferedReader reader = new BufferedReader(new InputStreamReader(urlObject.openStream()));

            StringBuilder content = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                String words[] = line.split("\\s+");
                for(String wordElement : words) {
                    if(wordElement != null) {
                        //We need to
                        wordElement = wordElement.replaceAll("[^a-zA-Z0-9&]", "");
                        // Check if the cleaned word is not empty
                        if (!wordElement.isEmpty()) {
                            if (wordLength.containsKey(wordElement)) {
                                WordModel wordModelElement = wordLength.get(wordElement);
                                int countElement = wordModelElement.getCount();
                                countElement++;
                                wordModelElement.setCount(countElement);
                                wordLength.put(wordElement, wordModelElement);
                            } else {
                                countWord++;
                                wordLength.putIfAbsent(wordElement, new WordModel(wordElement.length(), 1));
                            }
                        }
                    }
                }

                content.append(line).append("\n");
            }

            //Average Word Length calculation
            for(String wordElement : wordLength.keySet() ) {
                //Average size
                WordModel wordModelElement = wordLength.get(wordElement);
                sum = wordModelElement.getLength() + sum;

                if(wordLength.containsKey(wordElement)) {
                    Integer length = wordModelElement.getLength();

                    if(listNumberWordEach.containsKey(length)) {
                        Integer count = listNumberWordEach.get(length);
                        count++;
                        listNumberWordEach.replace(length,count);
                    } else {
                        listNumberWordEach.put(length,1);
                    }

                }

            }
            averageWordLength = (!wordLength.isEmpty()) ? (sum / wordLength.size()) : 0;
            reader.close();

        } catch (IOException e) {
            System.out.println(e);
            return new ConcurrentHashMap<>();
        }

        wordCountModel.setMostFrequentWord(listNumberWordEach);
        wordCountModel.setListNumberWordEach(listNumberWordEach);
        wordCountModel.setAverageWordLength(averageWordLength);
        wordCountModel.setWordcount(countWord);
        return wordLength;
    }
}
