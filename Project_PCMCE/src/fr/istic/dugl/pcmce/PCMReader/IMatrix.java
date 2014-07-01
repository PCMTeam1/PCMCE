package fr.istic.dugl.pcmce.PCMReader;

import java.util.List;

public interface IMatrix {
	
	  public String getName();
	  
	  public void setName( String name);
	  
	  public int getId();
	  
	  public void setId(int id);

	  public int getNbRows();
	  
	  public int getNbColumn();
	  
	  public ICell getCell(int row, int column);
	  
	  public int getNbHeaderProductColumn();
	  
	  public int getNbHeaderFeatureRows();
	  
	  public List<ICell> getListAllCells();
	  public ICell[][] getTabAllCells();
	  
	  public List<ICell> getListValuedCells();
	  public ICell[][] getTabValuedCells();
	  
	  public List<ICell> getListHeaderProductCells();
	  public ICell[][] getTabHeaderProductCells();

	  public List<ICell> getHeaderFeatureCells();
	  public ICell[][] getTabHeaderFeatureCells();
	  
	  public List<ICell> getListExtraCells();
	  public ICell[][] getTabExtraCells();

	  
	  
	  
}
