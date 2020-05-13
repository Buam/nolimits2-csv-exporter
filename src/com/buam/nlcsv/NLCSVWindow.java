package com.buam.nlcsv;

import com.buam.utils.csv.CsvConfiguration;
import com.buam.utils.csv.CsvUtils;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class NLCSVWindow extends JFrame {

	private JTextField textField;

	private static CsvConfiguration csvConfig;
	private JTextField xOffsetField;
	private JTextField yOffsetField;
	private JTextField skipVerticesField;

	private static HelpDialog dialog;
	private JTextField textField_1;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		dialog = new HelpDialog();
		csvConfig = new CsvConfiguration(new String[] {"No.", "PosX", "PosY", "PosZ","FrontX", "FrontY", "FrontZ","LeftX", "LeftY", "LeftZ","UpX", "UpY", "UpZ"}, '\t');
		EventQueue.invokeLater(() -> {
			try {
				UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
				NLCSVWindow frame = new NLCSVWindow();
				frame.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public NLCSVWindow() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(NLCSVWindow.class.getResource("/assets/icon.png")));
		
		setTitle("NoLimits Track to CSV Converter");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 465, 300);
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setResizable(false);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblCsvFile = new JLabel("CSV File:");
		panel.add(lblCsvFile);
		
		textField = new JTextField();
		textField.setToolTipText("File name");
		panel.add(textField);
		textField.setColumns(26);
		
		JButton btnChooseCsvFile = new JButton();
		Action action_1 = new SwingAction_1();
		btnChooseCsvFile.setAction(action_1);
		btnChooseCsvFile.setText("Choose");
		panel.add(btnChooseCsvFile);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.SOUTH);
		panel_1.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel lblNewLabel = new JLabel("Settings");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(lblNewLabel);
		
		JPanel panel_2 = new JPanel();
		panel_1.add(panel_2);
		
		JLabel lblXoffset = new JLabel("X-Offset:");
		panel_2.add(lblXoffset);
		
		xOffsetField = new JTextField();
		xOffsetField.setHorizontalAlignment(SwingConstants.RIGHT);
		xOffsetField.setText("0");
		panel_2.add(xOffsetField);
		xOffsetField.setColumns(5);

		JLabel lblYoffset = new JLabel("Y-Offset:");
		panel_2.add(lblYoffset);
		
		yOffsetField = new JTextField();
		panel_2.add(yOffsetField);
		yOffsetField.setText("0");
		yOffsetField.setHorizontalAlignment(SwingConstants.RIGHT);
		yOffsetField.setColumns(5);

		JPanel panel_7= new JPanel();
		panel_1.add(panel_7);

		JLabel lblSkipVertices = new JLabel("Skip Vertices:");
		panel_7.add(lblSkipVertices);

		skipVerticesField = new JTextField();
		panel_7.add(skipVerticesField);
		skipVerticesField.setText("0");
		skipVerticesField.setHorizontalAlignment(SwingConstants.RIGHT);
		skipVerticesField.setColumns(5);

		Component verticalStrut = Box.createVerticalStrut(20);
		panel_1.add(verticalStrut);
		
		JButton btnConvert = new JButton();
		panel_1.add(btnConvert);
		Action action_2 = new SwingAction_2();
		btnConvert.setAction(action_2);
		btnConvert.setText("Convert");
		
		JPanel panel_3 = new JPanel();
		contentPane.add(panel_3, BorderLayout.NORTH);
		panel_3.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_4 = new JPanel();
		panel_3.add(panel_4, BorderLayout.NORTH);
		panel_4.setLayout(new BorderLayout(0, 0));
		
		JButton helpBtn = new JButton("?");
		helpBtn.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_4.add(helpBtn, BorderLayout.EAST);
		Action action_3 = new SwingAction_3();
		helpBtn.setAction(action_3);
		
		JPanel panel_6 = new JPanel();
		panel_3.add(panel_6, BorderLayout.SOUTH);
		panel_6.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel_1 = new JLabel("Light Pattern Creator File (.lwo):");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel_6.add(lblNewLabel_1, BorderLayout.NORTH);
		
		JPanel panel_5 = new JPanel();
		panel_6.add(panel_5, BorderLayout.SOUTH);
		
		textField_1 = new JTextField();
		panel_5.add(textField_1);
		textField_1.setColumns(32);
		
		JButton btnChooseobjFile = new JButton();
		panel_5.add(btnChooseobjFile);
		Action action = new SwingAction();
		btnChooseobjFile.setAction(action);
		btnChooseobjFile.setText("Choose");
		
		//setActions(btnChoosecsvFile, btnConvert, btnChooseobjFile, this);
		
		/*btnChoosecsvFile.setAction(new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {
				main.chooseCsvFilePath(instance);
			}
		});
		btnConvert.setAction(new AbstractAction() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(!textField.getText().equals("")) {
					main.process(textField.getText(), instanceWindow);
				} else {
					JOptionPane.showMessageDialog(instance, "Please choose a CSV filename", "Error", JOptionPane.ERROR_MESSAGE);
				}
				
			}
			
		});
		btnChooseobjFile.setAction(new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {
				main.chooseObjFile(instance);
			}
		});*/
	}

	public void complete() {
		JOptionPane.showMessageDialog(this, "LWO-File successfully converted to NL2 CSV!");
	}

	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "SwingAction");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
			chooseLwoFile();
		}
	}
	
	private class SwingAction_1 extends AbstractAction {
		public SwingAction_1() {
			putValue(NAME, "SwingAction_1");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
			chooseCsvFilePath();
		}
	}

	private class SwingAction_2 extends AbstractAction {
		public SwingAction_2() {
			putValue(NAME, "SwingAction_2");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
			float xOffset = 0f;
			try {
				xOffset = Float.parseFloat(xOffsetField.getText());
			} catch(NumberFormatException nfe) {
				showErrorMessage("X-Offset: Invalid number (Examples: 0, 0.0, 1.5 ...)");
				return;
			}
			float yOffset = 0f;
			try {
				yOffset = Float.parseFloat(yOffsetField.getText());
			} catch(NumberFormatException nfe) {
				showErrorMessage("Y-Offset: Invalid number (Examples: 0, 0.0, 1.5 ...)");
				return;
			}
			int skipVertices = 0;
			try {
				skipVertices = Integer.parseInt(skipVerticesField.getText());
			} catch(NumberFormatException nfe) {
				showErrorMessage("Skip Vertices: Invalid number (Examples: 0, 1, 2 ...)");
				return;
			}
			process(textField_1.getText(), textField.getText(), xOffset, yOffset, skipVertices);
		}
	}
	
	public void showErrorMessage(String message) {
		JOptionPane.showMessageDialog(this, message, "Error", JOptionPane.ERROR_MESSAGE);
	}
	

	public void chooseLwoFile() {
		JFileChooser pathChooser = new JFileChooser();
		FileNameExtensionFilter objFilter = new FileNameExtensionFilter("LightWave-Object File", "lwo");
		pathChooser.setFileFilter(objFilter);
		int returnVal = pathChooser.showOpenDialog(this);
		if(returnVal == JFileChooser.APPROVE_OPTION) {
			textField_1.setText(pathChooser.getSelectedFile().getAbsolutePath());
		}
	}
	
	public void chooseCsvFilePath() {
		JFileChooser csvChooser = new JFileChooser();
		FileNameExtensionFilter csvFilter = new FileNameExtensionFilter("Comma-Seperated-Values File (csv)", "csv");
		csvChooser.setFileFilter(csvFilter);
		int returnVal = csvChooser.showOpenDialog(this);
		if(returnVal == JFileChooser.APPROVE_OPTION) {
			String csvPath = csvChooser.getSelectedFile().getAbsolutePath();
			if(!csvPath.substring(csvPath.length()-4).equals(".csv")) csvPath += ".csv";
				
			textField.setText(csvPath);
		}
	}
	
	public void process(String path, String csvFilePath, float xOffset, float yOffset, int skipVertices) {
		if(path.equals("")) { 
			JOptionPane.showMessageDialog(this, "Please choose an LWO-File", "Error", JOptionPane.ERROR_MESSAGE);
			return;
		} else if(csvFilePath.equals("")) {
			JOptionPane.showMessageDialog(this, "Please choose a path for the CSV-File", "Error", JOptionPane.ERROR_MESSAGE);
			return;
		}
		
		if(path.substring(path.length()-4).equals(".lwo")) {
			processLwo(path, csvFilePath, xOffset, yOffset, skipVertices);
		} else {
			showErrorMessage("Specified file is not a .lwo file");
		}
	}
	
	public void processLwo(String path, String csvFilePath, float xOffset, float yOffset, int skipVertices) {
		
		LWOLoader loader = new LWOLoader(path, this);
		List<Vector3> vertices = loader.vertices;
		
		List<Vector3[]> spline = new ArrayList<>();
		
		int counter = 0;
		Vector3[] temp = new Vector3[8];
		
		for(Vector3 vertex : vertices) {
			counter++;
			temp[counter-1] = vertex;
			
			if(counter == 8) {
				counter = 0;
				spline.add(new Vector3[] {temp[1], temp[0], temp[5], temp[3]});
			}
		}
		if(skipVertices != 0) {
			List<Vector3[]> toRemove = new ArrayList<>();
			for(int i = 0; i < spline.size(); i++) {
				if(i % (skipVertices + 1) != 0) {
					toRemove.add(spline.get(i));
				}
			}
			for(Vector3[] vertex : toRemove) {
				spline.remove(vertex);
			}
		}
		
		List<List<String>> csvData = new ArrayList<>();
		
		for(Vector3[] node : spline) {
			/*System.out.println("Node " + (spline.indexOf(node)+1));
			System.out.println(" 1{"+node[0].getX()+" "+node[0].getY()+" "+node[0].getZ()+"}");
			System.out.println(" 2{"+node[1].getX()+" "+node[1].getY()+" "+node[1].getZ()+"}");
			System.out.println(" 3{"+node[2].getX()+" "+node[2].getY()+" "+node[2].getZ()+"}");
			System.out.println(" 4{"+node[3].getX()+" "+node[3].getY()+" "+node[3].getZ()+"}");*/
			
			List<String> csvLine = new ArrayList<>();
			
			Vector3 pos = Vector3.getMiddleValue(node);
			Vector3 left = Vector3.getLeftVector(node, pos);
			Vector3 up = Vector3.getUpVector(node, pos);
			
			pos = new Vector3((pos.getX() + left.getX()*xOffset), (pos.getY() + left.getY()*xOffset), (pos.getZ() + left.getZ()*xOffset));
			pos = new Vector3((pos.getX() + up.getX()*yOffset), (pos.getY() + up.getY()*yOffset), (pos.getZ() + up.getZ()*yOffset));
			
			// No.
			csvLine.add(Integer.toString(spline.indexOf(node) + 1));
			// PosX
			csvLine.add(fd(Float.toString(pos.getX())));
			// PosY
			csvLine.add(fd(Float.toString(pos.getY())));
			// PosZ
			csvLine.add(fd(Float.toString(pos.getZ())));
			// FrontX
			csvLine.add("0");
			// FrontY
			csvLine.add("0");
			// FrontZ
			csvLine.add("0");
			// LeftX
			csvLine.add(fd(Float.toString(left.getX())));
			// LeftY
			csvLine.add(fd(Float.toString(left.getY())));
			// LeftZ
			csvLine.add(fd(Float.toString(left.getZ())));
			// UpX
			csvLine.add(fd(Float.toString(up.getX())));
			// UpY
			csvLine.add(fd(Float.toString(up.getY())));
			// UpZ
			csvLine.add(fd(Float.toString(up.getZ())));
			
			csvData.add(csvLine);
		}
		
		CsvUtils.write(csvConfig, csvData, csvFilePath);
		this.complete();
	}
	
	private String fd(String string) {
		int decimalIndex = string.indexOf('.');
		if(string.length() >= decimalIndex + 6) {
			return string.substring(0, decimalIndex + 5);
		}
		return string;
	}

	private class SwingAction_3 extends AbstractAction {
		public SwingAction_3() {
			putValue(NAME, "?");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
			dialog.setVisible(true);
		}
	}
}
