package kaytos;

import lejos.nxt.*;
import lejos.robotics.subsumption.*;
import lejos.robotics.navigation.DifferentialPilot;
import lejos.util.Delay;
import lejos.util.Stopwatch;
import lejos.nxt.LCD;


public class HuomaaSeina implements Behavior { //Luokka jolla hoidetaan esteen v‰istˆ ja sein‰n eteen pys‰hdys
	
	private UltrasonicSensor kaiku;
	private boolean lannista = false;
	private DifferentialPilot pilot;
	private boolean Seina; //T‰t‰ k‰ytet‰‰n sein‰n huomaamiseen
	private Stopwatch sw;
	private int aika;
	
	public HuomaaSeina(SensorPort port, DifferentialPilot pilot, Stopwatch sw){ //Rakentajalla luodaan uusi ultra‰‰ni olio, pilot olio ja aktivoidaan ajastin
		kaiku = new UltrasonicSensor(port);
		this.pilot = pilot;
		this.sw = sw;
	}
	
	public boolean takeControl() { //Luokka ottaa ohjakset kun haivaitaan este alle 15 cm p‰‰st‰
		return kaiku.getDistance() < 15;
	}
	
	public void suppress() {
		lannista = true;
	}
	
	public void action() {
		
		if(Seina){
			aika = sw.elapsed();
			
			pilot.stop();
			LCD.drawInt(aika, 0, 0);
			Button.waitForAnyPress();
		}
		
		if(!Seina){ //Kun huomataan eka este ja "Seina" arvo on false, v‰istet‰‰n
			
			lannista = false;
			
			pilot.setRotateSpeed(90);
		
			pilot.rotate(-55);
			
			pilot.forward();
			
			Delay.msDelay(2500);
			
			pilot.rotate(95);
			
			HavaitseViiva mustaArvo = new HavaitseViiva(SensorPort.S4, pilot);
			
			Seina = true; //Annetaan "Seina" muuttujalle arvo true ja k‰yett‰‰n pys‰htym‰‰n seuraavan esteen eli sein‰n eteen
			
			while(!mustaArvo.Musta()){
				pilot.forward();
			}
			
			while( Motor.B.isMoving() && !lannista ){
				Thread.yield();
			}
		}
		
	}
}
