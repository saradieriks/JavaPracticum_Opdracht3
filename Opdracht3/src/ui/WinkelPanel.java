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
import javax.swing.JTable;
import javax.swing.JTextField;

import domain.Adres;
import domain.Cd;
import domain.Datum;
import domain.Film;
import domain.Item;
import domain.Klant;
import domain.Reservatie;
import domain.Spel;
import io.IOWriter;

public class WinkelPanel extends JFrame {

	private static final long serialVersionUID = 1L;
    private JPanel cardPanel, jpKlant, jpUitlening, jpItem, buttonPanel, exitPanel;
    private JLabel jlKlantVoornaam, jlKlantNaam, jlKlantStraat, jlKlantNummer, jlKlantBox, jlKlantPostcode, jlKlantGemeente, jlKlantLand, jlKlantEmail,
    	jlUitleningNaam, jlUitleningVoornaam, jlUitleningTitel, jlUitleningType, jlUitleningPrijs, jlItemTitel, jlItemType, jlUitleningDagen;
    private JTextField txtItemTitel, txtKlantVoornaam, txtKlantNaam, txtKlantStraat, txtKlantNummer, txtKlantBox, txtKlantPostcode, txtKlantGemeente,
    	txtKlantLand, txtKlantEmail,txtUitleningNaam, txtUitleningVoornaam, txtUitleningTitel, txtUitleningPrijs, txtUitleningDagen, txtTerugbrengenBoete;
    private JButton btnKlant, btnUitlening, btnTerugbrengen, btnItem, btnExit, btnTypeAdd, btnKlantAdd, btnUitleningAdd, 
    	btnUitleningVoegToe, btnUitleningVerwijder;
    private CardLayout cardLayout = new CardLayout();
    private Character[] type = { 'M', 'G', 'C' };
    private JComboBox cbType, cbDag, cbMaand, cbJaar;
    private JCheckBox cbBetaald;
    private JTable tblUitleningen;
    
    public WinkelPanel() {
	    setTitle("Winkel");
	    setSize(800, 720);
	    cardPanel = new JPanel();
	    buttonPanel = new JPanel();
	    exitPanel = new JPanel();
	    cardPanel.setLayout(cardLayout);
	    jpKlant = new JPanel(); 
	    jpKlant.setLayout(null);
	    jpUitlening = new JPanel();
	    jpUitlening.setLayout(null);;
	    jpItem = new JPanel();
	    jpItem.setLayout(null);
	    
	    // Klant-paneel
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
	    
	    // Uitlening-paneel
	    jlUitleningVoornaam = new JLabel("Voornaam klant: "); jlUitleningVoornaam.setBounds(10, 10, 100, 20); jpUitlening.add(jlUitleningVoornaam);
	    txtUitleningVoornaam = new JTextField(); txtUitleningVoornaam.setBounds(110, 10, 200, 20); jpUitlening.add(txtUitleningVoornaam);
	    jlUitleningNaam = new JLabel("Naam klant: "); jlUitleningNaam.setBounds(10, 40, 100, 20); jpUitlening.add(jlUitleningNaam);
	    txtUitleningNaam = new JTextField(); txtUitleningNaam.setBounds(110, 40, 200, 20); jpUitlening.add(txtUitleningNaam);
	    jlUitleningType = new JLabel("Type item: "); jlUitleningType.setBounds(10, 70, 100, 20); jpUitlening.add(jlUitleningType);
	    cbType = new JComboBox(type); cbType.setBounds(110, 70, 50, 20); jpUitlening.add(cbType);
	    jlUitleningTitel = new JLabel("Titel item: "); jlUitleningTitel.setBounds(170, 70, 100, 20); jpUitlening.add(jlUitleningTitel);
	    txtUitleningTitel = new JTextField(); txtUitleningTitel.setBounds(280, 70, 200, 20); jpUitlening.add(txtUitleningTitel);
	    jlUitleningDagen = new JLabel("Aantal dagen:"); jlUitleningDagen.setBounds(490, 70, 100, 20); jpUitlening.add(jlUitleningDagen);
	    txtUitleningDagen = new JTextField(); txtUitleningDagen.setBounds(600, 70, 100, 20); jpUitlening.add(txtUitleningDagen);
	    btnUitleningVoegToe = new JButton("Voeg item toe"); btnUitleningVoegToe.setBounds(10, 100, 200, 20);
	    btnUitleningVoegToe.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		//System.out.println(getTxtUitleningTitel() + " " + getCbType());
	    		if (Reservatie.isAvailable(getTxtUitleningTitel(), getCbType())) {
	    			JOptionPane.showMessageDialog(null, "Item beschikbaar", "InfoBox: " , JOptionPane.INFORMATION_MESSAGE);
	    			Reservatie nieuwe = new Reservatie(Item.vindItem(getTxtUitleningTitel(), getCbType()), getTxtUitleningDagen(), 
	    					Klant.vindKlantId(getTxtUitleningNaam(), getTxtUitleningVoornaam()));
	    			if (Klant.vindKlantId(getTxtUitleningNaam(), getTxtUitleningVoornaam()) == 0) {
	    				JOptionPane.showMessageDialog(null, "Klant niet gevonden", "InfoBox: " , JOptionPane.INFORMATION_MESSAGE);
	    			}
	    			else {
	    				JOptionPane.showMessageDialog(null, "Klant gevonden", "InfoBox: " , JOptionPane.INFORMATION_MESSAGE);
	    			}
	    			try {
						if (IOWriter.writeReservatie(nieuwe) == true) {
							JOptionPane.showMessageDialog(null, "Succes", "InfoBox: " , JOptionPane.INFORMATION_MESSAGE);
						}
						else {
							JOptionPane.showMessageDialog(null, "Failure", "InfoBox: " , JOptionPane.INFORMATION_MESSAGE);
						}
					} catch (IOException e1) {
						e1.printStackTrace();
					}   		
	    		}
	    		else {
	    			JOptionPane.showMessageDialog(null, "Item niet gevonden", "InfoBox: " , JOptionPane.INFORMATION_MESSAGE);
	    		}
	    	}
	    });
	    jpUitlening.add(btnUitleningVoegToe);
	    btnUitleningVerwijder = new JButton("Verwijder item"); btnUitleningVerwijder.setBounds(220, 100, 200, 20); jpUitlening.add(btnUitleningVerwijder);
	    tblUitleningen = new JTable(); tblUitleningen.setBounds(10, 130, 400, 400); jpUitlening.add(tblUitleningen);
	    jlUitleningPrijs = new JLabel("Prijs:"); jlUitleningPrijs.setBounds(10, 540, 100, 20); jpUitlening.add(jlUitleningPrijs);
	    txtUitleningPrijs = new JTextField(); txtUitleningPrijs.setBounds(110, 540, 200, 20); jpUitlening.add(txtUitleningPrijs);
	    btnUitleningAdd = new JButton("Voeg uitlening toe"); btnUitleningAdd.setBounds(60, 570, 150, 20);
	    btnUitleningAdd.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	  		  	
	    	}
	    });
	    jpUitlening.add(btnUitleningAdd);   
	    
	    // Item-paneel
	    jlItemTitel = new JLabel("Titel item:"); jlItemTitel.setBounds(10, 10, 100, 20); jpItem.add(jlItemTitel);
	    txtItemTitel = new JTextField(); txtItemTitel.setBounds(110, 10, 200, 20); jpItem.add(txtItemTitel);
	    jlItemType = new JLabel("Type item: "); jlItemType.setBounds(10, 40, 100, 20); jpItem.add(jlItemType);
	    cbType = new JComboBox(type); cbType.setBounds(110, 40, 50, 20); jpItem.add(cbType);
	    btnTypeAdd = new JButton("Voeg item toe"); btnTypeAdd.setBounds(60, 70, 150, 20);
	    btnTypeAdd.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		Item nieuwe;
	    		if (getCbType() == 'M') {
	    			nieuwe = new Film(getTxtItemTitel(), getCbType());
	    		}
	    		else if (getCbType() == 'G') {
	    			nieuwe = new Spel(getTxtItemTitel(), getCbType());
	    		}
	    		else {
	    			nieuwe = new Cd(getTxtItemTitel(), getCbType());
	    		}
	    		try {
					if (IOWriter.writeItem(nieuwe) == true) {
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
	    jpItem.add(btnTypeAdd);
	    
	    // Card toevoegen aan de main panel
	    cardPanel.add(jpKlant, "1");
	    cardPanel.add(jpUitlening, "2");
	    cardPanel.add(jpItem,  "3");
	    btnKlant = new JButton("Nieuwe Klant");
	    btnKlant.addActionListener(new ActionListener() {
	
	        public void actionPerformed(ActionEvent e) {
	            cardLayout.show(cardPanel, "1");
	        }
	    });
	    btnUitlening = new JButton("Uitlening");
	    btnUitlening.addActionListener(new ActionListener() {
	
	        public void actionPerformed(ActionEvent e) {
	            cardLayout.show(cardPanel, "2");
	        }
	    });
	    btnItem = new JButton("Nieuw item");
	    btnItem.addActionListener(new ActionListener() {
	
	        public void actionPerformed(ActionEvent e) {
	            cardLayout.show(cardPanel, "3");
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

	public String getTxtUitleningTitel() {
		return txtUitleningTitel.getText();
	}

	public void setTxtUitleningTitel(JTextField txtUitleningTitel) {
		this.txtUitleningTitel = txtUitleningTitel;
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
		return cbMaand.getSelectedIndex() + 1;
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
