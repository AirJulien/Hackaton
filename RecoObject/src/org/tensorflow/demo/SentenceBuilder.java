package org.tensorflow.demo;

import java.util.List;

public  class SentenceBuilder {

private SentenceBuilder(){}; // private constructor => static class

    public final static String describe(List<Classifier.Recognition> recognitions){
        String res ="";
        for (Classifier.Recognition rec : recognitions){
            res += rec.getTitle();
        }
        return res;
    }

}
