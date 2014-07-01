package fr.istic.dugl.pcmce.PCMReader;

import java.util.List;

public class CellContentCompositeImplDUGL implements ICellContentComposite, IVisitableCellContent {
	
	private List<ICellContent> value;

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
		return true;
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
		return EnumTypeCellContent.COMPOSITE;
	}
	
	@Override
	public List<ICellContent> getComposite(){
		return this.value;
	}
	
	@Override
	public void setComposite(List<ICellContent> value){
		this.value=value;
	}
	@Override
	public int compareTo( IVisitableCellContent c ) {
		
		IVisitorCellContent v = new VisitorCellContentCompositeCompare( this );
		return c.accept( v );
	}

	@Override
	public int accept(IVisitorCellContent v) {
		
		return v.compareToCellContentComposite( this );
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
