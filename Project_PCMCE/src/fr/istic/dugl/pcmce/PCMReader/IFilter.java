package fr.istic.dugl.pcmce.PCMReader;

import fr.istic.dugl.pcmce.PCMReader.FilterImplDUGL.OperatorTest;

public interface IFilter {
	public abstract int getColumn();

	public abstract void setColumn(int column);

	public abstract ICellContent getValue();

	public abstract void setValue(ICellContent value);

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
	public abstract int compareTo(ICellContent valTest, ICellContent valRef);

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
