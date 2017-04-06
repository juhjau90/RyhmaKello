package connectionPC;

import java.io.DataOutputStream;
import java.io.IOException;

import lejos.pc.comm.NXTConnector;

public class Connection { 
	
	private NXTConnector conn = new NXTConnector();
	private DataOutputStream out;
	private boolean connected;
	
	public boolean getConnected() {
		return connected;
	}
	
	public void Connect() { 
		connected = conn.connectTo("usb://");
		if (!connected) {
			
			System.err.println("failed");
		} else {
			
			out = new DataOutputStream(conn.getOutputStream());
		}
		
	}

	public void sendPC_Data(int i) { //Metodi joka hoitelee PC:llä syötettyjen arvojen viennin robottiin 
		try {
			
			if (i > 9 && i < 16) {
				out.writeInt(i);
			}
			
			out.flush();
			out.close();
			} 
		
		catch (IOException ex) {
			
		}
	}
}
