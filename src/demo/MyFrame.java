package demo;

import java.awt.Color;
import javax.swing.JFrame;


//JFrame = GUI prozor u kom se smestaju komponente
public class MyFrame extends JFrame{
	
	MyFrame(){
		
		this.setTitle("Moja prva aplikacija"); //postavljanje naslova
		this.setSize(500,500); //postavljanje x i y dimenzija
		this.setVisible(true); //postavljanje vidljivosti 
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //izadji iz aplikacije
		this.setResizable(false); //zabrana promene velicine prozora
		this.getContentPane().setBackground(new Color(123,50,250)); //promena boje pozadine prozora - unosenjem RGB vrednosti
		
	}

}
