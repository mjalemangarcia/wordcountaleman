package com.aleman.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class ReadFromUrl {

    public void getReadFromUrl(String url) {

        try {
            URL urlObject = new URL(url);
            BufferedReader reader = new BufferedReader(new InputStreamReader(urlObject.openStream()));

            StringBuilder content = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }

            reader.close();

        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
