package demo;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Main {
	public static void main(String[] args) {
		
		//JPanel =  GUI komponenta koja funkcionise kao kontejner koji sadrzi druge komponente; nalazi se u JFrame-u i sluzi kako bi kreirala sekcije povrsine
		JPanel redPanel = new JPanel();
		redPanel.setBackground(Color.red);
		redPanel.setBounds(0,0,150,150);
		
		JPanel bluePanel = new JPanel();
		bluePanel.setBackground(Color.blue);
		bluePanel.setBounds(150,0,150,150);
		
		JPanel greenPanel = new JPanel();
		greenPanel.setBackground(Color.green);
		greenPanel.setBounds(0,150,300,250);
		greenPanel.setLayout(new BorderLayout()); //raspored komponenti unutar kontejnera
		
		//JLabel = GUI komponenta tj deo povrsine koji je rezervisan za tekst, sliku ili oba
		JLabel label = new JLabel();
		label.setText("Hello World");
		ImageIcon icon = new ImageIcon("src\\demo\\robot.png");
		label.setIcon(icon);
		label.setVerticalAlignment(JLabel.TOP); //pomeramo JLabel do vrha kontejnera u kom je smestena
		
		MyFrame myFrame = new MyFrame();
		myFrame.setLayout(null); //Apsolutno pozicioniranje
		myFrame.add(redPanel);
		myFrame.add(bluePanel);
		myFrame.add(greenPanel);
		greenPanel.add(label);

		
	}

}
