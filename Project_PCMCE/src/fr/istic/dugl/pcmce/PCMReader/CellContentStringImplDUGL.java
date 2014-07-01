package fr.istic.dugl.pcmce.PCMReader;

public class CellContentStringImplDUGL implements ICellContentString, IVisitableCellContent {
	
	private String value;

	public CellContentStringImplDUGL(String value){
		this.value=value;
	}
	
	@Override
	public boolean isInteger() {
		return false;
	}

	@Override
	public boolean isDouble() {
		return false;
	}

	@Override
	public boolean isBoolean() {
		return false;
	}

	@Override
	public boolean isUnknown() {
		return false;
	}

	@Override
	public boolean isEmpty() {
		return false;
	}

	@Override
	public boolean isComposite() {
		return false;
	}

	@Override
	public boolean isString() {
		return true;
	}
	
	@Override 
	public boolean isInconsistent(){
		return false;
	}

	@Override
	public EnumTypeCellContent getCellContentType() {
		return EnumTypeCellContent.STRING;
	}
	
	@Override
	public String getString(){
		return this.value;
	}
	
	@Override
	public void setString(String value){
		this.value=value;
	}

	@Override
	public int compareTo( IVisitableCellContent c ) {
		
		VisitorCellContentStringCompare v = new VisitorCellContentStringCompare( this );
		return c.accept( v );
	}

	@Override
	public int accept(IVisitorCellContent v) {
		
		return v.compareToCellContentString( this );
	}
	
	
	
}
