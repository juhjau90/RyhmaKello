package kayttaytyminen_v2;

import lejos.nxt.*;
import lejos.robotics.subsumption.*;

public class AjaaEteenpain implements Behavior {
    
    private boolean lannista = false;
    
    public boolean takeControl(){
        return true;
    }
    
    public void suppress(){
        lannista = true;
    }
    
    public void action(){
        
        lannista = false; 
        Motor.A.forward();
        Motor.B.forward();
        
        while( !lannista )
            Thread.yield();
        
        Motor.A.stop();
        Motor.B.stop();
        
    }
}
