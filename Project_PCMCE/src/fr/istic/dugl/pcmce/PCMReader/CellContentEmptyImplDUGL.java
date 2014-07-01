package fr.istic.dugl.pcmce.PCMReader;

public class CellContentEmptyImplDUGL implements ICellContentEmpty, IVisitableCellContent {

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
		return true;
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
	public boolean isInconsistent() {
		return false;
	}

	@Override
	public EnumTypeCellContent getCellContentType() {
		return EnumTypeCellContent.EMPTY;
	}
	@Override
	public int compareTo( IVisitableCellContent c ) {
		
		IVisitorCellContent v = new VisitorCellContentEmptyCompare( this );
		return c.accept( v );
	}

	@Override
	public int accept(IVisitorCellContent v) {
		
		return v.compareToCellContentEmpty( this );
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
