package kayttaytyminen_v2;

import lejos.nxt.*;
import lejos.robotics.subsumption.*;

public class HuomaaEste implements Behavior {
    
    private boolean lannista = false;
    private UltrasonicSensor kaiku;
    public boolean esteNahty = false;
    
    public HuomaaEste(SensorPort port){
        kaiku = new UltrasonicSensor( port );
    }
    
    public boolean takeControl(){
        return kaiku.getDistance() > 25;
    }
    
    public void suppress() {
        lannista = true;
        esteNahty = true;
    }
    
    public void action() {
        
        lannista = false;
        Motor.A.rotate(-270);
        Motor.B.rotate(90);
        
        while( Motor.B.isMoving() && !lannista)
            Thread.yield();
        
        Motor.A.stop();
        Motor.B.stop();
    }
    
    
}
