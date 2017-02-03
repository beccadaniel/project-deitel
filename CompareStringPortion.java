package Exercise2;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;

import java.awt.FlowLayout;
import java.awt.BorderLayout;

import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CompareStringPortion extends JFrame {

	private JLabel string1, string2;
	private JTextField firstString, secondString, resultTextField;
	private JButton compareButton;
	private JPanel string1Panel, string2Panel, buttonPanel, labelPanel, resultPanel;
	
	public CompareStringPortion() {
		
		super("Comparing Portions of Strings");
		setLayout(new BorderLayout());				// set JFrame layout to border layout (default layout)
		
		// creating Panels
		labelPanel = new JPanel();
		string1Panel = new JPanel();
		string2Panel = new JPanel();
		buttonPanel = new JPanel();					
		resultPanel = new JPanel();
		
		// set layout of each panel
		labelPanel.setLayout(new BorderLayout());
		string1Panel.setLayout(new FlowLayout());
		string2Panel.setLayout(new FlowLayout());
		buttonPanel.setLayout(new FlowLayout());
		resultPanel.setLayout(new FlowLayout());
		
		
		string1 = new JLabel("First string:		");				// creating labels
		string1Panel.add(string1);							// add string1 label to panel
		
		firstString = new JTextField(10);					// create a text field with 10 visible columns
		string1Panel.add(firstString);
		
		labelPanel.add(string1Panel, BorderLayout.NORTH);
		
		string2 = new JLabel("Second string:	");
		string2Panel.add(string2);
		
		secondString = new JTextField(10);
		string2Panel.add(secondString);
		
		labelPanel.add(string2Panel, BorderLayout.SOUTH);
		
		compareButton = new JButton("Compare");				// creates a button
		buttonPanel.add(compareButton);
		
		Font font = new Font("Verdana", Font.BOLD, 12);
		
		resultTextField = new JTextField("Comparism not yet made", 20);
		resultTextField.setHorizontalAlignment(JTextField.CENTER);
		resultTextField.setEditable(false);
		resultTextField.setFont(font);
		
		resultPanel.add(resultTextField);
				
		
		add(labelPanel, BorderLayout.NORTH);
		add(buttonPanel, BorderLayout.CENTER);
		add(resultPanel, BorderLayout.SOUTH);
		
		Compare handler = new Compare();
		compareButton.addActionListener(handler);
	
	}
	
	private class Compare implements ActionListener, KeyListener {
		
		public void actionPerformed( ActionEvent e) {
			
			compareStringPortion();
			
		}
		
		public void keyPressed( KeyEvent e) {
			
			if(e.getKeyCode() == KeyEvent.VK_ENTER){
				
				compareStringPortion();
			}
		}
		
		public void keyTyped(KeyEvent e){
			
		}
		
		public void keyReleased(KeyEvent e){
			
		}
		
		private void compareStringPortion(){
			
			boolean result = false;
			
			if (firstString.getText().length() == secondString.getText().length()){
				
				result = firstString.getText().regionMatches(
						true, 0, secondString.getText(), 0, firstString.getText().length());
			}
			
			if (result == true)
				resultTextField.setText("Compared strings are equal");
			else
				resultTextField.setText("Compared strings are not equal");
			
			
		}
		
	}

}