package fr.istic.dugl.pcmce.PCMReader;

public class CellImplDUGL implements ICell {
	
	private int id;
	private String name;
	private String verbatim;
	private int row;
	private int rowSpan;
	private int column;
	private int columnSpan;
	private ICellContent cellContent;
	
	@Override
	public int getId() {
		return id;
	}

	@Override
	public void setId(int id) {
		this.id = id;
	}
	
	@Override
	public int getRowSpan() {
		return this.rowSpan;
	}

	public void setRowSpan(int rowSpan) {
		this.rowSpan = rowSpan;
	}

	@Override
	public int getColumnSpan() {
		return columnSpan;
	}

	@Override
	public void setColumnSpan(int columnSpan) {
		this.columnSpan = columnSpan;
	}


	
	@Override
	public String getName() {
		return name;
	}

	@Override
	public void setName(String name) {
		this.name=name;
	}

	@Override
	public String getVerbatim() {
		return verbatim;
	}

	@Override
	public void setVerbatim(String verbatim) {
		this.verbatim=verbatim;
	}

	@Override
	public int getRow() {
		return this.row;
	}

	@Override
	public void setRow(int row) {
		this.row=row;

	}

	@Override
	public int getColumn() {
		return this.column;
	}

	@Override
	public void setColumn(int column) {
		this.column=column;
	}


	@Override
	public ICellContent getCellContent() {
		return this.cellContent;
	}

	@Override
	public void setCellContent(ICellContent iCellContent) {
		this.cellContent=iCellContent;
	}

}
