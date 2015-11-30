package controller;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import domain.Item;
import domain.Reservatie;

public class WinkelController extends JFrame {

	private static Map <String,List<Item>> Items = new HashMap<>();
	private static Map <String,List<Reservatie>> Reservaties = new HashMap<>();
	private static final long serialVersionUID = 1L;
    private JPanel cardPanel, jpKlant, jpUitlening, jpTerugbrengen, jpItem, buttonPanel, exitPanel, opvragenPanel;
    private JLabel jlKlantVoornaam, jlKlantNaam, jlKlantStraat, jlKlantNummer, jlKlantBox, jlKlantPostcode, jlKlantGemeente, jlKlantLand, jlKlantEmail,
    	jlUitleningNaam, jlUitleningVoornaam, jlUitleningTitel1, jlUitleningTitel2, jlUitleningTitel3, jlUitleningTitel4, jlUitleningTitel5, 
    	jlUitleningType1, jlUitleningType2, jlUitleningType3, jlUitleningType4, jlUitleningType5, jlUitleningDag, jlUitleningMaand, jlUitleningJaar,
    	jlUitleningPrijs, jlUitleningDagen, jlUitleningBetaald, jlItemTitel, jlItemType, jlTerugbrengenBoete;
    private JTextField txtItemTitel, txtKlantVoornaam, txtKlantNaam, txtKlantStraat, txtKlantNummer, txtKlantBox, txtKlantPostcode, txtKlantGemeente,
    	txtKlantLand, txtKlantEmail,txtUitleningNaam, txtUitleningVoornaam, txtUitleningTitel1, txtUitleningTitel2, txtUitleningTitel3,
    	txtUitleningTitel4, txtUitleningTitel5, txtUitleningPrijs, txtUitleningDagen, txtTerugbrengenBoete;
    private JButton btnKlant, btnUitlening, btnTerugbrengen, btnItem, btnExit, btnTypeAdd, btnKlantAdd, btnUitleningAdd, btnTerugbrengenAdd;
    private CardLayout cardLayout = new CardLayout();
    private Character[] type = { 'M', 'G', 'C' };
    private Integer[] dag = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31 };
    private String[] maand = { "januari", "februari", "maart", "april", "mei", "juni",
    		"juli", "augustus", "september", "oktober", "november", "december" };
    private Integer[] jaar = { 2015, 2016, 2017, 2018, 2019, 2020, 2021, 2022, 2023, 2024, 2025, 2026, 2027, 2028, 2029, 2030 };
    private JComboBox cbType, cbDag, cbMaand, cbJaar;
    private JCheckBox cbBetaald;

    public WinkelController() {
        setTitle("Winkel");
        setSize(700, 450);
        cardPanel = new JPanel();
        buttonPanel = new JPanel();
        exitPanel = new JPanel();
        cardPanel.setLayout(cardLayout);
        jpKlant = new JPanel(); 
        jpKlant.setLayout(null);
        jpUitlening = new JPanel();
        jpUitlening.setLayout(null);;
        jpTerugbrengen = new JPanel();
        jpTerugbrengen.setLayout(null);
        jpItem = new JPanel();
        jpItem.setLayout(null);
        jlKlantVoornaam = new JLabel("Voornaam: "); jlKlantVoornaam.setBounds(10, 10, 100, 20); jpKlant.add(jlKlantVoornaam); 
        txtKlantVoornaam = new JTextField(); txtKlantVoornaam.setBounds(110, 10, 200, 20); jpKlant.add(txtKlantVoornaam);
        jlKlantNaam = new JLabel("Naam: "); jlKlantNaam.setBounds(10, 40, 100, 20); jpKlant.add(jlKlantNaam);
        txtKlantNaam = new JTextField(); txtKlantNaam.setBounds(110, 40, 200, 20); jpKlant.add(txtKlantNaam);
        jlKlantStraat = new JLabel("Straat: "); jlKlantStraat.setBounds(10, 70, 100, 20); jpKlant.add(jlKlantStraat); 
        txtKlantStraat = new JTextField(); txtKlantStraat.setBounds(110, 70, 200, 20); jpKlant.add(txtKlantStraat);
        jlKlantNummer = new JLabel("Nummer: "); jlKlantNummer.setBounds(320, 70, 80, 20); jpKlant.add(jlKlantNummer);
        txtKlantNummer = new JTextField(); txtKlantNummer.setBounds(410, 70, 50, 20); jpKlant.add(txtKlantNummer);
        jlKlantBox = new JLabel("Box:"); jlKlantBox.setBounds(470, 70, 50, 20); jpKlant.add(jlKlantBox);
        txtKlantBox = new JTextField(); txtKlantBox.setBounds(530, 70, 50, 20); jpKlant.add(txtKlantBox);
        jlKlantPostcode = new JLabel("Postcode: "); jlKlantPostcode.setBounds(10, 100, 100, 20); jpKlant.add(jlKlantPostcode); 
        txtKlantPostcode = new JTextField(); txtKlantPostcode.setBounds(110, 100, 50, 20);  jpKlant.add(txtKlantPostcode); 
        jlKlantGemeente = new JLabel("Gemeente: "); jlKlantGemeente.setBounds(170, 100, 100, 20); jpKlant.add(jlKlantGemeente);
        txtKlantGemeente = new JTextField(); txtKlantGemeente.setBounds(280, 100, 200, 20); jpKlant.add(txtKlantGemeente);
        jlKlantLand = new JLabel("Land: "); jlKlantLand.setBounds(10, 130, 100, 20); jpKlant.add(jlKlantLand);
        txtKlantLand = new JTextField(); txtKlantLand.setBounds(110, 130, 200, 20); jpKlant.add(txtKlantLand);
        jlKlantEmail = new JLabel("Email: "); jlKlantEmail.setBounds(10, 160, 100, 20); jpKlant.add(jlKlantEmail);
        txtKlantEmail = new JTextField(); txtKlantEmail.setBounds(110, 160, 200, 20); jpKlant.add(txtKlantEmail);
        btnKlantAdd = new JButton("Voeg klant toe"); btnKlantAdd.setBounds(60, 190, 150, 20);
        // Nog actionListener toevoegen
        jpKlant.add(btnKlantAdd);
        jlUitleningVoornaam = new JLabel("Voornaam klant: "); jlUitleningVoornaam.setBounds(10, 10, 100, 20); jpUitlening.add(jlUitleningVoornaam);
        txtUitleningVoornaam = new JTextField(); txtUitleningVoornaam.setBounds(110, 10, 200, 20); jpUitlening.add(txtUitleningVoornaam);
        jlUitleningNaam = new JLabel("Naam klant: "); jlUitleningNaam.setBounds(10, 40, 100, 20); jpUitlening.add(jlUitleningNaam);
        txtUitleningNaam = new JTextField(); txtUitleningNaam.setBounds(110, 40, 200, 20); jpUitlening.add(txtUitleningNaam);
        jlUitleningDag = new JLabel("Dag uitlening: "); jlUitleningDag.setBounds(10, 70, 100, 20); jpUitlening.add(jlUitleningDag);
        cbDag = new JComboBox(dag); cbDag.setBounds(110, 70, 50, 20); jpUitlening.add(cbDag);
        jlUitleningMaand = new JLabel("Maand uitlening: "); jlUitleningMaand.setBounds(170, 70, 100, 20); jpUitlening.add(jlUitleningMaand);
        cbMaand = new JComboBox(maand); cbMaand.setBounds(280, 70, 100, 20); jpUitlening.add(cbMaand);
        jlUitleningJaar = new JLabel("Jaar uitlening: "); jlUitleningJaar.setBounds(390,  70,  100,  20); jpUitlening.add(jlUitleningJaar);
        cbJaar = new JComboBox(jaar); cbJaar.setBounds(500, 70, 100, 20); jpUitlening.add(cbJaar);
        jlUitleningDagen = new JLabel("Aantal dagen: "); jlUitleningDagen.setBounds(10, 100, 100, 20); jpUitlening.add(jlUitleningDagen);
        txtUitleningDagen = new JTextField(); txtUitleningDagen.setBounds(110, 100, 200, 20); jpUitlening.add(txtUitleningDagen);
        jlUitleningType1 = new JLabel("Type item: "); jlUitleningType1.setBounds(10, 130, 100, 20); jpUitlening.add(jlUitleningType1);
        cbType = new JComboBox(type); cbType.setBounds(110, 130, 50, 20); jpUitlening.add(cbType);
        jlUitleningTitel1 = new JLabel("Titel item: "); jlUitleningTitel1.setBounds(170, 130, 100, 20); jpUitlening.add(jlUitleningTitel1);
        txtUitleningTitel1 = new JTextField(); txtUitleningTitel1.setBounds(280, 130, 200, 20); jpUitlening.add(txtUitleningTitel1);
        jlUitleningType2 = new JLabel("Type item: "); jlUitleningType2.setBounds(10, 160, 100, 20); jpUitlening.add(jlUitleningType2);
        cbType = new JComboBox(type); cbType.setBounds(110, 160, 50, 20); jpUitlening.add(cbType);
        jlUitleningTitel2 = new JLabel("Titel item: "); jlUitleningTitel2.setBounds(170, 160, 100, 20); jpUitlening.add(jlUitleningTitel2);
        txtUitleningTitel2 = new JTextField(); txtUitleningTitel2.setBounds(280, 160, 200, 20); jpUitlening.add(txtUitleningTitel2);
        jlUitleningType3 = new JLabel("Type item: "); jlUitleningType3.setBounds(10, 190, 100, 20); jpUitlening.add(jlUitleningType3);
        cbType = new JComboBox(type); cbType.setBounds(110, 190, 50, 20); jpUitlening.add(cbType);
        jlUitleningTitel3 = new JLabel("Titel item: "); jlUitleningTitel3.setBounds(170, 190, 100, 20); jpUitlening.add(jlUitleningTitel3);
        txtUitleningTitel3 = new JTextField(); txtUitleningTitel3.setBounds(280, 190, 200, 20); jpUitlening.add(txtUitleningTitel3);
        jlUitleningType4 = new JLabel("Type item: "); jlUitleningType4.setBounds(10, 220, 100, 20); jpUitlening.add(jlUitleningType4);
        cbType = new JComboBox(type); cbType.setBounds(110, 220, 50, 20); jpUitlening.add(cbType);
        jlUitleningTitel4 = new JLabel("Titel item: "); jlUitleningTitel4.setBounds(170, 220, 100, 20); jpUitlening.add(jlUitleningTitel4);
        txtUitleningTitel4 = new JTextField(); txtUitleningTitel4.setBounds(280, 220, 200, 20); jpUitlening.add(txtUitleningTitel4);
        jlUitleningType5 = new JLabel("Type item: "); jlUitleningType5.setBounds(10, 250, 100, 20); jpUitlening.add(jlUitleningType5);
        cbType = new JComboBox(type); cbType.setBounds(110, 250, 50, 20); jpUitlening.add(cbType);
        jlUitleningTitel5 = new JLabel("Titel item: "); jlUitleningTitel5.setBounds(170, 250, 100, 20); jpUitlening.add(jlUitleningTitel5);
        txtUitleningTitel5 = new JTextField(); txtUitleningTitel5.setBounds(280, 250, 200, 20); jpUitlening.add(txtUitleningTitel5);
        jlUitleningPrijs = new JLabel("Prijs uitleningen: "); jlUitleningPrijs.setBounds(10,280,100,20); jpUitlening.add(jlUitleningPrijs);
        txtUitleningPrijs = new JTextField(); txtUitleningPrijs.setBounds(110, 280, 200, 20); jpUitlening.add(txtUitleningPrijs);
        jlUitleningBetaald = new JLabel("Betaald: "); jlUitleningBetaald.setBounds(320, 280, 100, 20); jpUitlening.add(jlUitleningBetaald);
        cbBetaald = new JCheckBox(); cbBetaald.setBounds(430, 280, 20, 20); jpUitlening.add(cbBetaald);
        btnUitleningAdd = new JButton("Voeg uitlening toe"); btnUitleningAdd.setBounds(60, 310, 150, 20);
        // Nog ActionListener toevoegen
        jpUitlening.add(btnUitleningAdd);        
        jlUitleningType1 = new JLabel("Type item: "); jlUitleningType1.setBounds(10, 10, 100, 20); jpTerugbrengen.add(jlUitleningType1);
        cbType = new JComboBox(type); cbType.setBounds(110, 10, 50, 20); jpTerugbrengen.add(cbType);
        jlUitleningTitel1 = new JLabel("Titel item: "); jlUitleningTitel1.setBounds(170, 10, 100, 20); jpTerugbrengen.add(jlUitleningTitel1);
        txtUitleningTitel1 = new JTextField(); txtUitleningTitel1.setBounds(280, 10, 200, 20); jpTerugbrengen.add(txtUitleningTitel1);
        jlUitleningType2 = new JLabel("Type item: "); jlUitleningType2.setBounds(10, 40, 100, 20); jpTerugbrengen.add(jlUitleningType2);
        cbType = new JComboBox(type); cbType.setBounds(110, 40, 50, 20); jpTerugbrengen.add(cbType);
        jlUitleningTitel2 = new JLabel("Titel item: "); jlUitleningTitel2.setBounds(170, 40, 100, 20); jpTerugbrengen.add(jlUitleningTitel2);
        txtUitleningTitel2 = new JTextField(); txtUitleningTitel2.setBounds(280, 40, 200, 20); jpTerugbrengen.add(txtUitleningTitel2);
        jlUitleningType3 = new JLabel("Type item: "); jlUitleningType3.setBounds(10, 70, 100, 20); jpTerugbrengen.add(jlUitleningType3);
        cbType = new JComboBox(type); cbType.setBounds(110, 70, 50, 20); jpTerugbrengen.add(cbType);
        jlUitleningTitel3 = new JLabel("Titel item: "); jlUitleningTitel3.setBounds(170, 70, 100, 20); jpTerugbrengen.add(jlUitleningTitel3);
        txtUitleningTitel3 = new JTextField(); txtUitleningTitel3.setBounds(280, 70, 200, 20); jpTerugbrengen.add(txtUitleningTitel3);
        jlUitleningType4 = new JLabel("Type item: "); jlUitleningType4.setBounds(10, 100, 100, 20); jpTerugbrengen.add(jlUitleningType4);
        cbType = new JComboBox(type); cbType.setBounds(110, 100, 50, 20); jpTerugbrengen.add(cbType);
        jlUitleningTitel4 = new JLabel("Titel item: "); jlUitleningTitel4.setBounds(170, 100, 100, 20); jpTerugbrengen.add(jlUitleningTitel4);
        txtUitleningTitel4 = new JTextField(); txtUitleningTitel4.setBounds(280, 100, 200, 20); jpTerugbrengen.add(txtUitleningTitel4);
        jlUitleningType5 = new JLabel("Type item: "); jlUitleningType5.setBounds(10, 130, 100, 20); jpTerugbrengen.add(jlUitleningType5);
        cbType = new JComboBox(type); cbType.setBounds(110, 130, 50, 20); jpTerugbrengen.add(cbType);
        jlUitleningTitel5 = new JLabel("Titel item: "); jlUitleningTitel5.setBounds(170, 130, 100, 20); jpTerugbrengen.add(jlUitleningTitel5);
        txtUitleningTitel5 = new JTextField(); txtUitleningTitel5.setBounds(280, 130, 200, 20); jpTerugbrengen.add(txtUitleningTitel5);
        jlUitleningPrijs = new JLabel("Prijs uitleningen: "); jlUitleningPrijs.setBounds(10, 160, 100, 20); jpTerugbrengen.add(jlUitleningPrijs);
        txtUitleningPrijs = new JTextField(); txtUitleningPrijs.setBounds(110, 160, 50, 20); jpTerugbrengen.add(txtUitleningPrijs);
        jlTerugbrengenBoete = new JLabel("Boete: "); jlTerugbrengenBoete.setBounds(170, 160, 100, 20); jpTerugbrengen.add(jlTerugbrengenBoete);
        txtTerugbrengenBoete = new JTextField(); txtTerugbrengenBoete.setBounds(280, 160, 50, 20); jpTerugbrengen.add(txtTerugbrengenBoete);
        jlUitleningBetaald = new JLabel("Betaald: "); jlUitleningBetaald.setBounds(340, 160, 100, 20); jpTerugbrengen.add(jlUitleningBetaald);
        cbBetaald = new JCheckBox(); cbBetaald.setBounds(450, 160, 20, 20); jpTerugbrengen.add(cbBetaald);
        btnTerugbrengenAdd = new JButton("Voeg terugbrenging toe"); btnTerugbrengenAdd.setBounds(60, 190, 200, 20);
        // Nog ActionListener toevoegen
        jpTerugbrengen.add(btnTerugbrengenAdd);
        jlItemTitel = new JLabel("Titel item:"); jlItemTitel.setBounds(10, 10, 100, 20); jpItem.add(jlItemTitel);
        txtItemTitel = new JTextField(); txtItemTitel.setBounds(110, 10, 200, 20); jpItem.add(txtItemTitel);
        jlItemType = new JLabel("Type item: "); jlItemType.setBounds(10, 40, 100, 20); jpItem.add(jlItemType);
        cbType = new JComboBox(type); cbType.setBounds(110, 40, 50, 20); jpItem.add(cbType);
        btnTypeAdd = new JButton("Voeg item toe"); btnTypeAdd.setBounds(60, 70, 150, 20);


        
        jpItem.add(btnTypeAdd);
        cardPanel.add(jpKlant, "1");
        cardPanel.add(jpUitlening, "2");
        cardPanel.add(jpTerugbrengen, "3");
        cardPanel.add(jpItem,  "4");
        btnKlant = new JButton("Nieuwe Klant");
        btnKlant.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel, "1");
            }
        });
        btnUitlening = new JButton("Nieuwe uitlening");
        btnUitlening.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel, "2");
            }
        });
        btnTerugbrengen = new JButton("Terugbrengen uitlening");
        btnTerugbrengen.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel, "3");
            }
        });
        btnItem = new JButton("Nieuw item");
        btnItem.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel, "4");
            }
        });
        btnExit = new JButton("Exit");
        btnExit.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		System.exit(0);
        	}
        });
        buttonPanel.add(btnKlant);
        buttonPanel.add(btnUitlening);
        buttonPanel.add(btnTerugbrengen);
        buttonPanel.add(btnItem);
        exitPanel.add(btnExit);
        add(cardPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.NORTH);
        add(exitPanel, BorderLayout.SOUTH);
    }
	
	// Deze methode moet nog verder afgewerkt worden
	public Boolean maakNieuweReservatie(String id, int klantID, int aantalDagen) {
		/*
		 * Deze maakt een nieuwe reservatie aan en zal indien positief dan ook
		 * een refresh doen van de reservaties via de ioReader
		 */
		return true;
	}
	
	// Deze methode moet nog verder afgewerkt worden
	public Double brengTerug(List<Item> lijst) {
		/*
		 * Deze functie bepaalt het totaal te betalen bedrag en de boeten. 
		 * Concreet past deze functie de objecten aan en vult overal het bedrag 
		 * en de boete in.
		 */
		return 0D; 
	}
	
	// Deze methode moet nog afgewerkt worden
	public String geefAlleItems() {
		/*
		 * Dit geeft een geformateerde lijst voor consoledisplay terug.
		 * opgave punt 4
		 */
		return "";
	}
	
	// Deze methode moet nog afgewerkt worden
	public String zoekItems(String woord, String type) {
		/*
		 * Geeft geformateerde lijst van alle items met dit woord in de titel 
		 * van dat type. Het type moet meegegeven worden als "movie" of "game".
		 */
		return "";
	}
}
