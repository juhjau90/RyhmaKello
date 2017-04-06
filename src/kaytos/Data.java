package kaytos;

import java.io.DataInputStream;
import java.io.IOException;
import lejos.util.Delay;

public class Data { //Luokka jolla määritettän PC:ltä syötettävän datan tyyppi ja viive

	int lData;
	
	public void getPC_data(DataInputStream dis) {
		
		int tmp = 0;
		
		try {
			while (tmp == 0) {
			tmp = dis.readInt();
			Delay.msDelay(2000);
			}
			
		} catch (IOException ex) {
			//
		}
		
		lData = tmp;
	}
	
}
