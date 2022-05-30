package CourseObstacles;

import participants.Participant;

public class Water extends Obstacle {

    private final int length;

    public Water(int length) {
        this.length = length;
    }

    @Override
    public void doIt(Participant participant) {
        participant.swim(length);
    }
}