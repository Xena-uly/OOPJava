package net.ukr.xena_reg;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

class ServerInfo implements Runnable {
	int port;
	Socket clientSoket;
	static int counter = 1;

	public ServerInfo(int port) {
		this.port = port;
	}

	public void goClientThread() {
		try (ServerSocket ss = new ServerSocket(port)) {

			while (true) {
				clientSoket = ss.accept();
				Thread thread = new Thread(new ClientThread(clientSoket));
				thread.start();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		StringBuilder sb = new StringBuilder();
		sb.append("Java version - ").append(System.getProperty("java.version"))
				.append("\r\nOS name - ").append(System.getProperty("os.name"))
				.append("\r\nOS architecture - ").append(System.getProperty("os.arch"))
				.append("\r\nOS version - ").append(System.getProperty("os.version"))
				.append("\r\nUser's name - ").append(System.getProperty("user.name"))
				.append("\r\nUser's home directory - ").append(System.getProperty("user.home"))
				.append("\r\nUser's current working directory - ").append(System.getProperty("user.dir"))
				.append("\r\nNumber of your request - ").append(counter++);
		try {
			clientSoket.getOutputStream().write(sb.toString().getBytes());
			clientSoket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void main(String[] args) throws IOException {
		ServerInfo server = new ServerInfo(55000);
		server.goClientThread();
	}
}