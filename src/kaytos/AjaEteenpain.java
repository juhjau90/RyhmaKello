package kaytos;

import lejos.robotics.subsumption.*;
import lejos.robotics.navigation.DifferentialPilot;

public class AjaEteenpain implements Behavior { //Luokka joka hoitaa robotin eteenpäin liikkumisen
	
	//Akselileveys 4.75" tai 121mm
	
	private boolean lannista = false;
	private DifferentialPilot pilot;
	
	public AjaEteenpain(DifferentialPilot pilot) {
	
		this.pilot = pilot;
	
	}
	
	public boolean takeControl() {
		return true;
	}
	
	public void suppress() {
		lannista = true;
	}
	
	public void action() {
		
		lannista = false;
		
		pilot.forward();
		
		while( !lannista ){
			Thread.yield();
		}
		
		pilot.stop();
	}
	
}
