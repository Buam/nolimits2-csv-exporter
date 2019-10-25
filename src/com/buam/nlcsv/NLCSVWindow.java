package com.buam.nlcsv;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.buam.utils.csv.CsvConfiguration;
import com.buam.utils.csv.CsvUtils;
import com.buam.utils.swing.JLabelH;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;

import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.JOptionPane;
import java.awt.Component;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.GridLayout;
import java.awt.Font;
import javax.swing.Box;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Toolkit;

public class NLCSVWindow extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4355252250723468903L;
	
	private JPanel contentPane;
	private JTextField textField;
	
	private final Action action = new SwingAction();
	private final Action action_1 = new SwingAction_1();
	
	private static CsvConfiguration csvConfig;
	private final Action action_2 = new SwingAction_2();
	private JTextField xOffsetField;
	private JTextField yOffsetField;
	private final Action action_3 = new SwingAction_3();
	
	private static HelpDialog dialog;
	private JTextField textField_1;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		dialog = new HelpDialog();
		csvConfig = new CsvConfiguration(new String[] {"No.", "PosX", "PosY", "PosZ","FrontX", "FrontY", "FrontZ","LeftX", "LeftY", "LeftZ","UpX", "UpY", "UpZ"}, '\t');
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					NLCSVWindow frame = new NLCSVWindow();
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
	public NLCSVWindow() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(NLCSVWindow.class.getResource("/assets/icon.png")));
		
		setTitle("NL2CSV by Buam v1.0");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 465, 283);
		contentPane = new JPanel();
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
		
		JButton btnChoosecsvFile = new JButton();
		btnChoosecsvFile.setAction(action_1);
		btnChoosecsvFile.setText("Choose");
		panel.add(btnChoosecsvFile);
		
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
		
		Component verticalStrut = Box.createVerticalStrut(20);
		panel_1.add(verticalStrut);
		
		JButton btnConvert = new JButton();
		panel_1.add(btnConvert);
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
		/**
		 * 
		 */
		private static final long serialVersionUID = 5143686823920778497L;
		public SwingAction() {
			putValue(NAME, "SwingAction");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
			chooseObjFile();
		}
	}
	
	private class SwingAction_1 extends AbstractAction {
		/**
		 * 
		 */
		private static final long serialVersionUID = 2487554460615519153L;
		public SwingAction_1() {
			putValue(NAME, "SwingAction_1");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
			chooseCsvFilePath();
		}
	}

	private class SwingAction_2 extends AbstractAction {
		/**
		 * 
		 */
		private static final long serialVersionUID = 3742072362546584937L;
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
			
			process(textField_1.getText(), textField.getText(), xOffset, yOffset);
		}
	}
	
	public void showErrorMessage(String message) {
		JOptionPane.showMessageDialog(this, message, "Error", JOptionPane.ERROR_MESSAGE);
	}
	

	public void chooseObjFile() {
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
	
	public void process(String path, String csvFilePath, float xOffset, float yOffset) {
		if(path.equals("")) { 
			JOptionPane.showMessageDialog(this, "Please choose a LWO-File", "Error", JOptionPane.ERROR_MESSAGE);
			return;
		} else if(csvFilePath.equals("")) {
			JOptionPane.showMessageDialog(this, "Please choose a path for the CSV-File", "Error", JOptionPane.ERROR_MESSAGE);
			return;
		}
		
		if(path.substring(path.length()-4).equals(".lwo")) {
			processLwo(path, csvFilePath, xOffset, yOffset);
		} else {
			showErrorMessage("Specified file is not a .lwo file");
			return;
		}
	}
	
	public void processLwo(String path, String csvFilePath, float xOffset, float yOffset) {
		
		final int res = 2;
		
		LWOLoader loader = new LWOLoader(path);
		List<Vector3> vertices = loader.vertices;
		
		/*System.out.println("Vertices found: ");
		for(Vector3 v : vertices) {
			System.out.println(v.getX() + " " + v.getY() + " " + v.getZ());
		}*/
		
		List<Vector3[]> spline = new ArrayList<Vector3[]>();
		
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
		
		List<List<String>> csvData = new ArrayList<List<String>>();
		
		counter = 0;
		
		for(Vector3[] node : spline) {
			/*System.out.println("Node " + (spline.indexOf(node)+1));
			System.out.println(" 1{"+node[0].getX()+" "+node[0].getY()+" "+node[0].getZ()+"}");
			System.out.println(" 2{"+node[1].getX()+" "+node[1].getY()+" "+node[1].getZ()+"}");
			System.out.println(" 3{"+node[2].getX()+" "+node[2].getY()+" "+node[2].getZ()+"}");
			System.out.println(" 4{"+node[3].getX()+" "+node[3].getY()+" "+node[3].getZ()+"}");*/
			
			if(counter == res) {
				counter = 0;
			} else {
				continue;
			}
			
			List<String> csvLine = new ArrayList<String>();
			
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
			
			counter++;
		}
		
		CsvUtils.write(csvConfig, csvData, csvFilePath);
		this.complete();
	}
	
	private String fd(String string) {
		int decimalIndex = string.indexOf('.');
		if(string.length() >= decimalIndex+6) {
			return string.substring(0, decimalIndex+5);
		}
		return string;
	}

	public Vector3 getM(Vector3 v1, Vector3 v2) {
		if(v1 == null || v2 == null) {
			return new Vector3(0f, 0f, 0f);
		}
		return new Vector3((v1.getX()+v2.getX())/2,(v1.getY()+v2.getY())/2, (v1.getZ()+v2.getZ())/2);
	}
	
	public void processObj(String path, String csvFilePath, float xOffset, float yOffset) {
		
		List<String> lines = readFile(path);
		List<Vector3> vertices = new ArrayList<Vector3>();
		for(String line : lines) {
			if(line.length()>=2) {
				char[] lineA = line.toCharArray();
				if(lineA[0] == 'v' && lineA[1] == ' ') {
					// Line is a vertex! Woohoo!!!
					
					String[] xyz = line.substring(3).split(" ");
					vertices.add(new Vector3(Float.parseFloat(xyz[0]), Float.parseFloat(xyz[1]), Float.parseFloat(xyz[2])));
				}
			}
		}
		
		List<Vector3[]> spline = new ArrayList<Vector3[]>();
		
		int counter = 0;
		Vector3[] temp = new Vector3[24];
		
		for(Vector3 vertex : vertices) {
			counter++;
			temp[counter-1] = vertex;
			
			if(counter == 24) {
				counter = 0;
				spline.add(new Vector3[] {temp[0], temp[1], temp[12], temp[11]});
				if(vertices.indexOf(vertex) == vertices.size()-1) {
					spline.add(new Vector3[] {temp[4], temp[2], temp[16], temp[10]});
				}
			}
		}
		
		List<List<String>> csvData = new ArrayList<List<String>>();
		
		for(Vector3[] node : spline) {
			/*System.out.println("Node " + (spline.indexOf(node)+1));
			System.out.println(" 1{"+node[0].getX()+" "+node[0].getY()+" "+node[0].getZ()+"}");
			System.out.println(" 2{"+node[1].getX()+" "+node[1].getY()+" "+node[1].getZ()+"}");
			System.out.println(" 3{"+node[2].getX()+" "+node[2].getY()+" "+node[2].getZ()+"}");
			System.out.println(" 4{"+node[3].getX()+" "+node[3].getY()+" "+node[3].getZ()+"}");*/
			
			List<String> csvLine = new ArrayList<String>();
			
			Vector3 pos = Vector3.getMiddleValue(node);
			Vector3 left = Vector3.getLeftVector(node, pos);
			Vector3 up = Vector3.getUpVector(node, pos);
			
			pos = new Vector3((pos.getX() + left.getX()*xOffset), (pos.getY() + left.getY()*xOffset), (pos.getZ() + left.getZ()*xOffset));
			pos = new Vector3((pos.getX() + up.getX()*yOffset), (pos.getY() + up.getY()*yOffset), (pos.getZ() + up.getZ()*yOffset));
			
			// No.
			csvLine.add(Integer.toString(spline.indexOf(node) + 1));
			// PosX
			csvLine.add(Float.toString(pos.getX()));
			// PosY
			csvLine.add(Float.toString(pos.getY()));
			// PosZ
			csvLine.add(Float.toString(pos.getZ()));
			// FrontX
			csvLine.add("0");
			// FrontY
			csvLine.add("0");
			// FrontZ
			csvLine.add("0");
			// LeftX
			csvLine.add(Float.toString(left.getX()));
			// LeftY
			csvLine.add(Float.toString(left.getY()));
			// LeftZ
			csvLine.add(Float.toString(left.getZ()));
			// UpX
			csvLine.add(Float.toString(up.getX()));
			// UpY
			csvLine.add(Float.toString(up.getY()));
			// UpZ
			csvLine.add(Float.toString(up.getZ()));
			
			csvData.add(csvLine);
		}
		
		CsvUtils.write(csvConfig, csvData, csvFilePath);
		this.complete();
	}
	
	

	public static List<String> readFile(String path) {
		List<String> lines = new ArrayList<String>();
		try {
			BufferedReader reader = new BufferedReader(new FileReader(new File(path)));
			String line;
			while((line = reader.readLine()) != null) {
				lines.add(line);
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return lines;
	}
	
	public static String read(String text) {
        System.out.print(text);
        return System.console().readLine();
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
