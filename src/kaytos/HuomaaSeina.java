package kaytos;

import lejos.nxt.*;
import lejos.robotics.subsumption.*;
import lejos.robotics.navigation.DifferentialPilot;
import lejos.util.Delay;
import lejos.nxt.LCD;


public class HuomaaSeina implements Behavior {
	
	private UltrasonicSensor kaiku;
	private boolean lannista = false;
	private DifferentialPilot pilot;
	
	public HuomaaSeina(SensorPort port, DifferentialPilot pilot){
		kaiku = new UltrasonicSensor(port);
		this.pilot = pilot;
	}
	
	public boolean takeControl() {
		return kaiku.getDistance() < 15;
	}
	
	public void suppress() {
		lannista = true;
	}
	
	public void action() {
		
		lannista = false;
		
		// boolean isBlocked = true;

		// kun este -> käänny
		// lue uudestaan onko estettä
		// jos este -> käänny
		// jos ei -> eteen
		
		pilot.setRotateSpeed(45);
	
		pilot.rotate(-60);
		
		pilot.forward();
		Delay.msDelay(2500);
		
		pilot.rotate(100);	
		
		/* 
		while (isBlocked == true) { // looppi testaa onko este vielä edessä
				
			if (kaiku.getDistance() < 40) {
				
				pilot.rotateRight();
				
			}
			
			if (kaiku.getDistance() > 40) {
				
				isBlocked = false;

			}
		}
		*/
		
		while( Motor.B.isMoving() && !lannista ){
			Thread.yield();
		}
	}
}
