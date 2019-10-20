package com.buam.utils.swing;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Desktop;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import javax.swing.JLabel;

public class JLabelH extends JLabel {

	private String hyperLink;
	
	public JLabelH(String link) {
		super(link);
		
		hyperLink = link;
		
		setForeground(Color.BLUE.darker());
		setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
			         
			        Desktop.getDesktop().browse(new URI(hyperLink));
			         
			    } catch (IOException | URISyntaxException e1) {
			        e1.printStackTrace();
			    }
			}
		});
	}
	
}
