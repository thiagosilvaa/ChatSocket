package br.com.Chat;
import java.io.IOException;
import java.io.InputStream;
import java.net.*;
import java.util.Scanner;
import java.util.logging.Logger;

public class Servidor {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Cria referencia para objeto ServerSocket
		ServerSocket servidor = null;
		try {
			// Tenta criar uma instancia e retorna sua referencia
			servidor = new ServerSocket(12345);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			// ocorreu uma excecao!
			// ...
			e.printStackTrace();
		}
		System.out.println("Porta 12345 aberta!");
		
		Socket cliente = null;
		try {
			cliente = servidor.accept();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Nova conexão com o cliente " +
		cliente.getInetAddress().getHostAddress());
		
		Scanner scanner = null;
		try {
			scanner = new Scanner(cliente.getInputStream());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		while (scanner.hasNextLine()) {
		System.out.println(scanner.nextLine());}
		
		scanner.close();
		try {
			cliente.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			servidor.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
