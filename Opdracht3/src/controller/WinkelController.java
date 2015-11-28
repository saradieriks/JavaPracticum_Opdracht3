package controller;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import domain.Item;

public class WinkelController extends JFrame {

	/*
	 * 1. items: hashmap
	 * 2. reservaties: hashmap
	 */
	private static final long serialVersionUID = 1L;
    private JPanel cardPanel, jpKlant, jpUitlening, jpTerugbrengen, jpItem, buttonPanel;
    private JLabel jlKlantVoornaam, jlKlantNaam, jlKlantStraat, jlKlantNummer, jlKlantBox, jlKlantPostcode, jlKlantGemeente, jlKlantLand, jlKlantEmail,
    	jlUitlening, jlTerugbrengen, jlItemTitel, jlItemType;
    private JTextField txtItemTitel, txtKlantVoornaam, txtKlantNaam, txtKlantStraat, txtKlantNummer, txtKlantBox, txtKlantPostcode, txtKlantGemeente,
    	txtKlantLand, txtKlantEmail;
    private JButton btnKlant, btnUitlening, btnTerugbrengen, btnItem, btnExit, btnTypeAdd, btnKlantAdd;
    private CardLayout cardLayout = new CardLayout();
    private Character[] type = { 'M', 'G' };
    private JComboBox cbType;

    public WinkelController() {
        setTitle("Winkel");
        setSize(600, 600);
        cardPanel = new JPanel();
        buttonPanel = new JPanel();
        cardPanel.setLayout(cardLayout);
        jpKlant = new JPanel();
        jpKlant.setLayout(null);
        jpUitlening = new JPanel();
        jpUitlening.setLayout(null);;
        jpTerugbrengen = new JPanel();
        jpTerugbrengen.setLayout(null);
        jpItem = new JPanel();
        jpItem.setLayout(null);
        jlKlantVoornaam = new JLabel("Voornaam: ");
        jlKlantVoornaam.setBounds(10, 10, 100, 20);
        jpKlant.add(jlKlantVoornaam); 
        txtKlantVoornaam = new JTextField();
        txtKlantVoornaam.setBounds(110, 10, 200, 20);
        jpKlant.add(txtKlantVoornaam);
        jlKlantNaam = new JLabel("Naam: ");
        jlKlantNaam.setBounds(10, 40, 100, 20);
        jpKlant.add(jlKlantNaam);
        txtKlantNaam = new JTextField();
        txtKlantNaam.setBounds(110, 40, 200, 20);
        jpKlant.add(txtKlantNaam);
        jlKlantStraat = new JLabel("Straat: ");
        jlKlantStraat.setBounds(10, 70, 100, 20);
        jpKlant.add(jlKlantStraat); 
        txtKlantStraat = new JTextField();
        txtKlantStraat.setBounds(110, 70, 200, 20);
        jpKlant.add(txtKlantStraat);
        jlKlantNummer = new JLabel("Nummer: ");
        jlKlantNummer.setBounds(320, 70, 80, 20);
        jpKlant.add(jlKlantNummer);
        txtKlantNummer = new JTextField();
        txtKlantNummer.setBounds(410, 70, 50, 20);
        jpKlant.add(txtKlantNummer);
        jlKlantBox = new JLabel("Box:");
        jlKlantBox.setBounds(470, 70, 50, 20);
        jpKlant.add(jlKlantBox);
        txtKlantBox = new JTextField();
        txtKlantBox.setBounds(530, 70, 50, 20);
        jpKlant.add(txtKlantBox);
        jlKlantPostcode = new JLabel("Postcode: ");
        jlKlantPostcode.setBounds(10, 100, 100, 20);
        jpKlant.add(jlKlantPostcode);
        txtKlantPostcode = new JTextField();
        txtKlantPostcode.setBounds(110, 100, 50, 20);
        jpKlant.add(txtKlantPostcode);
        jlKlantGemeente = new JLabel();
        jlKlantGemeente.setBounds(170, 100, 100, 20);
        jpKlant.add(jlKlantGemeente);
        txtKlantGemeente = new JTextField();
        txtKlantGemeente.setBounds(280, 100, 200, 20);
        jpKlant.add(txtKlantGemeente);
        jlKlantLand = new JLabel("Land: ");
        jlKlantLand.setBounds(10, 130, 100, 20);
        jpKlant.add(jlKlantLand);
        txtKlantLand = new JTextField();
        txtKlantLand.setBounds(110, 130, 200, 20);
        jpKlant.add(txtKlantLand);
        jlKlantEmail = new JLabel("Email: ");
        jlKlantEmail.setBounds(10, 160, 100, 20);
        jpKlant.add(jlKlantEmail);
        txtKlantEmail = new JTextField();
        txtKlantEmail.setBounds(110, 160, 200, 20);
        jpKlant.add(txtKlantEmail);
        btnKlantAdd = new JButton("Voeg klant toe");
        btnKlantAdd.setBounds(60, 190, 150, 20);
        jpKlant.add(btnKlantAdd);
        jlUitlening = new JLabel("Nieuwe uitlening");
        jpUitlening.add(jlUitlening);
        jlTerugbrengen = new JLabel("Terugbrengen uitlening");
        jpTerugbrengen.add(jlTerugbrengen);
        jlItemTitel = new JLabel("Titel item:");
        jlItemTitel.setBounds(10, 10, 100, 20);
        jpItem.add(jlItemTitel);
        txtItemTitel = new JTextField();
        txtItemTitel.setBounds(110, 10, 200, 20);
        jpItem.add(txtItemTitel);
        jlItemType = new JLabel("Type item: ");
        jlItemType.setBounds(10, 40, 100, 20);
        jpItem.add(jlItemType);
        cbType = new JComboBox(type);
        cbType.setBounds(110, 40, 100, 20);
        jpItem.add(cbType);
        btnTypeAdd = new JButton("Voeg item toe");
        btnTypeAdd.setBounds(60, 70, 150, 20);
        // Nog actionlistener toevoegen
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
        btnItem = new JButton("Item");
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
        buttonPanel.add(btnExit);
        buttonPanel.add(btnItem);
        add(cardPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.NORTH);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                WinkelController frame = new WinkelController();
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);
            }
        });
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
