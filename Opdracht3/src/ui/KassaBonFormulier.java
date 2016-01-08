package ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JLabel;
import javax.swing.JCheckBox;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;

public class KassaBonFormulier extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	String[] writeOpties = {"txt", "excel", "sql"};
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					KassaBonFormulier frame = new KassaBonFormulier();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public KassaBonFormulier() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 534);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new FormLayout(new ColumnSpec[] {
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,},
			new RowSpec[] {
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,}));
		
		JLabel lblKiesHierJe = new JLabel("Kies hier je header instellingen:");
		contentPane.add(lblKiesHierJe, "4, 2");
		
		JCheckBox chckbxKassabonnummer = new JCheckBox("Kassabonnummer");
		contentPane.add(chckbxKassabonnummer, "4, 4");
		
		JCheckBox chckbxDatumUitlening = new JCheckBox("Datum uitlening");
		contentPane.add(chckbxDatumUitlening, "4, 6");
		
		JCheckBox chckbxTijdstipUitlening = new JCheckBox("Tijdstip uitlening");
		contentPane.add(chckbxTijdstipUitlening, "4, 8");
		
		JCheckBox chckbxOpeningsurenWinkel = new JCheckBox("Openingsuren winkel");
		contentPane.add(chckbxOpeningsurenWinkel, "4, 10");
		
		JLabel lblBody = new JLabel("Body:");
		contentPane.add(lblBody, "4, 14");
		
		textField = new JTextField();
		contentPane.add(textField, "4, 16, 1, 3, fill, default");
		textField.setColumns(10);
		
		JLabel lblKiesHierJe_1 = new JLabel("Kies hier je footerinstellingen");
		contentPane.add(lblKiesHierJe_1, "4, 22");
		
		JCheckBox chckbxUitleentotaal = new JCheckBox("Uitleentotaal + BTW");
		contentPane.add(chckbxUitleentotaal, "4, 24");
		
		JCheckBox chckbxWinkelboodschap = new JCheckBox("Winkelboodschap");
		contentPane.add(chckbxWinkelboodschap, "4, 26");
		
		JCheckBox chckbxVasteBoodschap = new JCheckBox("Vaste boodschap");
		contentPane.add(chckbxVasteBoodschap, "4, 28");
		
		JButton btnDrukKassabon = new JButton("Druk kassabon");
		btnDrukKassabon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		contentPane.add(btnDrukKassabon, "4, 36");
	}

}
