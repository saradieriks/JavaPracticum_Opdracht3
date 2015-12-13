package ui;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import domain.Adres;
import domain.Klant;
import io.IOWriter;

public class WinkelPanel extends JFrame {

	private static final long serialVersionUID = 1L;
    private JPanel cardPanel, jpKlant, jpUitlening, jpTerugbrengen, jpItem, buttonPanel, exitPanel;
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
    
    public WinkelPanel() {
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
	    btnKlantAdd.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		Klant nieuwe = new Klant(getTxtKlantNaam(), getTxtKlantVoornaam(), new Adres(getTxtKlantStraat(), getTxtKlantNummer(), getTxtKlantBox(),
	    				getTxtKlantPostcode(), getTxtKlantGemeente(), getTxtKlantLand()), getTxtKlantEmail());
	    		try {
					if (IOWriter.writeKlant(nieuwe) == true) {
						JOptionPane.showMessageDialog(null, "Succes", "InfoBox: " , JOptionPane.INFORMATION_MESSAGE);
					}
					else {
						JOptionPane.showMessageDialog(null, "Failure", "InfoBox: " , JOptionPane.INFORMATION_MESSAGE);
					}
				} catch (IOException e1) {
					e1.printStackTrace();
				}
	    	}
	    });
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
	    btnTypeAdd.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		
	    	}
	    });
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
    
    public String getTxtItemTitel() {
		return txtItemTitel.getText();
	}

	public void setTxtItemTitel(JTextField txtItemTitel) {
		this.txtItemTitel = txtItemTitel;
	}

	public String getTxtKlantVoornaam() {
		return txtKlantVoornaam.getText();
	}

	public void setTxtKlantVoornaam(JTextField txtKlantVoornaam) {
		this.txtKlantVoornaam = txtKlantVoornaam;
	}

	public String getTxtKlantNaam() {
		return txtKlantNaam.getText();
	}

	public void setTxtKlantNaam(JTextField txtKlantNaam) {
		this.txtKlantNaam = txtKlantNaam;
	}

	public String getTxtKlantStraat() {
		return txtKlantStraat.getText();
	}

	public void setTxtKlantStraat(JTextField txtKlantStraat) {
		this.txtKlantStraat = txtKlantStraat;
	}

	public String getTxtKlantNummer() {
		return txtKlantNummer.getText();
	}

	public void setTxtKlantNummer(JTextField txtKlantNummer) {
		this.txtKlantNummer = txtKlantNummer;
	}

	public String getTxtKlantBox() {
		return txtKlantBox.getText();
	}

	public void setTxtKlantBox(JTextField txtKlantBox) {
		this.txtKlantBox = txtKlantBox;
	}

	public String getTxtKlantPostcode() {
		return txtKlantPostcode.getText();
	}

	public void setTxtKlantPostcode(JTextField txtKlantPostcode) {
		this.txtKlantPostcode = txtKlantPostcode;
	}

	public String getTxtKlantGemeente() {
		return txtKlantGemeente.getText();
	}

	public void setTxtKlantGemeente(JTextField txtKlantGemeente) {
		this.txtKlantGemeente = txtKlantGemeente;
	}

	public String getTxtKlantLand() {
		return txtKlantLand.getText();
	}

	public void setTxtKlantLand(JTextField txtKlantLand) {
		this.txtKlantLand = txtKlantLand;
	}

	public String getTxtKlantEmail() {
		return txtKlantEmail.getText();
	}

	public void setTxtKlantEmail(JTextField txtKlantEmail) {
		this.txtKlantEmail = txtKlantEmail;
	}

	public String getTxtUitleningNaam() {
		return txtUitleningNaam.getText();
	}

	public void setTxtUitleningNaam(JTextField txtUitleningNaam) {
		this.txtUitleningNaam = txtUitleningNaam;
	}

	public String getTxtUitleningVoornaam() {
		return txtUitleningVoornaam.getText();
	}

	public void setTxtUitleningVoornaam(JTextField txtUitleningVoornaam) {
		this.txtUitleningVoornaam = txtUitleningVoornaam;
	}

	public String getTxtUitleningTitel1() {
		return txtUitleningTitel1.getText();
	}

	public void setTxtUitleningTitel1(JTextField txtUitleningTitel1) {
		this.txtUitleningTitel1 = txtUitleningTitel1;
	}

	public String getTxtUitleningTitel2() {
		return txtUitleningTitel2.getText();
	}

	public void setTxtUitleningTitel2(JTextField txtUitleningTitel2) {
		this.txtUitleningTitel2 = txtUitleningTitel2;
	}

	public String getTxtUitleningTitel3() {
		return txtUitleningTitel3.getText();
	}

	public void setTxtUitleningTitel3(JTextField txtUitleningTitel3) {
		this.txtUitleningTitel3 = txtUitleningTitel3;
	}

	public String getTxtUitleningTitel4() {
		return txtUitleningTitel4.getText();
	}

	public void setTxtUitleningTitel4(JTextField txtUitleningTitel4) {
		this.txtUitleningTitel4 = txtUitleningTitel4;
	}

	public String getTxtUitleningTitel5() {
		return txtUitleningTitel5.getText();
	}

	public void setTxtUitleningTitel5(JTextField txtUitleningTitel5) {
		this.txtUitleningTitel5 = txtUitleningTitel5;
	}

	public Double getTxtUitleningPrijs() {
		return Double.parseDouble(txtUitleningPrijs.getText());
	}

	public void setTxtUitleningPrijs(JTextField txtUitleningPrijs) {
		this.txtUitleningPrijs = txtUitleningPrijs;
	}

	public int getTxtUitleningDagen() {
		return Integer.parseInt(txtUitleningDagen.getText());
	}

	public void setTxtUitleningDagen(JTextField txtUitleningDagen) {
		this.txtUitleningDagen = txtUitleningDagen;
	}

	public Double getTxtTerugbrengenBoete() {
		return Double.parseDouble(txtTerugbrengenBoete.getText());
	}

	public void setTxtTerugbrengenBoete(JTextField txtTerugbrengenBoete) {
		this.txtTerugbrengenBoete = txtTerugbrengenBoete;
	}

	public char getCbType() {
		return (char) cbType.getSelectedItem();
	}

	public void setCbType(JComboBox cbType) {
		this.cbType = cbType;
	}

	public int getCbDag() {
		return Integer.parseInt((String) cbDag.getSelectedItem());
	}

	public void setCbDag(JComboBox cbDag) {
		this.cbDag = cbDag;
	}

	public int getCbMaand() {
		return Integer.parseInt((String) cbMaand.getSelectedItem());
	}

	public void setCbMaand(JComboBox cbMaand) {
		this.cbMaand = cbMaand;
	}

	public int getCbJaar() {
		return Integer.parseInt((String) cbJaar.getSelectedItem());
	}

	public void setCbJaar(JComboBox cbJaar) {
		this.cbJaar = cbJaar;
	}

	public Boolean getCbBetaald() {
		return cbBetaald.isSelected();
	}

	public void setCbBetaald(JCheckBox cbBetaald) {
		this.cbBetaald = cbBetaald;
	}
}
