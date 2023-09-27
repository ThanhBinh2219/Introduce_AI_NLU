package agent_AB_Task2;

import agent_AB_Task2.Environment.LocationState;

public class AgentProgram {

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
}