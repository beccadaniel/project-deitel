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
		
		resultTextField = new JTextField("Comparism not yet made");
		resultTextField.setHorizontalAlignment(JTextField.CENTER);
		resultTextField.setEditable(false);
		
		resultPanel.add(resultTextField);
				
		
		add(labelPanel, BorderLayout.NORTH);
		add(buttonPanel, BorderLayout.CENTER);
		add(resultPanel, BorderLayout.SOUTH);
		
		Compare handler = new Compare();
		compareButton.addActionListener(handler);
		compareButton.addKeyListener(handler);
				
	}
	
	private class Compare implements ActionListener, KeyListener {
		
		public void actionPerformed( ActionEvent e) {
			
			compareString();
			
		}
		
		public void keyPressed( KeyEvent e) {
			
			if(e.getKeyCode() == KeyEvent.VK_ENTER){
				
				compareString();
			}
		}
		
		public void keyTyped(KeyEvent e){
			
		}
		
		public void keyReleased(KeyEvent e){
			
		}
		
		private void compareString(){
			
			int result = firstString.getText().compareTo(secondString.getText());
			
			if (firstString.getText().equals("") && secondString.getText().equals(""))
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