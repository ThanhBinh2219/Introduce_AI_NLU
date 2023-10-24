package agent_AB_Task2;

import java.util.Random;

import agent_AB_Task2.Environment.LocationState;

public class AgentProgram {
    private Random random = new Random();
    private int score = 0;

    public Action execute(Percept p) {
        if (p.getLocationState() == Environment.LocationState.DIRTY) {
            score += 500;
            return Environment.SUCK_DIRT;
        } else {
            // Generate a random action (UP, DOWN, LEFT, RIGHT)
            int randomAction = random.nextInt(4);
            switch (randomAction) {
                case 0:
                    return Environment.MOVE_UP;
                case 1:
                    return Environment.MOVE_DOWN;
                case 2:
                    return Environment.MOVE_LEFT;
                case 3:
                    return Environment.MOVE_RIGHT;
            }
        }
        // If the agent can't move
        score -= 100;
        return NoOpAction.NO_OP;
    }

    public int getScore() {
        return score;
    }

    public Action execute(Percept p) {// location, status
        if (p.getLocationState() == LocationState.DIRTY) {
            return Environment.SUCK_DIRT;
        } else if (p.getAgentLocation() == Environment.LOCATION_A) {
            return Environment.MOVE_RIGHT;
        } else if (p.getAgentLocation() == Environment.LOCATION_B){
            return Environment.MOVE_DOWN;
        } else if (p.getAgentLocation() == Environment.LOCATION_C){
            return Environment.MOVE_LEFT;
        } else{
            return Environment.MOVE_UP;
        }
    }
    public static void main(String[] args) {
        Environment env = new Environment(
            Environment.LocationState.CLEAN,
            Environment.LocationState.DIRTY,
            Environment.LocationState.CLEAN,
            Environment.LocationState.DIRTY
        );

        Agent agent = new Agent(new AgentProgram());
        env.addAgent(agent, Environment.LOCATION_A);

        env.stepUntilDone();
        System.out.println("Agent's Score: " + ((AgentProgram) agent.getProgram()).getScore());
    }
}
