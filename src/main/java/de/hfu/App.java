package de.hfu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * App Class - Has my Main Code in it.
 * @author Zmejaa
 *
 */
public class App
{
	/**
	 * Main Method
	 * @param args
	 */
    public static void main( String[] args )
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String zeichenkette = null;
		try {
			zeichenkette = reader.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return;
		}
        
        for(int i = 0; i < zeichenkette.length(); i++) {
            System.out.print((char)(zeichenkette.charAt(i)-32));
        }
    }
}
