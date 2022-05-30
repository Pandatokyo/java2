package CourseObstacles;

import participants.Participant;


public class Wall extends Obstacle {

    private final int height;

    public Wall(int height) {
        this.height = height;
    }

    @Override
    public void doIt(Participant participant) {
        participant.jump(height);
    }
}