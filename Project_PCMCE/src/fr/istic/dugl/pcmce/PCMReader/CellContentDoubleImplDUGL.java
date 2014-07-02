/**
 * @author Yves Le Monnier
 *
 */

package fr.istic.dugl.pcmce.PCMReader;

public class CellContentDoubleImplDUGL implements ICellContentDouble, IVisitableCellContent {
	
	private Double value;
	
	
	public CellContentDoubleImplDUGL(Double value){
		this.value=value;
	}
	
	@Override
	public boolean isInteger() {
		return false;
	}

	@Override
	public boolean isDouble() {
		return true;
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
		return EnumTypeCellContent.DOUBLE;
	}
	
	@Override
	public Double getDouble(){
		return this.value;
	}
	
	@Override
	public void setValue(Double value){
		this.value=value;
	}
	
	@Override
	public int compareTo( IVisitableCellContent c ) {
		
		IVisitorCellContent v = new VisitorCellContentDoubleCompare( this );
		return c.accept( v );
	}

	@Override
	public int accept(IVisitorCellContent v) {
		
		return v.compareToCellContentDouble( this );
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
