package kayttaytyminen;

import lejos.nxt.*;
import lejos.robotics.subsumption.*;

public class HuomaaSeina implements Behavior {
    
    private UltrasonicSensor kaiku;
    private boolean lannista = false;
    
    public HuomaaSeina(SensorPort port) {
        kaiku = new UltrasonicSensor( port );
    }
    
    public boolean takeControl() {          //luokka ottaa ohjakset käsiin kun
        return kaiku.getDistance() < 40;    //ultraääni havaitsee esteen alle 40
    }                                       //sentin päässä.
    
    public void suppress() {
        lannista = true;
    }
    
    public void action() {
        
        lannista = false;
        Motor.A.forward();
        Motor.C.forward();
        
        while( Motor.C.isMoving() && !lannista )
            Thread.yield();
        
        Motor.A.stop();
        Motor.C.stop();
        
    }
}
