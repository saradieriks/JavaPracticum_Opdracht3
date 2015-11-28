package controller;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
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
    private JLabel jlKlant, jlUitlening, jlTerugbrengen, jlItem;
    private JTextField txtItemTitel;
    private JButton btnKlant, btnUitlening, btnTerugbrengen, btnItem, btnExit;
    private CardLayout cardLayout = new CardLayout();
    private Character[] type = { 'M', 'G' };

    public WinkelController() {
        setTitle("Winkel");
        setSize(600, 600);
        cardPanel = new JPanel();
        buttonPanel = new JPanel();
        cardPanel.setLayout(cardLayout);
        jpKlant = new JPanel();
        jpUitlening = new JPanel();
        jpTerugbrengen = new JPanel();
        jpItem = new JPanel();
        jlKlant = new JLabel("Nieuwe klant");
        jpKlant.add(jlKlant); 
        jlUitlening = new JLabel("Nieuwe uitlening");
        jpUitlening.add(jlUitlening);
        jlTerugbrengen = new JLabel("Terugbrengen uitlening");
        jpTerugbrengen.add(jlTerugbrengen);
        jlItem = new JLabel("Titel item");
        jpItem.add(jlItem);
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
