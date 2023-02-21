package it.figuccia;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Start {
    public static void main(String[] args) throws FileNotFoundException {
        FileReader fileReader = new FileReader("resources/File.txt");//legge il file
        BufferedReader bufferedReader = new BufferedReader(fileReader);//per mantenere in memoria le righe del file per editarle
//        Map<String, Integer> fileMap = new HashMap<>();
        Map<String, Integer> fileMap = new TreeMap<>();//in ordine alfabetico

        while (true) {
            try {
                if (!bufferedReader.ready()) break;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            try {
                String lineBuffer = bufferedReader.readLine();
                lineBuffer = lineBuffer.replaceAll("![^a-zA-Z0-9\\s]","");
                String[] stringLine = lineBuffer.split(" ");
//                System.out.println(Arrays.toString(stringLine));
                for (String parola : stringLine){
                    if (fileMap.containsKey(parola)){
                        int oldValue = fileMap.get(parola);
                        fileMap.put(parola, ++oldValue);
                    } else fileMap.put(parola, 1);
                }
            }catch (IOException e){
                throw new RuntimeException(e);
            }
        }
        //per ciclare un for su una mappa
        for (String key : fileMap.keySet()) {
            System.out.println(key + " " + fileMap.get(key));
            //System.out.println(fileMap);
        }
    }
}
