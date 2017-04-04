package kaytos;

import java.io.DataInputStream;
import java.io.DataOutputStream;

import lejos.nxt.comm.USB;
import lejos.nxt.comm.USBConnection;
import lejos.nxt.Button;
import lejos.nxt.LCD;

public class Connection {
	
	public USBConnection usbc;
	public DataOutputStream out;
	public DataInputStream in;
	public Data data;

	public Connection() {
		LCD.clear();
		LCD.drawString("not connected", 0, 0);
		
		usbc = USB.waitForConnection();
		LCD.clear();
		LCD.drawString("success", 0, 0);
		
		in = usbc.openDataInputStream();
		out = usbc.openDataOutputStream();
		
		data = new Data();
		
		LCD.drawInt(data.lData, 0, 0);
		
		Button.waitForAnyPress();
	}
	
}
