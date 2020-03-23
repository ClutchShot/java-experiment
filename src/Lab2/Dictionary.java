package Lab2;

import java.io.*;
import java.util.*;

public class Dictionary  {

    private HashMap<String, Integer> dictionary;
    private List<Word> SortedDictionary;

    Dictionary(){
        dictionary = new HashMap<>();
        SortedDictionary = new ArrayList<>();
    }


    void addWord(String word){
        if (word.isEmpty()){
            return;
        }
        String wordLow = word.toLowerCase();
        if (WordExists(wordLow)){
            int numb = dictionary.get(wordLow) + 1;
            dictionary.replace(wordLow, numb);
        }
        else {
            dictionary.put(wordLow,1);
        }
    }

    boolean WordExists(String word){
        if (dictionary.containsKey(word))
            return true;
        else
            return false;
    }


    void Print(){
        for (Map.Entry<String,Integer> map: dictionary.entrySet()){
            System.out.println(map.getKey()+" "+ map.getValue());
        }
    }

    void PrintSorted(){
        Sort();
        for (Word temp: SortedDictionary) {
            System.out.println(temp.getStatus());
        }
    }

    void WriteToFile(String location) throws IOException {

        BufferedWriter writer = new BufferedWriter(new FileWriter(location, true));

        for (int i=0;i < SortedDictionary.size(); i++ ) {
            writer.write(SortedDictionary.get(i).getStatus());
            writer.newLine();
            writer.flush();
        }
        writer.close();
    }

    void Sort(){
        for (Map.Entry<String,Integer> map: dictionary.entrySet()){
            SortedDictionary.add(new Word(map.getKey(), map.getValue()));
        }

        SortedDictionary.sort(new Comparator<Word>() {
            @Override
            public int compare(Word o1, Word o2) {
                return Integer.compare(o2.getFrequency(), o1.getFrequency());
            }
        });
    }
}

class Word{
    private String word;
    private int frequency;

    Word(String word, int frequency ){
        this.word=word;
        this.frequency=frequency;
    }

    String getWord(){
        return  word;
    }

    String getStatus(){
        return word +" "+ frequency ;
    }

    boolean isEqual(String word){
        if (this.word.equals(word)){
            return  true;
        }
        else
            return false;
    }
    int getFrequency(){
        return  frequency;
    }

}