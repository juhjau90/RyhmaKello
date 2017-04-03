package kaytos;

import lejos.nxt.*;
import lejos.robotics.subsumption.*;
import lejos.nxt.LightSensor;
import lejos.robotics.navigation.DifferentialPilot;

public class HavaitseViiva implements Behavior {

	private LightSensor light;
	private int black = 38;
	private int white = 54;
	private boolean lannista = false;
	private DifferentialPilot pilot;
	
	public HavaitseViiva(SensorPort port, DifferentialPilot pilot){
		light = new LightSensor(port);
		light.setFloodlight(true);
		
		this.pilot = pilot;
		
	}
	
	public boolean takeControl() {

		//keskellä 51
		//musta 39
		//valkonen 65
		
		return (light.getLightValue() < black) || (light.getLightValue() > white);		
	}
	
	public void suppress() {
		lannista = true;
	}
	
	public void action() {
		
		lannista = false;
		
		pilot.setRotateSpeed(45);
		
		// LCD.drawInt(light.getLightValue(), 0, 0);
		
		if (light.getLightValue() < black) {
			
			pilot.rotateRight();
			
		} 
		
		if (light.getLightValue() > white) {
			
			pilot.rotateLeft();		
			
		}
		
	}
	
	public boolean Musta() {
		if(light.getLightValue() < black){
			return true;
		}
		return false;
	}

}