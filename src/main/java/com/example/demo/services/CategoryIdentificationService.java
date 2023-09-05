package com.example.demo.services;

import opennlp.tools.doccat.DoccatModel;
import opennlp.tools.doccat.DocumentCategorizerME;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
@Service
public class CategoryIdentificationService {
    public String identifyCategory(String input) throws IOException {
        File file = ResourceUtils.getFile("src/main/resources/nlp-model/en-trained-model.bin");
        InputStream in = new FileInputStream(file);
        DoccatModel m = new DoccatModel(in);
        DocumentCategorizerME model = new DocumentCategorizerME(m);

        String[] inputText = input.split(" ");
        double[] outcomes = model.categorize(inputText);
        return model.getBestCategory(outcomes);
    }
}
