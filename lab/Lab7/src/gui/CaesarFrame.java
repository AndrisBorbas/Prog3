package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import code.CaesarCode;

public class CaesarFrame extends JFrame {

	private JTextField textFieldInput;
	private JTextField textFieldOutput;
	private JButton button;
	private JComboBox comboBox;

	private boolean decode = false;

	public CaesarFrame() {
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setTitle("SwingLab");
		this.setSize(400, 110);
		this.setResizable(false);

		JPanel panelTop = new JPanel(new FlowLayout());
		JPanel panelBottom = new JPanel(new BorderLayout());
		GridLayout layout = new GridLayout();
		textFieldInput = new JTextField(20);
		textFieldOutput = new JTextField(20);
		button = new JButton();

		layout.setRows(2);
		layout.setColumns(1);
		this.setLayout(layout);

		Object chars[] = new Object[26];
		for (int i = (int) 'A'; i <= (int) 'Z'; i++)
			chars[i - (int) 'A'] = (char) i;
		comboBox = new JComboBox(chars);
		panelTop.add(comboBox);
		textFieldInput.setEnabled(true);
		textFieldInput.addFocusListener(new FocusLoseListener(false));
		textFieldInput.getDocument().addDocumentListener(new InputFieldKeyListener());
		panelTop.add(textFieldInput);
		button.setText("Code!");
		button.addActionListener(new OkButtonActionListener());
		panelTop.add(button);

		panelBottom.add(new JLabel("Output:"), BorderLayout.WEST);
		textFieldOutput.addFocusListener(new FocusLoseListener(true));
		panelBottom.add(textFieldOutput);

		this.add(panelTop);
		this.add(panelBottom);
	}

	private class OkButtonActionListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			if (decode) textFieldInput.setText(CaesarCode.caesarDeCode(textFieldOutput.getText(), (char) (comboBox.getSelectedItem())));
			else textFieldOutput.setText(CaesarCode.caesarCode(textFieldInput.getText(), (char) (comboBox.getSelectedItem())));
		}

	}

	private class FocusLoseListener implements FocusListener {
		private boolean dir;

		public FocusLoseListener(boolean b) {
			dir = b;
		}

		public void focusGained(FocusEvent fe) {
		}

		public void focusLost(FocusEvent fe) {
			decode = dir;
		}

	}

	private class InputFieldKeyListener implements DocumentListener {

		public void insertUpdate(DocumentEvent e) {
			textFieldOutput
					.setText(CaesarCode.caesarCode(textFieldInput.getText(), (char) (comboBox.getSelectedItem())));
		}

		public void removeUpdate(DocumentEvent e) {
			textFieldOutput
					.setText(CaesarCode.caesarCode(textFieldInput.getText(), (char) (comboBox.getSelectedItem())));
		}

		public void changedUpdate(DocumentEvent e) {
			textFieldOutput
					.setText(CaesarCode.caesarCode(textFieldInput.getText(), (char) (comboBox.getSelectedItem())));
		}
	}

}
