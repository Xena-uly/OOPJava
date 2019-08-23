package net.ukr.xena_reg;

import java.io.IOException;
import java.net.Socket;

public class ClientThread implements Runnable {
	
	Socket clSocket;
	static int counter = 1;

	public ClientThread(Socket clSocket) {
		this.clSocket = clSocket;
	}

	@Override
	public void run() {
		try {

			StringBuilder sb = new StringBuilder();
			sb.append("Java version - ")
					.append(System.getProperty("java.version"))
					.append("\r\nOS name - ")
					.append(System.getProperty("os.name"))
					.append("\r\nOS architecture - ")
					.append(System.getProperty("os.arch"))
					.append("\r\nOS version - ")
					.append(System.getProperty("os.version"))
					.append("\r\nUser's name - ")
					.append(System.getProperty("user.name"))
					.append("\r\nUser's home directory - ")
					.append(System.getProperty("user.home"))
					.append("\r\nUser's current working directory - ")
					.append(System.getProperty("user.dir"))
					.append("\r\nNumber of your request - ")
					.append(counter++);

			clSocket.getOutputStream().write(sb.toString().getBytes());
			clSocket.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}