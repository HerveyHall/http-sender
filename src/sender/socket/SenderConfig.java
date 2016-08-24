package sender.socket;

import java.io.IOException;
import java.net.*;

public class SenderConfig {
	private Socket socket;
	private String host;
	private int port;
	private String localHost;
	private int localPort;
	private static PacketSender sender = null;

	public SenderConfig(Socket socket) {
		this.socket = socket;

	}

	public SenderConfig(String host, int port) throws UnknownHostException, IOException {
		this.host = host;
		this.port = port;
	}

	public SenderConfig(String host, int port, String localHost, int localPort)
			throws UnknownHostException, IOException {
		this(host, port);
		this.localHost = localHost;
		this.localPort = localPort;
	}

	public PacketSender getNewSender() throws Exception {
		if (socket == null)
			if (localHost != null)
				socket = new Socket(host, port, InetAddress.getByName(localHost), localPort);
			else
				socket = new Socket(host, port);
		if (sender == null)
			sender = new PacketSender(socket);
		else
			sender.setSocket(socket);
		return sender;
	}
}
