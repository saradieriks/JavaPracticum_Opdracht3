package ui;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import io.IOWriter;

public class KlantPanel extends JFrame {

	private static final long serialVersionUID = 1L;
    private JPanel jpKlantinfo, jpArtikels, jpfooter;
    private JLabel 	jlKlantlabel, jlKlanttext, 
    				jlItemlabel, jlItemtext, 
    				jlaantaldagenlabel, jlaantaldagentext,
    				jltotaalprijslabel,jltotaalprijstext;
    private CardLayout cardLayout = new CardLayout();
    private Character[] type = { 'M', 'G', 'C' };
    private Integer[] dag = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31 };
    private String[] maand = { "januari", "februari", "maart", "april", "mei", "juni",
    		"juli", "augustus", "september", "oktober", "november", "december" };
    private Integer[] jaar = { 2015, 2016, 2017, 2018, 2019, 2020, 2021, 2022, 2023, 2024, 2025, 2026, 2027, 2028, 2029, 2030 };
    private JCheckBox cbBetaald;
    
    public KlantPanel() {
	    setTitle("Uw bestelling");
	    setSize(700, 300); // grootte scherm
	    
	    
	    
	    btnExit = new JButton("Exit");
	    btnExit.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		System.exit(0);
	    	}
	    });
	    exitPanel.add(btnExit);
    }

	public void setjlKlantlabel(JLabel jlKlantlabel) {
		this.jlKlantlabel = jlKlantlabel;
	}
	
	/*
	 * Klantenpaneel met:
	 * [Panel jpKlantinfo]
	 * 	Klant : Voornaam Achternaam
	 * [Panel jpArtikels]
	 * 	Tabel met [Titel][Type][Aantaldagen]
	 * [Panel jpBetalingsinfo]
	 * 	Informatie over openstaand saldo
	 */
	

}
