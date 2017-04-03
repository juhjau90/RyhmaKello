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
	private boolean Seina;
	
	public HuomaaSeina(SensorPort port, DifferentialPilot pilot){
		kaiku = new UltrasonicSensor(port);
		this.pilot = pilot;
	}
	
	public boolean takeControl() {
		return kaiku.getDistance() < 22;
	}
	
	public void suppress() {
		lannista = true;
	}
	
	public void action() {
		
		if(Seina){
			pilot.stop();
			Button.waitForAnyPress();
		}
		
		if(!Seina){
			lannista = false;
			
			// boolean isBlocked = true;
	
			// kun este -> käänny
			// lue uudestaan onko estettä
			// jos este -> käänny
			// jos ei -> eteen
			
			pilot.setRotateSpeed(90);
		
			pilot.rotate(-55);
			
			pilot.forward();
			Delay.msDelay(2500);
			
			pilot.rotate(95);
			
			HavaitseViiva mustaArvo = new HavaitseViiva(SensorPort.S4, pilot);
			Seina = true;
			
			while(!mustaArvo.Musta()){
				pilot.forward();
			}
			
			while( Motor.B.isMoving() && !lannista ){
				Thread.yield();
			}
		}
		
	}
}
