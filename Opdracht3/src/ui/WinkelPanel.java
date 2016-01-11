package ui;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;


public class WinkelPanel extends JFrame {

	private static final long serialVersionUID = 1L;
    private JPanel cardPanel, jpKlant, jpUitlening, jpItem, buttonPanel, exitPanel, jpInventaris;
    private JLabel jlKlantVoornaam, jlKlantNaam, jlKlantStraat, jlKlantNummer, jlKlantBox, jlKlantPostcode, jlKlantGemeente, jlKlantLand, jlKlantEmail,
    	jlUitleningNaam, jlUitleningVoornaam, jlUitleningTitel, jlUitleningType, jlUitleningPrijs, jlItemTitel, jlItemType, jlUitleningDagen;
    private static JTextField txtItemTitel;
	private static JTextField txtKlantVoornaam;
	private static JTextField txtKlantNaam;
	private static JTextField txtKlantStraat;
	private static JTextField txtKlantNummer;
	private static JTextField txtKlantBox;
	private static JTextField txtKlantPostcode;
	private static JTextField txtKlantGemeente;
	private static JTextField txtKlantLand;
	private static JTextField txtKlantEmail;
	private static JTextField txtUitleningNaam;
	private static JTextField txtUitleningVoornaam;
	private static JTextField txtUitleningTitel;
	
	private JTextField txtUitleningPrijs;
	private static JTextField txtUitleningDagen;
	private JTextField txtTerugbrengenBoete;
    private JButton btnKlant, btnUitlening, btnItem, btnExit, btnTypeAdd, btnKlantAdd, btnUitleningAdd, 
    	btnUitleningVoegToe, btnUitleningVerwijder, btnInventaris, btnUitleningKlant, btnZoekItems;
    private CardLayout cardLayout = new CardLayout();
    private Character[] type = { 'M', 'G', 'C' };
    private static JComboBox cbType;
	private JComboBox cbDag;
	private JComboBox cbMaand;
	private JComboBox cbJaar;
    private JCheckBox cbBetaald;
    public JTable tblUitleningen;
    private JButton btnLijstVanAlle;
    private static JTextField ZoekText;
    private String[] kolomNamen = {"Type", "Titel", "Dagen"};
    private static DefaultTableModel model;
    private static JTextField textID;
    private JLabel lblKlantInuitschrijvenOp;
    private static JTextField textKlantNaam;
    private JButton btnZoekID;
    private JButton btnKlantInschrijven;
    private JButton btnKlantUitschrijven;
    
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
	    jpInventaris = new JPanel();
	    jpInventaris.setLayout(null);
	    
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
	    /*btnKlantAdd.addActionListener(new ActionListener() {
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
					txtKlantNaam.setText("");
					txtKlantVoornaam.setText("");
					txtKlantStraat.setText("");
					txtKlantNummer.setText("");
					txtKlantBox.setText("");
					txtKlantPostcode.setText("");
					txtKlantGemeente.setText("");
					txtKlantLand.setText("");
					txtKlantEmail.setText("");
				} catch (IOException e1) {
					e1.printStackTrace();
				}
	    	}
	    });*/
	    jpKlant.add(btnKlantAdd);
	    
	    // Uitlening-paneel
	    model = new DefaultTableModel(kolomNamen, 0);
	    tblUitleningen = new JTable(model); tblUitleningen.setBounds(10, 130, 400, 400); jpUitlening.add(tblUitleningen);
	    Object[] rowData = { "Type", "Titel", "Aantal dagen" };
	    model.addRow(rowData);
	    jlUitleningVoornaam = new JLabel("Voornaam klant: "); jlUitleningVoornaam.setBounds(10, 10, 100, 20); jpUitlening.add(jlUitleningVoornaam);
	    txtUitleningVoornaam = new JTextField(); txtUitleningVoornaam.setBounds(110, 10, 200, 20); jpUitlening.add(txtUitleningVoornaam);
	    jlUitleningNaam = new JLabel("Naam klant: "); jlUitleningNaam.setBounds(10, 40, 100, 20); jpUitlening.add(jlUitleningNaam);
	    txtUitleningNaam = new JTextField(); txtUitleningNaam.setBounds(110, 40, 200, 20); jpUitlening.add(txtUitleningNaam);
	    btnUitleningKlant = new JButton("Haal uitleningen op"); btnUitleningKlant.setBounds(320, 40, 200, 20); jpUitlening.add(btnUitleningKlant);
	    /*btnUitleningKlant.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		for (int i = 0; i < Reservatie.haalReservatiesOp(getTxtKlantNaam(), getTxtKlantVoornaam()).size(); i++){
	    			char lijn1 = Reservatie.haalReservatiesOp(getTxtKlantNaam(), getTxtKlantVoornaam()).get(i).getItem().getType();
	    			String lijn2 = Reservatie.haalReservatiesOp(getTxtKlantNaam(), getTxtKlantVoornaam()).get(i).getItem().getTitel();
	    			int lijn3 = Reservatie.haalReservatiesOp(getTxtKlantNaam(), getTxtKlantVoornaam()).get(i).getAatalDagen();
	    			Object[] rowData = { lijn1, lijn2, lijn3 };
	    			model.addRow(rowData);
	    		}
	    	}
	    });*/
	    jlUitleningType = new JLabel("Type item: "); jlUitleningType.setBounds(10, 70, 100, 20); jpUitlening.add(jlUitleningType);
	    cbType = new JComboBox(type); cbType.setBounds(110, 70, 50, 20); jpUitlening.add(cbType);
	    jlUitleningTitel = new JLabel("Titel item: "); jlUitleningTitel.setBounds(170, 70, 100, 20); jpUitlening.add(jlUitleningTitel);
	    txtUitleningTitel = new JTextField(); txtUitleningTitel.setBounds(280, 70, 200, 20); jpUitlening.add(txtUitleningTitel);
	    jlUitleningDagen = new JLabel("Aantal dagen:"); jlUitleningDagen.setBounds(490, 70, 100, 20); jpUitlening.add(jlUitleningDagen);
	    txtUitleningDagen = new JTextField(); txtUitleningDagen.setBounds(600, 70, 100, 20); jpUitlening.add(txtUitleningDagen);
	    btnUitleningVoegToe = new JButton("Voeg item toe"); btnUitleningVoegToe.setBounds(10, 100, 200, 20);
	    /*btnUitleningVoegToe.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		if (Reservatie.isAvailable(getTxtUitleningTitel(), getCbType())) {
	    			JOptionPane.showMessageDialog(null, "Item beschikbaar", "InfoBox: " , JOptionPane.INFORMATION_MESSAGE);
	    			Reservatie nieuwe = new Reservatie(Item.vindItem(getTxtUitleningTitel(), getCbType()), getTxtUitleningDagen(), 
	    					Klant.vindKlantId(getTxtUitleningNaam(), getTxtUitleningVoornaam()));
	    			if (Klant.vindKlantId(getTxtUitleningNaam(), getTxtUitleningVoornaam()) == -1) {
	    				JOptionPane.showMessageDialog(null, "Klant niet gevonden", "InfoBox: " , JOptionPane.INFORMATION_MESSAGE);
	    			}
	    			else {
	    				JOptionPane.showMessageDialog(null, "Klant gevonden", "InfoBox: " , JOptionPane.INFORMATION_MESSAGE);
	    			}
	    			try {
						if (IOWriter.writeReservatie(nieuwe) == true) {
							model.addRow(new Object[]{getCbType(), getTxtUitleningTitel(), getTxtUitleningDagen()});
							JOptionPane.showMessageDialog(null, "Succes", "InfoBox: " , JOptionPane.INFORMATION_MESSAGE);
						}
						else {
							JOptionPane.showMessageDialog(null, "Failure", "InfoBox: " , JOptionPane.INFORMATION_MESSAGE);
						}
						txtUitleningVoornaam.setText("");
						txtUitleningNaam.setText("");
						txtUitleningTitel.setText("");
						txtUitleningDagen.setText("");
					} catch (IOException e1) {
						e1.printStackTrace();
					}   		
	    		}
	    		else {
	    			JOptionPane.showMessageDialog(null, "Item niet gevonden", "InfoBox: " , JOptionPane.INFORMATION_MESSAGE);
	    		}
	    	}
	    });*/
	    jpUitlening.add(btnUitleningVoegToe);
	    btnUitleningVerwijder = new JButton("Verwijder item"); btnUitleningVerwijder.setBounds(220, 100, 200, 20); jpUitlening.add(btnUitleningVerwijder);
	    /*btnUitleningVerwijder.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		
	    	}
	    });*/
	    jlUitleningPrijs = new JLabel("Prijs:"); jlUitleningPrijs.setBounds(10, 540, 100, 20); jpUitlening.add(jlUitleningPrijs);
	    txtUitleningPrijs = new JTextField(); txtUitleningPrijs.setBounds(110, 540, 200, 20); jpUitlening.add(txtUitleningPrijs);
	    btnUitleningAdd = new JButton("Voeg uitlening toe"); btnUitleningAdd.setBounds(60, 570, 150, 20);
	    /*btnUitleningAdd.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	  		  	
	    	}
	    });*/
	    jpUitlening.add(btnUitleningAdd);   
	    
	    // Item-paneel
	    jlItemTitel = new JLabel("Titel item:"); jlItemTitel.setBounds(10, 10, 100, 20); jpItem.add(jlItemTitel);
	    txtItemTitel = new JTextField(); txtItemTitel.setBounds(110, 10, 200, 20); jpItem.add(txtItemTitel);
	    jlItemType = new JLabel("Type item: "); jlItemType.setBounds(10, 40, 100, 20); jpItem.add(jlItemType);
	    cbType = new JComboBox(type); cbType.setBounds(110, 40, 50, 20); jpItem.add(cbType);
	    btnTypeAdd = new JButton("Voeg item toe"); btnTypeAdd.setBounds(60, 70, 150, 20);
	    /*btnTypeAdd.addActionListener(new ActionListener() {
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
					txtItemTitel.setText("");
				} catch (IOException e1) {
					e1.printStackTrace();
				}
	    	}
	    });*/
	    jpItem.add(btnTypeAdd);
	    
	    // Inventaris-paneel
	    
	    btnLijstVanAlle = new JButton("Lijst van alle items geven");
	    btnLijstVanAlle.setBounds(26, 38, 177, 25);
	    jpInventaris.add(btnLijstVanAlle);
	    
	    ZoekText = new JTextField();
	    ZoekText.setBounds(98, 76, 177, 22);
	    jpInventaris.add(ZoekText);
	    ZoekText.setColumns(10);
	    
	    btnZoekItems = new JButton("Zoek items");
	    btnZoekItems.setBounds(130, 105, 97, 25);
	    jpInventaris.add(btnZoekItems);
	    
	    JLabel lblZoekterm = new JLabel("Zoekterm:");
	    lblZoekterm.setBounds(26, 76, 116, 16);
	    jpInventaris.add(lblZoekterm);
	    
	    /*btnLijstVanAlle.addActionListener(new ActionListener () {

			public void actionPerformed(ActionEvent e) {
				
				try {
					IOReader.refreshItems();
					StringBuilder alleItems = new StringBuilder();
					alleItems.append("---MOVIES---\n");
					List<String> movies = new ArrayList<>();
					for (Map.Entry<String, String> entry : IOReader.getMovies().entrySet())
					{
						movies.add(entry.getValue().replaceAll(Pattern.quote("+")," "));
					}
					java.util.Collections.sort(movies);
					for (String movie: movies)
					{
						alleItems.append(movie + "\n");
					}
					alleItems.append("\n---GAMES---\n");
					List<String> games = new ArrayList<>();
					for (Map.Entry<String, String> entry : IOReader.getGames().entrySet())
					{
						games.add(entry.getValue().replaceAll(Pattern.quote("+")," "));
					}
					java.util.Collections.sort(games);
					for (String game: games)
					{
						alleItems.append(game + "\n");
					}
					alleItems.append("\n---CDs---\n");
					List<String> cds = new ArrayList<>();
					for (Map.Entry<String, String> entry : IOReader.getCDs().entrySet())
					{
						cds.add(entry.getValue().replaceAll(Pattern.quote("+")," "));
					}
					java.util.Collections.sort(cds);
					for (String cd: cds)
					{
						alleItems.append(cd + "\n");
					}
					JOptionPane.showMessageDialog(null, alleItems.toString(), "RESULTAAT" , JOptionPane.INFORMATION_MESSAGE);
						
				} catch (IOException e1) {
					e1.printStackTrace();
				}	
			}
	    });*/
	    
	    /*btnZoekItems.addActionListener(new ActionListener () {

			public void actionPerformed(ActionEvent e) {
				
				try {
					IOReader.refreshItems();
					StringBuilder alleItems = new StringBuilder();
					alleItems.append("---MOVIES---\n");
					List<String> movies = new ArrayList<>();
					for (Map.Entry<String, String> entry : IOReader.getMovies().entrySet())
					{
						if ((entry.getValue().replaceAll(Pattern.quote("+")," ")).toLowerCase().contains((ZoekText.getText()).toLowerCase()))
						{
							movies.add(entry.getValue().replaceAll(Pattern.quote("+")," "));
						}
					    
					}
					java.util.Collections.sort(movies);
					for (String movie: movies)
					{
						alleItems.append(movie + "\n");
					}
					alleItems.append("\n---GAMES---\n");
					List<String> games = new ArrayList<>();
					for (Map.Entry<String, String> entry : IOReader.getGames().entrySet())
					{
						if ((entry.getValue().replaceAll(Pattern.quote("+")," ")).toLowerCase().contains((ZoekText.getText()).toLowerCase()))
						{
							games.add(entry.getValue().replaceAll(Pattern.quote("+")," "));
						}
					    
					}
					java.util.Collections.sort(games);
					for (String game: games)
					{
						alleItems.append(game + "\n");
					}
					alleItems.append("\n---CDs---\n");
					List<String> cds = new ArrayList<>();
					for (Map.Entry<String, String> entry : IOReader.getCDs().entrySet())
					{
						if ((entry.getValue().replaceAll(Pattern.quote("+")," ")).toLowerCase().contains((ZoekText.getText()).toLowerCase()))
						{
							cds.add(entry.getValue().replaceAll(Pattern.quote("+")," "));
						}
					    
					}
					java.util.Collections.sort(cds);
					for (String cd: cds)
					{
						alleItems.append(cd + "\n");
					}
					JOptionPane.showMessageDialog(null, alleItems.toString(), "RESULTAAT" , JOptionPane.INFORMATION_MESSAGE);	
				} catch (IOException e1) {
					e1.printStackTrace();
				}	
			}
	    });*/
	    
	    JLabel lblKlantId = new JLabel("Klant ID:");
	    lblKlantId.setBounds(26, 208, 56, 16);
	    jpInventaris.add(lblKlantId);
	    
	    textID= new JTextField();
	    textID.setBounds(87, 205, 116, 22);
	    jpInventaris.add(textID);
	    textID.setColumns(10);
	    
	    btnKlantInschrijven = new JButton("Klant inschrijven");
	    btnKlantInschrijven.setBounds(24, 234, 154, 25);
	    jpInventaris.add(btnKlantInschrijven);
	    
	    btnKlantUitschrijven = new JButton("Klant uitschrijven");
	  
	    btnKlantUitschrijven.setBounds(26, 266, 152, 25);
	    jpInventaris.add(btnKlantUitschrijven);
	    
	    lblKlantInuitschrijvenOp = new JLabel("Klant in/uitschrijven op mail nieuwe items:");
	    lblKlantInuitschrijvenOp.setBounds(26, 179, 283, 16);
	    jpInventaris.add(lblKlantInuitschrijvenOp);
	    
	    textKlantNaam = new JTextField();
	    textKlantNaam.setBounds(26, 337, 235, 22);
	    jpInventaris.add(textKlantNaam);
	    textKlantNaam.setColumns(10);
	    
	    btnZoekID = new JButton("Zoek ID's van deze klant naam");
	    btnZoekID.setBounds(24, 311, 237, 25);
	    jpInventaris.add(btnZoekID);
	    
	    // Card toevoegen aan de main panel
	    cardPanel.add(jpKlant, "1");
	    cardPanel.add(jpUitlening, "2");
	    cardPanel.add(jpItem,  "3");
	    cardPanel.add(jpInventaris, "4");
	    

	    

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
	    btnInventaris = new JButton("Inventaris");
	    btnInventaris.addActionListener(new ActionListener() {
	
	        public void actionPerformed(ActionEvent e) {
	            cardLayout.show(cardPanel, "4");
	        }
	    });
	    btnExit = new JButton("Exit");
	    /*btnExit.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		System.exit(0);
	    	}
	    });*/
	    buttonPanel.add(btnKlant);
	    buttonPanel.add(btnUitlening);
	    buttonPanel.add(btnItem);
	    buttonPanel.add(btnInventaris);
	    exitPanel.add(btnExit);
	    getContentPane().add(cardPanel, BorderLayout.CENTER);
	    getContentPane().add(buttonPanel, BorderLayout.NORTH);
	    getContentPane().add(exitPanel, BorderLayout.SOUTH);
    }
    
    public static String getTxtItemTitel() {
		return txtItemTitel.getText();
	}

	public void setTxtItemTitel(JTextField txtItemTitel) {
		this.txtItemTitel = txtItemTitel;
	}

	public static String getTxtKlantVoornaam() {
		return txtKlantVoornaam.getText();
	}

	public void setTxtKlantVoornaam(JTextField txtKlantVoornaam) {
		this.txtKlantVoornaam = txtKlantVoornaam;
	}

	public static String getTxtKlantNaam() {
		return txtKlantNaam.getText();
	}

	public void setZoekText(JTextField ZoekText) {
		this.ZoekText = ZoekText;
	}
	
	public static String getZoekText() {
		return ZoekText.getText();
	}

	public void setTxtKlantNaam(JTextField txtKlantNaam) {
		this.txtKlantNaam = txtKlantNaam;
	}

	public static String getTxtKlantStraat() {
		return txtKlantStraat.getText();
	}

	public void setTxtKlantStraat(JTextField txtKlantStraat) {
		this.txtKlantStraat = txtKlantStraat;
	}

	public static String getTxtKlantNummer() {
		return txtKlantNummer.getText();
	}

	public void setTxtKlantNummer(JTextField txtKlantNummer) {
		this.txtKlantNummer = txtKlantNummer;
	}

	public static String getTxtKlantBox() {
		return txtKlantBox.getText();
	}

	public void setTxtKlantBox(JTextField txtKlantBox) {
		this.txtKlantBox = txtKlantBox;
	}

	public static String getTxtKlantPostcode() {
		return txtKlantPostcode.getText();
	}

	public void setTxtKlantPostcode(JTextField txtKlantPostcode) {
		this.txtKlantPostcode = txtKlantPostcode;
	}

	public static String getTxtKlantGemeente() {
		return txtKlantGemeente.getText();
	}

	public void setTxtKlantGemeente(JTextField txtKlantGemeente) {
		this.txtKlantGemeente = txtKlantGemeente;
	}

	public static String getTxtKlantLand() {
		return txtKlantLand.getText();
	}

	public void setTxtKlantLand(JTextField txtKlantLand) {
		this.txtKlantLand = txtKlantLand;
	}

	public static String getTxtKlantEmail() {
		return txtKlantEmail.getText();
	}

	public void setTxtKlantEmail(JTextField txtKlantEmail) {
		this.txtKlantEmail = txtKlantEmail;
	}

	public static String getTxtUitleningNaam() {
		return txtUitleningNaam.getText();
	}

	public void setTxtUitleningNaam(JTextField txtUitleningNaam) {
		this.txtUitleningNaam = txtUitleningNaam;
	}

	public static String getTxtUitleningVoornaam() {
		return txtUitleningVoornaam.getText();
	}

	public void setTxtUitleningVoornaam(JTextField txtUitleningVoornaam) {
		this.txtUitleningVoornaam = txtUitleningVoornaam;
	}

	public static String getTxtUitleningTitel() {
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

	public static int getTxtUitleningDagen() {
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

	public static char getCbType() {
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
	
	public void setModel (DefaultTableModel model) {
		this.model = model;
	}
	
	public static DefaultTableModel getModel() {
		return model;
	}
	
	public static int getID()  {

			return Integer.parseInt(textID.getText());


	}
	
	public static String getKlantNaam() {
		
		return textKlantNaam.getText();
		
	}
	
	public void setBtnExit(ActionListener listenerForBtnExit){
		btnExit.addActionListener(listenerForBtnExit);		 
	   }
	
	public void setBtnKlant(ActionListener listenerForBtnKlant){
		btnKlant.addActionListener(listenerForBtnKlant);		 
	   } 
	
	public void setBtnUitlening(ActionListener listenerForBtnUitlening){
		btnUitlening.addActionListener(listenerForBtnUitlening);		 
	   } 
	
	public void setBtnItem(ActionListener listenerForBtnItem){
		btnItem.addActionListener(listenerForBtnItem);		 
	   } 
	
	public void setBtnTypeAdd(ActionListener listenerForBtnTypeAdd){
		btnTypeAdd.addActionListener(listenerForBtnTypeAdd);		 
	   } 
	
	public void setBtnKlantAdd(ActionListener listenerForBtnKlantAdd){
		btnKlantAdd.addActionListener(listenerForBtnKlantAdd);		 
	   } 
	
	public void setBtnUitleningAdd(ActionListener listenerForBtnUitleningAdd){
		btnUitleningAdd.addActionListener(listenerForBtnUitleningAdd);		 
	   } 
	
	public void setBtnUitleningVoegToe(ActionListener listenerForBtnUitleningVoegToe){
		btnUitleningVoegToe.addActionListener(listenerForBtnUitleningVoegToe);		 
	   } 
	
	public void setBtnUitleningVerwijder(ActionListener listenerForBtnUitleningVerwijder){
		btnUitleningVerwijder.addActionListener(listenerForBtnUitleningVerwijder);		 
	   } 
	
	public void setBtnInventaris(ActionListener listenerForBtnInventaris){
		btnInventaris.addActionListener(listenerForBtnInventaris);		 
	   } 
	
	public void setBtnUitleningKlant(ActionListener listenerForBtnUitleningKlant){
		btnUitleningKlant.addActionListener(listenerForBtnUitleningKlant);		 
	   } 
	
	public void setBtnLijstVanAlle(ActionListener listenerForBtnLijstVanAlle) {
		btnLijstVanAlle.addActionListener(listenerForBtnLijstVanAlle);
	}
	
	public void setBtnZoekItems(ActionListener listenerForBtnZoekItems) {
		btnZoekItems.addActionListener(listenerForBtnZoekItems);
	}
	
	public void setBtnKlantInschrijven(ActionListener listenerForBtnKlantInschrijven) {
		btnKlantInschrijven.addActionListener(listenerForBtnKlantInschrijven);
	}
	public void setBtnKlantUitschrijven(ActionListener listenerForBtnKlantUitschrijven) {
		btnKlantUitschrijven.addActionListener(listenerForBtnKlantUitschrijven);
	}
	public void setBtnZoekID(ActionListener listenerForBtnZoekID) {
		btnZoekID.addActionListener(listenerForBtnZoekID);
	}
	
	
}
