package kaytos;

import lejos.nxt.Button;
import lejos.nxt.LCD;
import lejos.nxt.Motor;
import lejos.nxt.SensorPort;
import lejos.robotics.subsumption.Arbitrator;
import lejos.robotics.subsumption.Behavior;
import lejos.robotics.navigation.DifferentialPilot;

public class PaaLuokka {
	
	public static void main (String[] args) {
		
		DifferentialPilot pilot = new DifferentialPilot(5.6f,11f,Motor.A, Motor.B, false);
		pilot.setTravelSpeed(12);
		//pilot.setAcceleration(180);
		pilot.setRotateSpeed(45);

		LCD.drawString("    |   -----", 0, 0);
		LCD.drawString("    |   |", 0, 1);
		LCD.drawString("    |   |", 0, 2);
		LCD.drawString("    |---+---|", 0, 3);
		LCD.drawString("        |   |", 0, 4);
		LCD.drawString("        |   |", 0, 5);
		LCD.drawString("    -----   |", 0, 6);
		
		Behavior osa1 = new AjaEteenpain(pilot);
		Behavior osa2 = new HuomaaSeina(SensorPort.S1, pilot);
		Behavior osa3 = new HavaitseViiva(SensorPort.S4, pilot);
		
		Behavior [] taulu = {osa1, osa2, osa3};
		
		Arbitrator arby = new Arbitrator(taulu);
		
		Button.waitForAnyPress();
		
		arby.start();
	}
}