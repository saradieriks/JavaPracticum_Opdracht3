package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import domain.Adres;
import domain.Cd;
import domain.Film;
import domain.Item;
import domain.Klant;
import domain.Observer;
import domain.Reservatie;
import domain.Spel;
import domain.Subject;
import io.IOReader;
import io.IOWriter;
import ui.WinkelPanel;
import ui.KlantPanel;

import domain.Klant;
import domain.Adres;

public class WinkelController extends JFrame implements Subject {

	public static Map <String,List<Item>> Items = new HashMap<>();
	private static Map <String,List<Reservatie>> Reservaties = new HashMap<>();
	private static List<Observer>observers = new ArrayList<Observer>();
	private static List<Klant>Klanten = new ArrayList<Klant>();
	/*
	 * De list observers moet alle klanten bevatten met IsObserver == true
	 * klanten die at runtime observer worden, worden toegevoegd via de methode binnen klant
	 * maakKlantObserver
	 * Wanneer een nieuw item wordt toegevoegd moet de methode
	 * notifyObservers(item) uitgevoerd worden.
	 */
	
	//observer methods
	private void bouwKlantLijst()
	{
		for (Map.Entry<Integer, String> entry : IOReader.getKlanten().entrySet()) {
		    Integer key = entry.getKey();
		    String value = entry.getValue();
		    String w[] = value.split(";");
		    Adres bestaandAdresKlant = new Adres(w[2],w[3],w[4],w[5],w[6],w[7]);
		    int obs = Integer.parseInt(w[9]);
		    Klant bestaand = new Klant(key,w[1], w[0],bestaandAdresKlant,w[8],obs);
		    if (obs == 1){ addObserver(bestaand);}
		    Klanten.add(bestaand);
		    
		}
	}
	public void addObserver(Observer o) {
		observers.add(o);	
	}
	
	public void removeObserver(Observer o) {
		observers.remove(o);
	}
	
	private void notifyObservers(Item item) {
		Iterator i = observers.iterator();
		while (i.hasNext() ) {
			Observer o = (Observer) i.next();
			o.update(this, item);
			
		}
	}

    @SuppressWarnings("deprecation")
	public WinkelController() {
    	bouwKlantLijst();
        WinkelPanel paneel = new WinkelPanel();
        paneel.setBtnExit(new btnExitListener());
        paneel.setBtnTypeAdd(new btnTypeAddListener());
        paneel.setBtnKlantAdd(new btnKlantAddListener());
        paneel.setBtnUitleningAdd(new btnUitleningAddListener());
        paneel.setBtnUitleningVoegToe(new btnUitleningVoegToeListener());
        paneel.setBtnUitleningVerwijder(new btnUitleningVerwijderListener());
        paneel.setBtnLijstVanAlle(new btnLijstVanAlleListener());
        paneel.setBtnZoekItems(new btnZoekItemsListener());
        paneel.setBtnKlantInschrijven( new btnKlantInschrijvenListener());
        paneel.setBtnKlantUitschrijven( new btnKlantUitschrijvenListener());
        paneel.setBtnZoekID (new btnZoekIDListener());
        paneel.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        paneel.setVisible(true);
        paneel.show();
        
        KlantPanel klantPaneel = new KlantPanel();
        klantPaneel.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        klantPaneel.setVisible(true);
        klantPaneel.show();
        
    }

	class btnExitListener implements ActionListener{
		 public void actionPerformed(ActionEvent e) {
			 System.exit(0);		 
		 }
	}
	
	class btnTypeAddListener implements ActionListener{
		 public void actionPerformed(ActionEvent e) {
			 Item nieuwe;
	    		if (WinkelPanel.getCbType() == 'M') {
	    			nieuwe = new Film(WinkelPanel.getTxtItemTitel(), WinkelPanel.getCbType());
	    		}
	    		else if (WinkelPanel.getCbType() == 'G') {
	    			nieuwe = new Spel(WinkelPanel.getTxtItemTitel(), WinkelPanel.getCbType());
	    		}
	    		else {
	    			nieuwe = new Cd(WinkelPanel.getTxtItemTitel(), WinkelPanel.getCbType());
	    		}
	    		try {
					if (IOWriter.writeItem(nieuwe) == true) {
						JOptionPane.showMessageDialog(null, "Succes", "InfoBox: " , JOptionPane.INFORMATION_MESSAGE);
						notifyObservers(nieuwe);
						
					}
					else {
						JOptionPane.showMessageDialog(null, "Failure", "InfoBox: " , JOptionPane.INFORMATION_MESSAGE);
					}
				} catch (IOException e1) {
					e1.printStackTrace();
				}		 
		 }
	}
	
	class btnKlantAddListener implements ActionListener{
		 public void actionPerformed(ActionEvent e) {
			 Klant nieuwe = new Klant(WinkelPanel.getTxtKlantNaam(), WinkelPanel.getTxtKlantVoornaam(), new Adres(WinkelPanel.getTxtKlantStraat(), 
					 WinkelPanel.getTxtKlantNummer(), WinkelPanel.getTxtKlantBox(), WinkelPanel.getTxtKlantPostcode(), WinkelPanel.getTxtKlantGemeente(),
					 WinkelPanel.getTxtKlantLand()), WinkelPanel.getTxtKlantEmail());
	    		try {
					if (IOWriter.writeKlant(nieuwe) == true) {
						JOptionPane.showMessageDialog(null, "Succes", "InfoBox: " , JOptionPane.INFORMATION_MESSAGE);
						Klanten.add(nieuwe);
					}
					else {
						JOptionPane.showMessageDialog(null, "Failure", "InfoBox: " , JOptionPane.INFORMATION_MESSAGE);
					}
				} catch (IOException e1) {
					e1.printStackTrace();
				}		 
		 }
	}
	
	class btnUitleningAddListener implements ActionListener{
		 public void actionPerformed(ActionEvent e) {
			 		 
		 }
	}
	
	class btnUitleningVoegToeListener implements ActionListener{
		 public void actionPerformed(ActionEvent e) {
			 if (Reservatie.isAvailable(WinkelPanel.getTxtUitleningTitel(), WinkelPanel.getCbType())) {
	    			JOptionPane.showMessageDialog(null, "Item beschikbaar", "InfoBox: " , JOptionPane.INFORMATION_MESSAGE);
	    			Reservatie nieuwe = new Reservatie(Item.vindItem(WinkelPanel.getTxtUitleningTitel(), WinkelPanel.getCbType()),
	    					WinkelPanel.getTxtUitleningDagen(), Klant.vindKlantId(WinkelPanel.getTxtUitleningNaam(),
	    					WinkelPanel.getTxtUitleningVoornaam()));
	    			if (Klant.vindKlantId(WinkelPanel.getTxtUitleningNaam(), WinkelPanel.getTxtUitleningVoornaam()) == -1) {
	    				JOptionPane.showMessageDialog(null, "Klant niet gevonden", "InfoBox: " , JOptionPane.INFORMATION_MESSAGE);
	    			}
	    			else {
	    				JOptionPane.showMessageDialog(null, "Klant gevonden", "InfoBox: " , JOptionPane.INFORMATION_MESSAGE);
	    			}
	    			try {
						if (IOWriter.writeReservatie(nieuwe) == true) {
							WinkelPanel.getModel().addRow(new Object[]{WinkelPanel.getCbType(), WinkelPanel.getTxtUitleningTitel(), 
									WinkelPanel.getTxtUitleningDagen()});
							KlantPanel.getModel().addRow(new Object[]{WinkelPanel.getCbType(), WinkelPanel.getTxtUitleningTitel(), 
									WinkelPanel.getTxtUitleningDagen()});
							klantPaneel.setjlKlantNaamInput();
							
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
	}
	
	class btnUitleningVerwijderListener implements ActionListener{
		 public void actionPerformed(ActionEvent e) {
			 		 
		 }
	}
	
	class btnUitleningKlantListener implements ActionListener{
		 public void actionPerformed(ActionEvent e) {
			 for (int i = 0; i < Reservatie.haalReservatiesOp(WinkelPanel.getTxtKlantNaam(), WinkelPanel.getTxtKlantVoornaam()).size(); i++){
	    			char lijn1 = Reservatie.haalReservatiesOp(WinkelPanel.getTxtKlantNaam(), 
	    					WinkelPanel.getTxtKlantVoornaam()).get(i).getItem().getType();
	    			String lijn2 = Reservatie.haalReservatiesOp(WinkelPanel.getTxtKlantNaam(), 
	    					WinkelPanel.getTxtKlantVoornaam()).get(i).getItem().getTitel();
	    			int lijn3 = Reservatie.haalReservatiesOp(WinkelPanel.getTxtKlantNaam(), WinkelPanel.getTxtKlantVoornaam()).get(i).getAatalDagen();
	    			Object[] rowData = { lijn1, lijn2, lijn3 };
	    			WinkelPanel.getModel().addRow(rowData);
	    			KlantPanel.getModel().addRow(rowData);
	    		}		 
		 }
	}
	
	class btnLijstVanAlleListener implements ActionListener{
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
	}
	//
	class btnZoekIDListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
				
				StringBuilder result = new StringBuilder();
				for (Klant k : Klanten)
				{
					if (k.getNaam().equals(WinkelPanel.getKlantNaam()))
					{
						result.append("\n"+ k.getKlantID() + ":"+
					k.getVoornaam() + " " + k.getNaam() + " "+ k.getEmail());
					}
				}
				JOptionPane.showMessageDialog(null, result.toString(), "GEVONDEN" , JOptionPane.INFORMATION_MESSAGE);
		
			
		}
	}
	
	class btnKlantInschrijvenListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			try
			{
				WinkelPanel.getID();

			int ID = WinkelPanel.getID();
			Boolean gevonden = false;
			for (Klant k: Klanten)
				
			{
				if (k.getKlantID() == ID && k.getIsObserver() == 0)
				{
					addObserver(k);
					k.setIsObserver(1);
					
					JOptionPane.showMessageDialog(null, "Deze is nu ingeschreven.", "OK" , JOptionPane.INFORMATION_MESSAGE);
					gevonden = true;
				}
				
				if (k.getKlantID() == ID && k.getIsObserver() == 1 && gevonden == false)
				{
					
					JOptionPane.showMessageDialog(null, "Deze was al ingeschreven.", "OK" , JOptionPane.INFORMATION_MESSAGE);
					gevonden = true;
				}
			}
			if (gevonden == false)
			{
				JOptionPane.showMessageDialog(null, "Klant niet gevonden", "NOK" , JOptionPane.INFORMATION_MESSAGE);
			}
			}
			catch (Exception e1)
			{
				JOptionPane.showMessageDialog(null, "Gelieve een getal in te geven", "PAS OP" , JOptionPane.INFORMATION_MESSAGE);
			}
		}
	}
	
	class btnKlantUitschrijvenListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			try
			{

			
			int ID = WinkelPanel.getID();
			Boolean gevonden = false;
			
			for (Klant k: Klanten)
				
			{
				if (k.getKlantID() == ID && k.getIsObserver() == 1)
				{
					removeObserver(k);
					k.setIsObserver(0);
				
					JOptionPane.showMessageDialog(null, "Deze is nu uitgeschreven.", "OK" , JOptionPane.INFORMATION_MESSAGE);
					gevonden = true;
				}
				
				if (k.getKlantID() == ID && k.getIsObserver() == 0 && gevonden == false)
				{
					
					JOptionPane.showMessageDialog(null, "Deze was niet ingeschreven.", "OK" , JOptionPane.INFORMATION_MESSAGE);
					gevonden = true;
				}
			}
			if (gevonden == false)
			{
				JOptionPane.showMessageDialog(null, "Klant niet gevonden", "NOK" , JOptionPane.INFORMATION_MESSAGE);
			}
			}
			catch (Exception e1)
			{
				JOptionPane.showMessageDialog(null, "Gelieve een getal in te geven", "PAS OP" , JOptionPane.INFORMATION_MESSAGE);
			}
		}
		}
	
	
	class btnZoekItemsListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			try {
				IOReader.refreshItems();
				StringBuilder alleItems = new StringBuilder();
				alleItems.append("---MOVIES---\n");
				List<String> movies = new ArrayList<>();
				for (Map.Entry<String, String> entry : IOReader.getMovies().entrySet())
				{
					if ((entry.getValue().replaceAll(Pattern.quote("+")," ")).toLowerCase().contains((WinkelPanel.getZoekText()).toLowerCase()))
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
					if ((entry.getValue().replaceAll(Pattern.quote("+")," ")).toLowerCase().contains((WinkelPanel.getZoekText()).toLowerCase()))
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
					if ((entry.getValue().replaceAll(Pattern.quote("+")," ")).toLowerCase().contains((WinkelPanel.getZoekText()).toLowerCase()))
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
	}

}
