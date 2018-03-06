package gui;

import data.Biome;
import data.Case;

public class CaseVisitor<Void>{
	private Case mapCase;
	
	public CaseVisitor() {
		
	}
	
	public Void visit (Case mapCase) {
		mapCase.setBiome("Plains");
		
		
		return null;
	}
	
	

}
