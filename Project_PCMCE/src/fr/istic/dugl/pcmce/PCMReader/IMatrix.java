/**
 * @author Yves Le Monnier
 *
 */

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
	  
	  public int getNbHeaderProductRow();
	  public int getNbHeaderProductColumn();
	  
	  public int getNbHeaderFeatureRows();
	  public int getNbHeaderFeatureColumn();
	  
	  public List<ICell> getListAllCells();
	  public ICell[][] getTabAllCells();
	  
	  public List<ICell> getListValuedCells();
	  public ICell[][] getTabValuedCells();
	  
	  public List<ICell> getListHeaderProductCells();
	  public ICell[][] getTabHeaderProductCells();

	  public List<ICell> getListHeaderFeatureCells();
	  public ICell[][] getTabHeaderFeatureCells();
	  
	  public List<ICell> getListExtraCells();
	  public ICell[][] getTabExtraCells();

	  public class DetailsOfCells
	  {
		  public List<ICell> headerFeatureCells;
		  public List<ICell> headerProductCells; 
		  public ICell[][] valuedCells;
		  public List<ICell> extraCells;	  
	  }
	  
	  public DetailsOfCells getDetailsOfAllCells();
	  public DetailsOfCells getDetailsOfCellsFromFilters( List<IFilter> listFilters );
	  
	  public boolean isFirstRowHeaderFeatures();
	 
}
