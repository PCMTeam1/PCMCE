package fr.istic.dugl.pcmce.PCMReader;

import java.util.List;

public interface IMatrix {
	
	  public String getName();
	  
	  public void setName( String name);
	  
	  public List<ICell> getCells();
	  
	  public String getId();
	  
	  public void setId(java.lang.String id);

	  public ICell getCell(int row, int column);
	  
	  public int getNbHeaderProductColumn();
	  
	  public int getNbHeaderFeatureRows();
	  
	  public List<ICell> getHeaderProducts();

	  public List<ICell> getHeaderFeatures();
	  
	  public List<ICell> getExtras();
	  
	  public ICell[][] getTabCells();
	  
	  
	  
}
