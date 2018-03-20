package gui;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JPanel;

import data.Tile;

public class TilePanel extends JPanel{
	
	private static final long serialVersionUID = -2031078202709262937L;
	
	private Tile tile;
	private Image tileImage = null;
	private Image beastImage = null;
	
	public TilePanel(){
		tile = new Tile();
	}
	public TilePanel(int biomeNumber) {
		tile = new Tile(biomeNumber);
	}
	public TilePanel(int biomeNumber, Boolean obstacle) {
		tile = new Tile(biomeNumber, obstacle);
	}
	
	
	public void setTile(Tile tileSet) {
		tile = tileSet;
	}
	public void setTileImage() {
		String imagePath = "assets/tiles/";
		int imageNumber = MapParameters.generateRand(1, 8);
		imagePath+=tile.getBiome().getBiomeType();
		if(tile.isObstacle()) imagePath+="_Obstacle";
		imagePath+="_"+imageNumber+".jpg";
		//System.out.println(imagePath);
		tileImage = Toolkit.getDefaultToolkit().getImage(imagePath);
	}
	public void addBeastImage(Image beast) {
		beastImage = beast;
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(tileImage, 0, 0, this);
		g.drawImage(beastImage, 0, 0, this);
	}
	
	public Tile getTile() {
		return tile;
	}
	public Image getTileImage() {
		return tileImage;
	}

	
	
	

}
