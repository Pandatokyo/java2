package lesson1.classes;

import participants.Cat;
import participants.Dog;
import CourseObstacles.Obstacle;
import participants.Participant;
import participants.Robot;

/*
2. Добавить класс Team, который будет содержать название команды,массив из четырех участников (в конструкторе можно сразу указыватьвсех участников ),
 метод для вывода информации о членах команды, прошедших дистанцию,
 метод вывода информации обо всех членах команды.
*/
public class Team {
    private final String name;// название команды
    private Participant[] participants;    // участники

    public Team(String name) {
        this.name = name;
    }

    public Team(String name,Participant ... participantsGiven ) {
        this.name = name;
        this.participants = participantsGiven;
    }

    public void getTeamInfo() {
        System.out.println("Команда: " + this.name );
        for (Participant participant : participants) {
            if (participant instanceof Dog) {
                System.out.println("Собака " + participant.getName());
            }
            if (participant instanceof Cat) {
                System.out.println("Кот " + participant.getName());
            }
            if (participant instanceof Robot) {
                System.out.println("Робот " + participant.getName());
            }
        }
    }

    public void showResults(){
        for (Participant participant : participants) {
            //obstacle.doIt(participant);
            if (!participant.isOnDistance()) {
                break;
            }
        }
    }
    public void doIt(Obstacle obstacle){
        for (Participant participant : participants) {
            obstacle.doIt(participant);
        }
    }



}
