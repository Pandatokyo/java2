package lesson3;
import java.util.*;

public class Homework3_1 {
    public static void main(String[] args){
        List<String> words = Arrays.asList(
                "Lada", "BMW", "Lada", "Lada", "BMW",
                "Mercedes", "Ford", "Ford", "Mercedes", "Mazda", "Porsche"
        );

        Set<String> uniquewords = new HashSet<String>(words);

        System.out.println("Уникальные слова");
        System.out.println(uniquewords.toString());
        System.out.println("Частота встречаемости слов");
        for (String f : uniquewords) {
            System.out.println(f + " встречается " + Collections.frequency(words, f) + " раз.");
        }
    }
}
