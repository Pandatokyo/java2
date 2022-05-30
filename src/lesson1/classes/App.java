package lesson1.classes;

import participants.Cat;
import participants.Dog;
import CourseObstacles.*;
import participants.Robot;

public class App {

    public static void main(String[] args) {

        Course c = new Course(new Cross(5),
                new Wall(3),
                new Water(7)); // Создаем полосу препятствий
        Team team = new Team("Дружба",
                new Cat("Барсик", 10, 12, 0),
                new Dog("Дружок", 20, 5, 15),
                new Cat("Мурзик", 9, 14, 0),
                new Robot("Вертер", 50, 50, 50));  // Создаем команду
        team.getTeamInfo();

        c.doIt(team);               // Просим команду пройти полосу
        team.showResults();         // Показываем результаты

    }
}
