package fr.istic.dugl.pcmce.PCMReader;

public interface ICell {

	  public  java.lang.String getName();
	  
	  public  void setName(java.lang.String name);

	  public  java.lang.String getVerbatim();

	  public  void setVerbatim(java.lang.String verbatim);
	  
	  public  int getRow();

	  public  void setRow(int row);
	  
	  public  int getColumn();
	  
	  public  void setColumn(int column);
	  
	  public int getId(int id);
	  
	  public ICellContent getCellContent();
	  
	  public void setCellContent(ICellContent iCellContent);
}

