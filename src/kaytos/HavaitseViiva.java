package kaytos;

import lejos.nxt.*;
import lejos.robotics.subsumption.*;
import lejos.nxt.LightSensor;
import lejos.robotics.navigation.DifferentialPilot;

public class HavaitseViiva implements Behavior { //Luokka jolla hoidetaan viivanseuraaminen ja joka juoksee aina

	private LightSensor light;
	private int black = 41; //mustan v‰riarvo
	private int white = 57; //valkoisen v‰riarvo
	private DifferentialPilot pilot;
	
	public HavaitseViiva(SensorPort port, DifferentialPilot pilot){
		light = new LightSensor(port);
		light.setFloodlight(true); //valosensori aktivoidaan
		
		this.pilot = pilot;
		
	}
	
	public boolean takeControl() { //Luokka ottaa ohjakset kun valkoista tai mustaa v‰riarvoa huomataan

		return (light.getLightValue() < black) || (light.getLightValue() > white);		
	}
	
	public void suppress() {

	}
	
	public void action() {
		
		
		pilot.setRotateSpeed(45);
		
		
		if (light.getLightValue() < black) { //Mustaa huomatessa k‰‰nnyt‰‰n oikealle
			
			pilot.rotateRight();
			
		}
		
		if (light.getLightValue() > white) { //Valkoista havaittaessa k‰‰nnyt‰‰n vasemmalle
			
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