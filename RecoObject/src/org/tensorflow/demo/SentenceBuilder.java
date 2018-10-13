package org.tensorflow.demo;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public  class SentenceBuilder {

private SentenceBuilder(){} // private constructor => static class

    public final static String describe(List<Classifier.Recognition> recognitions){
        String res = "Il y a ";
        Map<String, Integer> objectOccurences = new HashMap<String, Integer>();

        // Construction de la table de correspondance (objet, nombreApparitions)
        for (Classifier.Recognition rec : recognitions){
            // TODO Qu'est-ce qu'on fait des éléments à faible confiance ?
            // TODO NOTE On fait les estimations de distances finalement ???
            if(!objectOccurences.containsKey(rec.getTitle())) {
                objectOccurences.put(rec.getTitle(), 1);
            }
            else {
                objectOccurences.put(rec.getTitle(), objectOccurences.get(rec.getTitle())+1);
            }
        }
        int taille = objectOccurences.size();
        int i = 0;
        // Exploitation de la table de correspondance pour construire la description
        for (Entry<String, Integer> ent : objectOccurences.entrySet()) {
            if(!ent.getKey().equals("???")) {
                if ((taille - 3) == i && taille >2){
                    res = res + ent.getValue() + " " + ent.getKey() + " et ";
                }
                else{
                    res = res + ent.getValue() + " " + ent.getKey() + ", ";
                }
                i++;
            }
        }
        // TODO En annexe, pour la dernière entrée, on met un "et"
        if("Il y a ".equals(res)) res="Rien n'est détecté, veuillez recommcencer";
        return res;
    }
    public final static String describePersons(List<Classifier.Recognition> recognitions){
        String res = "Il y a ";
        Map<String, Integer> objectOccurences = new HashMap<String, Integer>();

        // Construction de la table de correspondance (objet, nombreApparitions)
        for (Classifier.Recognition rec : recognitions){
            // TODO Qu'est-ce qu'on fait des éléments à faible confiance ?
            // TODO NOTE On fait les estimations de distances finalement ???
            if(!objectOccurences.containsKey(rec.getTitle())) {
                objectOccurences.put(rec.getTitle(), 1);
            }
            else {
                objectOccurences.put(rec.getTitle(), objectOccurences.get(rec.getTitle())+1);
            }
        }
        int i =0;
        // Exploitation de la table de correspondance pour construire la description
        for (Entry<String, Integer> ent : objectOccurences.entrySet()) {
            if(ent.getKey().equals("personne"))
                    res = res + ent.getValue() + " " + ent.getKey();
            i++;
        }
        if ("Il y a ".equals(res)) res = "Aucune personne n'a été détecté";
        return res;
    }

}