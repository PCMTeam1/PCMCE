package fr.istic.dugl.pcmce.PCMReader;

public class CellContentIntegerImplDUGL implements ICellContentInteger, IVisitableCellContent {

	private Integer value;

	public CellContentIntegerImplDUGL(Integer value){
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
		return false;
	}
	
	@Override 
	public boolean isInconsistent(){
		return false;
	}
	
	@Override
	public EnumTypeCellContent getCellContentType() {
		return EnumTypeCellContent.INTEGER;
	}
	
	@Override
	public Integer getInteger(){
		return this.value;
	}
	
	@Override
	public void setString(Integer value){
		this.value=value;
	}

	@Override
	public int accept(IVisitorCellContent v) {
		
		return v.compareToCellContentInteger(this);
	}

	@Override
	public int compareTo(IVisitableCellContent c) {
		IVisitorCellContent v = new VisitorCellContentIntegerCompare(this);
		return c.accept(v);
	}

	@Override
	public ICellContent getCellContent() {
	
		return this;
	}

	@Override
	public IVisitableCellContent getVisitableCell() {
		// TODO Auto-generated method stub
		return this;
	}

}
