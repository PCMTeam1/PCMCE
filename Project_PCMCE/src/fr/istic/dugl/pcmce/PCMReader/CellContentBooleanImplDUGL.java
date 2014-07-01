package fr.istic.dugl.pcmce.PCMReader;

public class CellContentBooleanImplDUGL implements ICellContentBoolean, IVisitableCellContent {

	
	private Boolean value;
	
	public CellContentBooleanImplDUGL(Boolean value){
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
		return true;
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
		return false;
	}
	
	@Override 
	public boolean isInconsistent(){
		return false;
	}

	@Override
	public EnumTypeCellContent getCellContentType() {
		return EnumTypeCellContent.BOOLEAN;
	}
	
	@Override
	public Boolean getBoolean(){
		return this.value;
	}
	
	@Override
	public void setBoolean(Boolean value){
		this.value=value;
	}
	@Override
	public int compareTo( IVisitableCellContent c ) {
		
		IVisitorCellContent v = new VisitorCellContentBooleanCompare( this );
		return c.accept( v );
	}

	@Override
	public int accept(IVisitorCellContent v) {
		
		return v.compareToCellContentBoolean( this );
	}

	@Override
	public ICellContent getCellContent() {

		return this;
	}
	


}
