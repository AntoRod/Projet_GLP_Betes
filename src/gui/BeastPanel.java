package gui;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JPanel;

import data.Beast;
import data.Biome;

public class BeastPanel extends JPanel{
	
	private static final long serialVersionUID = -3253071850484805893L;
	
	private Beast beast;
	private Image beastImage;
	
	public BeastPanel(){
		beast = new Beast();
		beastImage = null;
	}
	public BeastPanel(Beast newBeast){
		beast = newBeast;
		beastImage = null;
	}
	public BeastPanel(Beast newBeast , Biome newBiome){
		beast = newBeast;
		beastImage = null ;
		beast.setBiome(newBiome);
	}
	public void setBeast(Beast beastSet) {
		beast = beastSet;
	}
	
	/*public void setBeastImage() {
		beastImage = Toolkit.getDefaultToolkit().getImage("assets/beasts/female_Plains_down.png");

	}*/
	
	public void setBeastImage() {
		String imagePath = "assets/beasts/";
		imagePath+=beast.getSexe()+"_";
		imagePath+=beast.getBiome().getBiomeType()+"_";
		imagePath+=beast.getOrientation()+".png";
		beastImage = Toolkit.getDefaultToolkit().getImage(imagePath);
		//System.out.println(imagePath);
	}

	
	public Beast getBeast() {
		return beast;
	}
	
	public Image getBeastImage() {
		return beastImage;
	}

	
	
}
