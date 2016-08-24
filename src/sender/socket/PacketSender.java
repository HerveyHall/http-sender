package sender.socket;

import java.net.*;
import java.io.*;
import sender.form.*;

public class PacketSender {
	private Socket socket;
	private String response = new String();
	private boolean status = false;

	public PacketSender(Socket socket) throws Exception {
		this.socket = socket;
		setSocket(socket);
	}

	public boolean send(HttpRequestPacket packet) {
		try {
			BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			writer.write(packet.toString());
			writer.flush();
			return true;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}

	public String getResponse() {
		return response;
	}

	public boolean getStatus() {
		return status;
	}

	public void setSocket(Socket socket) throws Exception {
		Thread thread = new Thread(new Runnable() {
			@Override
			public void run() {
				String line = null;
				try {
					BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream(), "utf-8"));
					while ((line = reader.readLine()) != null)
						response += line + "\r\n";
				} catch (IOException e) {
				}
				status = true;
			}
		});
		thread.setDaemon(true);
		thread.start();
	}
}
