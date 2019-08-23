package net.ukr.xena_reg;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class Client {

	public static void main(String[] args) {
		try (Socket clientSocket = new Socket("localhost", 55000);
				InputStreamReader isr = new InputStreamReader(clientSocket.getInputStream());
				BufferedReader bf = new BufferedReader(isr);) {
			// System.out.println(clientSocket.getPort());
			int r = 0;
			char[] buf = new char[1024];

			for (; (r = bf.read(buf)) > 0;) {
				System.out.println(new String(buf, 0, r));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
