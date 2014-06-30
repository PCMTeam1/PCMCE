package fr.istic.dugl.pcmce.PCMReader;


public class FilterImplDUGL implements IFilter, IFilter2 {
	public enum OperatorTest
	{
		EQUALS, NOT_EQUALS, LESS_THAN, GREATER_THAN, LESS_OR_EQUALS, GREATER_OR_EQUALS 
	}

	/* (non-Javadoc)
	 * @see fr.istic.dugl.pcmce.PCMReader.IFilter2#getColumn()
	 */
	@Override
	public int getColumn() {
		return column;
	}
	/* (non-Javadoc)
	 * @see fr.istic.dugl.pcmce.PCMReader.IFilter2#setColumn(int)
	 */
	@Override
	public void setColumn(int column) {
		this.column = column;
	}
	/* (non-Javadoc)
	 * @see fr.istic.dugl.pcmce.PCMReader.IFilter2#getValue()
	 */
	@Override
	public ICellContent getValue() {
		return value;
	}
	/* (non-Javadoc)
	 * @see fr.istic.dugl.pcmce.PCMReader.IFilter2#setValue(fr.istic.dugl.pcmce.PCMReader.ICellContent)
	 */
	@Override
	public void setValue(ICellContent value) {
		this.value = value;
	}
	/* (non-Javadoc)
	 * @see fr.istic.dugl.pcmce.PCMReader.IFilter2#getOp()
	 */
	@Override
	public OperatorTest getOp() {
		return op;
	}
	/* (non-Javadoc)
	 * @see fr.istic.dugl.pcmce.PCMReader.IFilter2#setOp(fr.istic.dugl.pcmce.PCMReader.FilterImplDUGL.OperatorTest)
	 */
	@Override
	public void setOp(OperatorTest op) {
		this.op = op;
	}
	/* (non-Javadoc)
	 * @see fr.istic.dugl.pcmce.PCMReader.IFilter2#isExact()
	 */
	@Override
	public boolean isExact() {
		return exact;
	}
	/* (non-Javadoc)
	 * @see fr.istic.dugl.pcmce.PCMReader.IFilter2#setExact(boolean)
	 */
	@Override
	public void setExact(boolean exact) {
		this.exact = exact;
	}
	private int column;
	private ICellContent value;
	private OperatorTest op=OperatorTest.EQUALS;
	private boolean exact=true;
	
	/**
	 * Compare the two values of cells
	 * @param valTest
	 * @param valRef
	 * @return -1, 0 or 1 if types are compatible.
	 * 			else 2.
	 */
	public int compareCells( ICellContent valTest, ICellContent valRef )
	{
		return valTest.compareCells( valRef );
		
		
	}
	
	/* (non-Javadoc)
	 * @see fr.istic.dugl.pcmce.PCMReader.IFilter2#isTrue(fr.istic.dugl.pcmce.PCMReader.ICellContent)
	 */
	@Override
	public boolean isTrue( ICellContent valTest )
	{
		
		
		return false; // n'importe quoi
	}
}
