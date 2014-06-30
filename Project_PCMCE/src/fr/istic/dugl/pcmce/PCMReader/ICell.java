package fr.istic.dugl.pcmce.PCMReader;


public interface ICell {

	  public  String getName();
	  
	  public  void setName( String name);

	  public  String getVerbatim();

	  public  void setVerbatim( String verbatim);
	  
	  public  int getRow();

	  public  void setRow(int row);
	  
	  public  int getColumn();
	  
	  public  void setColumn(int column);
	  
	  public int getId(int id);
	  
	  public ICellContent getCellContent();
	  
	  public void setCellContent(ICellContent iCellContent);
}

