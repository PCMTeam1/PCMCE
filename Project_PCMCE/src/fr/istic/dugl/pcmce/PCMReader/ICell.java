package fr.istic.dugl.pcmce.PCMReader;


public interface ICell {
	
	  public int getId();
	  
	  public void setId(int id);
		
	  public  String getName();
	  
	  public  void setName(String name);

	  public  String getVerbatim();

	  public  void setVerbatim(String verbatim);
	  
	  public  int getRow();

	  public  void setRow(int row);
	  
	  public  int getRowSpan();

	  public  void setRowSpan(int rowSpan);
	  
	  public  int getColumn();
	  
	  public  void setColumn(int column);
	  
	  public  int getColumnSpan();
	  
	  public  void setColumnSpan(int columnSpan);
	  
	  public ICellContent getCellContent();
	  
	  public void setCellContent(ICellContent iCellContent);
}

