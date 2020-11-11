package com.nbsteam11.main;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

/*******
 * <p>
 * Title: Server Class.
 * </p>
 * 
 * <p>
 * Description: This is the connectivity class which is based on Socket
 * Programming for Client.
 * </p>
 *
 * @author Sukrut Patil, Vaibhav and Dolly
 * 
 * @version 1.00 2019-11-05
 * 
 */

public class Client {

	public static void main(String args[]) throws Exception {
		Socket sk = new Socket("192.168.43.28", 5000);
		BufferedReader sin = new BufferedReader(new InputStreamReader(sk.getInputStream()));
		PrintStream sout = new PrintStream(sk.getOutputStream());
		BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
		String s;
		while (true) {
			System.out.print("Client : ");
			s = stdin.readLine();
			sout.println(s);
			if (s.equalsIgnoreCase("BYE")) {
				System.out.println("Connection ended by client");
				break;
			}
			s = sin.readLine();
			System.out.print("Server : " + s + "\n");

		}
		sk.close();
		sin.close();
		sout.close();
		stdin.close();
	}

}
