package lesson3;

import java.util.*;

public class Phonebook {

    private final HashMap<String, List<String>> phonebook;

    public Phonebook() {
        this.phonebook = new HashMap<>();
    }

    public void add(String surname, String number){
        if (phonebook.containsKey(surname)) {
            List<String> numbers = phonebook.get(surname);
            if (!numbers.contains(number)) {
                numbers.add(number);
                System.out.printf("Номер %s добавлен для фамилии %s", number, surname);
            } else {
                System.out.printf("Номер %s уже существует для фамилии %s", number, surname);
            }
        } else {
            phonebook.put(surname, new ArrayList<>(List.of(number)));
            System.out.printf("Номер %s добавлен для фамилии %s", number, surname);
        }
    }

    public List<String> get(String surname) {
        if (phonebook.containsKey(surname)) {
            return phonebook.get(surname);
        } else {
            System.out.printf("Фамилия %s отсутствует", surname);
            return new ArrayList<>();
        }
    }
}
