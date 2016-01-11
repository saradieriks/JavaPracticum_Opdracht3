package ui;

import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;



public class IOPanel extends JFrame {
	
	private JButton jbTxt;
	private JButton jbDb;
	private JButton jbExcel;
	
	public IOPanel(){
		

	    setTitle("Kies je opslagmedium");
	    setLayout(new FlowLayout()); // grootte scherm
	    
	    jbTxt = new JButton(".TXT file"); add(jbTxt);
	    jbDb = new JButton("Database"); add(jbDb);
	    jbExcel = new JButton("Excel file"); add(jbExcel);
	    
	    
	    jbTxt.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        	}
        });
	    
	}
	

	
	public void setjbTxtListener(ActionListener listenerForjbtxt){
		  jbTxt.addActionListener(listenerForjbtxt);			 
	}
	public void setjbDbListener(ActionListener listenerForjbDb){
		  jbDb.addActionListener(listenerForjbDb);			 
	}
	public void setjbExcelListener(ActionListener listenerForjbExcel){
		  jbExcel.addActionListener(listenerForjbExcel);			 
	}

}
