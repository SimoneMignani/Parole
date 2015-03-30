/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

/**
 *
 * @author Migno
 */
public class ContaParole {
    
    int parole;
    int pd;                    //parole diverse
    
    String[] a;
    HashSet h; 
    
    public ContaParole() {
        parole = 0;
        pd = 0;
        h = new HashSet();
    }
    
    
    public void readFromFile() {
        try {
            FileInputStream f = new FileInputStream("data/miseriaenobilta.txt");
            InputStreamReader in = new InputStreamReader(f);
            BufferedReader b = new BufferedReader(in);
            while (b.ready()) {
                String s = b.readLine();
                a = s.split(" |,|\\.|;|:|'|-|!|\\?");
                for (int i = 0; i < a.length; i++) {
                    if (h.contains(a[i])) {
                        pd++;
                    }
                    h.add(a[i]);
                    parole++;
                }
            }
            System.out.println("Numero totale delle parole: " + parole);
            System.out.println("Numero delle parole diverse: " + pd); 
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    
    
    
}
