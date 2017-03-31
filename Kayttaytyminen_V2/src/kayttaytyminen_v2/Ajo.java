package kayttaytyminen_v2;

import lejos.nxt.SensorPort;
import lejos.robotics.subsumption.Arbitrator;
import lejos.robotics.subsumption.Behavior;

public class Ajo {

    public static void main(String[] args) {
        
        Behavior osa1 = new AjaaEteenpain();
        Behavior osa2 = new HuomaaSeina(SensorPort.S1);
        Behavior osa3 = new HuomaaEste(SensorPort.S1);
        Behavior [] taulu = {osa1, osa3, osa2};
        Arbitrator arby = new Arbitrator(taulu);
        
        arby.start();
    }
    
}
