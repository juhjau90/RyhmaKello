package kaytos;

import lejos.nxt.Button;
import lejos.nxt.LCD;
import lejos.nxt.Motor;
import lejos.nxt.SensorPort;
import lejos.robotics.subsumption.Arbitrator;
import lejos.robotics.subsumption.Behavior;
import lejos.robotics.navigation.DifferentialPilot;
import lejos.util.Delay;
import lejos.util.Stopwatch;

public class PaaLuokka {
	
	public static void main (String[] args) {
		
		// luodaan yhteys laitteeseen
		Connection conn = new Connection();
		
		// alustetaan pilotti
		DifferentialPilot pilot = new DifferentialPilot(5.6f,11f,Motor.A, Motor.B, false);
		
		// travelspeedi on tietokoneelta saatu intti
		pilot.setTravelSpeed(conn.getNopeus());
		pilot.setRotateSpeed(45);
		
		// luodaan sekuntikello
		Stopwatch sw = new Stopwatch();
		
		
		Behavior osa1 = new AjaEteenpain(pilot);
		Behavior osa2 = new HuomaaSeina(SensorPort.S1, pilot, sw);
		Behavior osa3 = new HavaitseViiva(SensorPort.S4, pilot);
		
		Behavior [] taulu = {osa1, osa2, osa3};
		
		Arbitrator arby = new Arbitrator(taulu); //Arbitrator seulaa olioita l‰pi
		
		Button.waitForAnyPress();
		
		Delay.msDelay(5000); // 5 sec viive
		
		sw.reset();
		
		arby.start(); //Arbitrator olio ja sen toiminta k‰ynnistet‰‰n
	}
}