package kayttaytyminen_v2;

import lejos.nxt.*;
import lejos.robotics.subsumption.*;

public class HuomaaSeina implements Behavior {
    
    private boolean lannista = false;
    private UltrasonicSensor kaiku;
    HuomaaEste ekaVaisto;
    
    public HuomaaSeina(SensorPort port){
        kaiku = new UltrasonicSensor( port );
    }
    
    public boolean takeControl(){   
        return kaiku.getDistance() > 20 && ekaVaisto.esteNahty = true;
    }
    
    public void suppress() {
        lannista = true;
    }
    
    public void action(){
        
        Motor.A.stop();
        Motor.B.stop();
        
    }
}
