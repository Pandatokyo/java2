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
                new Cat("Барсик", 12, 2, 0),
                new Dog("Дружок", 10, 15, 5),
                new Cat("Мурзик", 9, 14, 0),
                new Robot("Вертер", 30, 20, 14));  // Создаем команду
        team.getTeamInfo();

        c.doIt(team);               // Просим команду пройти полосу
        team.showResults();         // Показываем результаты

    }
}
