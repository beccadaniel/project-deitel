import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.FlowLayout;
import java.awt.BorderLayout;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class CompareString extends JFrame{
	
	private JLabel string1, string2;
	private JTextField firstString, secondString, resultTextField;
	private JButton compareButton;
	private JPanel string1Panel, string2Panel, buttonPanel, labelPanel, resultPanel;
	
	public CompareString() {		
		
		super("Comparing Strings");
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
		
		firstString = new JTextField(10);				// create a text field with 10 visible columns
		string1Panel.add(firstString);
		
		labelPanel.add(string1Panel, BorderLayout.NORTH);	// adds string1Panel to the northern part of the label panel
		
		string2 = new JLabel("Second string:	");		// create second label
		string2Panel.add(string2);				// add label to panel
		
		secondString = new JTextField(10);			// creates a text field for the label
		string2Panel.add(secondString);				// adds text field to panel
		
		labelPanel.add(string2Panel, BorderLayout.SOUTH);	// adds string2Panel to the southern part of the label panel
		
		compareButton = new JButton("Compare");				// creates a button with the text "Compare"
		buttonPanel.add(compareButton);				// adds button to a panel
		
		resultTextField = new JTextField("Comparism not yet made");	// create a textfield to show result of operation
		resultTextField.setHorizontalAlignment(JTextField.CENTER);
		resultTextField.setEditable(false);				// makes textfield uneditable by user
		
		resultPanel.add(resultTextField);			// adds textfield to panel
				
		// add the created panels to JFrame
		add(labelPanel, BorderLayout.NORTH);
		add(buttonPanel, BorderLayout.CENTER);
		add(resultPanel, BorderLayout.SOUTH);
		
		// registers listeners for button
		Compare handler = new Compare();
		compareButton.addActionListener(handler);
		compareButton.addKeyListener(handler);
				
	}	//end of CompareString constructor
	
	// An inner private class for event handling
	private class Compare implements ActionListener, KeyListener {
		
		// responds to button event, i.e when button is clicked
		public void actionPerformed( ActionEvent e) {
			
			compareString();
			
		}
		
		// responds to key event, i.e when the enter key is pressed this method responds
		public void keyPressed( KeyEvent e) {
			
			if(e.getKeyCode() == KeyEvent.VK_ENTER){
				
				compareString();
			}
		}
		
		public void keyTyped(KeyEvent e){
			
		}
		
		public void keyReleased(KeyEvent e){
			
		}
		
		/*
		 * This method gets strings from the textField and uses the method 
		 * compareTo() to compare if two strings gotten from the text field are 
		 * equal,  or otherwise.
		 * OUTPUT
		 * It prints out to a textfield whether the strings compared are equal or not.
		 * If no strings are gotten from the textFields, it prints out the statement 
		 * "No strings entered".
		 */
		private void compareString(){
			
			int result = firstString.getText().compareTo(secondString.getText());	// compares two strings
			
			if (firstString.getText().equals("") && secondString.getText().equals(""))	// check if string is gotten from the textField or not
				result = 2;
			
			if (result == 0)
				resultTextField.setText(firstString.getText() + " is equal to " + secondString.getText());
			else if (result == 1)
				resultTextField.setText(firstString.getText() + " is greater than " + secondString.getText());
			else if (result == -1)
				resultTextField.setText(firstString.getText() + " is less than " + secondString.getText());
			else
				resultTextField.setText("No strings entered");
		}
		
	}

}
