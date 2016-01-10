
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

import domain.Adres;
import domain.Cd;
import domain.Datum;
import domain.Film;
import domain.Item;
import domain.Klant;
import domain.Reservatie;
import domain.Spel;

public class KlantPanel extends JFrame {

	private static final long VersionUID = 1L;
    private JLabel jlKlantNaam, jlPrijs;
    private JLabel jlKlantNaamInput, jlPrijsInput, jlWhite;
    private JCheckBox cbInschrijven;
    private JTable tblUitleningen;
    private static DefaultTableModel model;
    private String[] kolomNamen = {"Type", "Titel", "Dagen"};
    
    public KlantPanel() {
	    setTitle("Uw bestelling");
	    setSize(700, 600); // grootte scherm
	    
	    

	    jlKlantNaam = new JLabel("Klant: "); jlKlantNaam.setBounds(10, 10, 50, 20); add(jlKlantNaam);
	    jlKlantNaamInput = new JLabel(" "); jlKlantNaamInput.setBounds(60, 10, 100, 20); add(jlKlantNaamInput);
	    cbInschrijven = new JCheckBox("Ik wil mij inschrijven op de nieuwe items"); cbInschrijven.setBounds(200, 10, 300, 20); add(cbInschrijven);
	    
	    jlPrijs = new JLabel("Prijs EUR: "); jlPrijs.setBounds(10, 40, 50, 20); add(jlPrijs);
	    jlPrijsInput = new JLabel("0.00"); jlPrijsInput.setBounds(60, 40, 100, 20); add(jlPrijsInput);
	    
	    
	    model = new DefaultTableModel(kolomNamen, 0);
	    tblUitleningen = new JTable(model); tblUitleningen.setBounds(20, 80, 400, 400); add(tblUitleningen);
	    Object[] rowData = { "Type", "Titel", "Aantal dagen" };
	    model.addRow(rowData);
	    
	    jlWhite = new JLabel(" "); add(jlWhite);
	    
    }
    
	public Boolean getCbInschrijven() {
		return cbInschrijven.isSelected();
	}

	public void setInschrijven(JCheckBox cbInschrijven) {
		this.cbInschrijven = cbInschrijven;
	}
	
    public String getjlKlantNaamInput() { 
		return jlKlantNaamInput.getText();
	}

	public void setjlKlantNaamInput(String klantNaam) {
		this.jlKlantNaamInput.setText(klantNaam);
	}
	public String getjlPrijsInput() { 
		return jlPrijsInput.getText();
	}

	public void setjlPrijsInput(String PrijsInput) {
		this.jlPrijsInput.setText(PrijsInput);
	}
	
	public void setcbInschrijven(ActionListener listenerForcbInschrijven) {
		cbInschrijven.addActionListener(listenerForcbInschrijven);
	}
	
	public void setModel (DefaultTableModel model) {
		this.model = model;
	}
	
	public static DefaultTableModel getModel() {
		return model;
	}

	


}
