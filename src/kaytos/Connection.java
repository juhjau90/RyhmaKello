package kaytos;

import java.io.DataInputStream;
// import java.io.DataOutputStream;
import lejos.nxt.comm.USB;
import lejos.nxt.comm.USBConnection;
import lejos.nxt.Button;
import lejos.nxt.LCD;

public class Connection {
	
	public USBConnection usbc;
	// public DataOutputStream out;
	public DataInputStream in;
	public Data data;
	private int nopeus;
	
	public Connection() {
		
		LCD.clear();
		LCD.drawString("not connected", 0, 0);
		
		usbc = USB.waitForConnection();
		
		LCD.clear();
		LCD.drawString("success", 0, 0);
		
		in = usbc.openDataInputStream();
		// out = usbc.openDataOutputStream();
		
		data = new Data();
		
		data.getPC_data(in);
		
		nopeus = data.lData;
		
		usbc.close();
		
		// Button.waitForAnyPress();
	}
	public int getNopeus(){
		return nopeus;
	}
	
}
