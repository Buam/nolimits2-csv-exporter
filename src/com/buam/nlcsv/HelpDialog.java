package com.buam.nlcsv;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import java.awt.Font;
import javax.swing.BoxLayout;
import java.awt.CardLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Insets;
import javax.swing.JTextPane;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import javax.swing.Action;
import java.awt.Toolkit;

public class HelpDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private final Action action = new SwingAction();

	/**
	 * Create the dialog.
	 */
	public HelpDialog() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(HelpDialog.class.getResource("/assets/icon.png")));
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
		setTitle("Help");
		setBounds(100, 100, 450, 312);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JTextPane txtpnHi = new JTextPane();
			txtpnHi.setContentType("text/html");
			txtpnHi.setText("<html><body style=\"margin: 0\"><ol><li>Export your coaster with the Light Pattern Creator:</li><ol><li>Tick \"Generate SCO\", \"T\", \"B\", \"L\" and \"R\".</li><li>Leave the X and Y Offset at 0 and use any values you want for Width and Height.</li><li>Give your file a prefix and hit \"Generate\".</li></ol><li>Choose the LWO-File the Light Pattern Creator generated.</li><li>Specify the path for the CSV-File to be generated.</li><li>Specify the X and Y-Offsets (if you want a left rail, for example: X-Offset goes left, Y-Offset goes up)</li><li>Hit \"Convert\"</li></ol></body></html>");
			contentPanel.add(txtpnHi, BorderLayout.NORTH);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton cancelButton = new JButton("Close");
				cancelButton.setAction(action);
				cancelButton.setText("Close");
				buttonPane.add(cancelButton);
			}
		}
	}

	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "SwingAction");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
			setVisible(false);
		}
	}
}
