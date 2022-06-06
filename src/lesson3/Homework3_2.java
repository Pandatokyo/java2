package lesson3;

public class Homework3_2 {
    public static void main(String[] args){
        Phonebook phonebook = new Phonebook();
        phonebook.add("Фамилия1", "1234");
        phonebook.add("Фамилия2", "579");
        phonebook.add("Фамилия3", "0000");
        phonebook.add("Фамилия1", "22222");

        // тест получения номеров
        System.out.println(phonebook.get("Фамилия1"));
        System.out.println(phonebook.get("Фамилия2"));
        System.out.println(phonebook.get("Фамилия3"));
        // отсутствующая в справочнике фамиоия
        System.out.println(phonebook.get("А"));

        // тест записи уже существующего номера
        phonebook.add("Фамилия3", "0000");
        System.out.println(phonebook.get("Иванов"));
    }
}
