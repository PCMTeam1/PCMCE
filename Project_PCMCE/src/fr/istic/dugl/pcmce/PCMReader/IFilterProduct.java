package fr.istic.dugl.pcmce.PCMReader;

import fr.istic.dugl.pcmce.PCMReader.FilterProductImplDUGL.OperatorTest;

public interface IFilterProduct extends IFilter {
	
	public abstract int getIndFeature();

	public abstract void setIndFeature(int column);

	public abstract IVisitableCellContent getValue();

	public abstract void setValue(IVisitableCellContent value);

	public abstract OperatorTest getOp();

	public abstract void setOp(OperatorTest op);

	public abstract boolean isExact();

	public abstract void setExact(boolean exact);

	/**
	 * Compare the two values of cells
	 * @param valTest
	 * @param valRef
	 * @return -1, 0 or 1 if types are compatible.
	 * 			else 2.
	 */
	public int compareCellContent(IVisitableCellContent valTest, IVisitableCellContent valRef);

	/**
	 * test the validity of the cell, function calls from
	 * IMatrix.getResultFilter()
	 * 
	 * @param valTest
	 *            : cell to test
	 * @return
	 */
	public boolean isTrue(ICellContent valTest);

}
