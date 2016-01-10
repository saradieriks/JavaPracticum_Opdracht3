package main;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import controller.WinkelController;
//import controller.InstellingController.InstellingButtonListener;
import ui.IOPanel;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Main {

	
	
	/* ioKeuze is een keuze voor de gebruiker om te kiezen welke io hij gaat gebruiken.
	 * 0 = nog geen io gekozen, de gebruiker krijgt een pop-up om de db te kiezen.
	 * 1 = txt file
	 * 2 = DB
	 * 3 = Excel file
	 * */
	
	
	public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
        	IOPanel ioPanel;
        	
        	private Integer ioKeuze = 0;
        	
        	
            @Override
            public void run() {

	        		try  (InputStream in = new FileInputStream("settings.properties")){
	        			
	        			Properties prop = new Properties();
	        			prop.load(in);
	        			
	        			ioKeuze = Integer.parseInt(prop.getProperty("IOKeuze"));
	        			
	
	        		} catch (IOException e) {
	        			JOptionPane.showMessageDialog(null, "de instellingen voor het opslagmedium zijn niet gevonden. Gelieve nieuwe instellingen in te geven.");
	        		}
            	
            	
        		if (ioKeuze != 0){
        			
        			WinkelController frame = new WinkelController();
        		}
        		else {
        			
        			ioSelectie();
        			
        		}
        		
                
            }
            
            private void ioSelectie(){
            	
            	ioPanel = new IOPanel();
        		ioPanel.setjbTxtListener(new jbTxtListener());
        		ioPanel.setjbDbListener(new jbDbListener());
            	ioPanel.setjbExcelListener(new jbExcelListener());
            	ioPanel.setVisible(true);
            	ioPanel.setSize(400, 100);
            	
            }	
            
            
            class jbTxtListener implements ActionListener{
	       		 public void actionPerformed(ActionEvent e) {
	       			try (OutputStream out = new FileOutputStream("settings.properties")){
						
						Properties properties = new Properties();
						properties.setProperty("IOKeuze", "1");
						
						properties.store(out, "IOproperties");

					} catch (IOException e2) {
						e2.printStackTrace();
					}
	       			run();
	       			ioPanel.setVisible(false);
	       		 }
       		}
            class jbDbListener implements ActionListener{
          		 public void actionPerformed(ActionEvent e) {
          			 try (OutputStream out = new FileOutputStream("settings.properties")){
						
						Properties properties = new Properties();
						properties.setProperty("IOKeuze", "2");
						
						properties.store(out, "IOproperties");

					} catch (IOException e2) {
						e2.printStackTrace();
					}
          			run();
	       			ioPanel.setVisible(false);
          		 }
          	}
            class jbExcelListener implements ActionListener{
          		 public void actionPerformed(ActionEvent e) {
          			 try (OutputStream out = new FileOutputStream("settings.properties")){
						
						Properties properties = new Properties();
						properties.setProperty("IOKeuze", "3");
						
						properties.store(out, "IOproperties");

					} catch (IOException e2) {
						e2.printStackTrace();
					}
          			run();
	       			ioPanel.setVisible(false);
          		 }
          	}
            
            
        });
    }
	
}
