
public interface IMatrix {
	
	  public java.lang.String getName();
	  
	  public void setName(java.lang.String name);
	  
	  public java.util.List<ICell> getCells();
	  
	  public java.lang.String getId();
	  
	  public void setId(java.lang.String id);

	  public ICell getCell(int row, int column);
	  
	  public int getNbHeaderProductColumn();
	  
	  public int getNbHeaderFeatureRows();
	  
	  public java.util.List<ICell> getHeaderProducts();

	  public java.util.List<ICell> getHeaderFeatures();
	  
	  public java.util.List<ICell> getExtras();
	  
	  public ICell[][] getTabCells();
	  
	  
}
