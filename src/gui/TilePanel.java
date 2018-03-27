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
	
	public Tile getTile() {
		return tile;
	}

	
	public void setTileImage() {
		Image image = null;
		String imagePath = "assets/tiles/";
		int imageNumber = Map_Settings.generateRand(1,3);
		imagePath+=tile.getBiome().getBiomeType();
		if(tile.isObstacle()) imagePath+="_Obstacle";
		imagePath+="_"+imageNumber+".jpg";
		image = Toolkit.getDefaultToolkit().getImage(imagePath);
		//System.out.println(imagePath+"\n");
		tileImage = image;
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		//safe color map, if we can't find the images
		g.setColor(tile.getBiome().getColor());
		//fill the panel with biome colors
		g.fillRect(0,0, Map_Settings.CASE_WIDTH, Map_Settings.CASE_WIDTH);
		//define the image of the tile and draw it in the panel
		this.setBeastImage(beastImage);
		g.drawImage(tileImage, 0, 0, this);
		g.drawImage(beastImage, 0,0, this);
	}
	
	public void setBeastImage(Image beast) {
		beastImage = beast;
	}
	
	public void resetBeastImage() {
		beastImage = null;
	}

	
	
	

}
