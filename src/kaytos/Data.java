package kaytos;

import java.io.DataInputStream;
import java.io.IOException;

public class Data {

	int lData;
	
	public void getPC_data(DataInputStream dis) {
		
		String tmp = "";
		try {
			tmp = dis.readUTF();
		} catch (IOException ex) {
			//
		}
		
		lData = Integer.parseInt(tmp);
	}
	
}
