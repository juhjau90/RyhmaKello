package kayttaytyminen;

import lejos.nxt.*;
import lejos.robotics.subsumption.*;

public class AjaEteenpain implements Behavior {
    
    private boolean lannista = false; //boolean jota käytetään aktivoimaan
                                      //metodeja
    
    //Kolme seuraavaa metodia ovat Behaviour luokan toiminnalle oleelisia
    //ja niitä pitää aina käyttää käyttäytymistä määrittäessä. Ajoluokassa
    //näiden metodien ohjaus luovutetaan Arbitrator luokalle joka hoitaa 
    //puolestamme niiden käsittelyn oikeassa järjestyksessä (takeControl ->
    //action -> suppress)
    
    public boolean takeControl() { //Metodi joka ilmoittaa Arbitratorille että
        return true;               //nyt tämä luokka on ottamassa ohjakset
    }
    
    public void suppress() { //Metodi joka sammuttaa/katkaisee action-metodin
        lannista = true;     //toiminnot
    }
    
    public void action() { //Metodi jossa kerrotaan mitä tehdään kun booleanin
                           //arvot muuttuvat.
        lannista = false; 
        Motor.A.forward();
        Motor.C.forward();
        
        while( !lannista )
            Thread.yield();
        
        Motor.A.stop();
        Motor.C.stop();
    }
}
