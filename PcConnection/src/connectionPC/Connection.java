package connectionPC;

import java.io.DataOutputStream;
import java.io.IOException;

import lejos.pc.comm.NXTConnector;

public class Connection {
	
	private NXTConnector conn = new NXTConnector();
	private DataOutputStream out;
	
	public void Connect() {
		boolean connected = conn.connectTo("usb://");
		if (!connected) {
			System.err.println("failed");
			System.exit(1);
		}
		
		out = new DataOutputStream(conn.getOutputStream());
	}

	public void sendPC_Data(int i) {
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
