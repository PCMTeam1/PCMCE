package fr.istic.dugl.pcmce.PCMReader;

import java.util.SortedSet;
import java.util.TreeSet;

public class FilterProductImplDUGL implements IFilterProduct {
	public enum OperatorTest {
		EQUALS, NOT_EQUALS, LESS_THAN, GREATER_THAN, LESS_OR_EQUALS, GREATER_OR_EQUALS
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.istic.dugl.pcmce.PCMReader.IFilter2#getColumn()
	 */
	@Override
	public int getIndFeature() {
		return indFeature;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.istic.dugl.pcmce.PCMReader.IFilter2#setColumn(int)
	 */
	@Override
	public void setIndFeature(int column) {
		this.indFeature = column;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.istic.dugl.pcmce.PCMReader.IFilter2#getValue()
	 */
	@Override
	public IVisitableCellContent getValue() {
		return value;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * fr.istic.dugl.pcmce.PCMReader.IFilter2#setValue(fr.istic.dugl.pcmce.PCMReader
	 * .ICellContent)
	 */
	@Override
	public void setValue(IVisitableCellContent value) {
		this.value = value;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.istic.dugl.pcmce.PCMReader.IFilter2#getOp()
	 */
	@Override
	public OperatorTest getOp() {
		return op;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * fr.istic.dugl.pcmce.PCMReader.IFilter2#setOp(fr.istic.dugl.pcmce.PCMReader
	 * .FilterImplDUGL.OperatorTest)
	 */
	@Override
	public void setOp(OperatorTest op) {
		this.op = op;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.istic.dugl.pcmce.PCMReader.IFilter2#isExact()
	 */
	@Override
	public boolean isExact() {
		return exact;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.istic.dugl.pcmce.PCMReader.IFilter2#setExact(boolean)
	 */
	@Override
	public void setExact(boolean exact) {
		this.exact = exact;
	}

	private int indFeature;
	private IVisitableCellContent value;
	private OperatorTest op = OperatorTest.EQUALS;
	private boolean exact = true;

	/**
	 * Compare the two values of cells
	 * 
	 * @param valTest
	 * @param valRef
	 * @return -1, 0 or 1 if types are compatible. else 2.
	 */
	public int compareCellContent(IVisitableCellContent valTest,
			IVisitableCellContent valRef) {
		return valTest.compareTo(valRef);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * fr.istic.dugl.pcmce.PCMReader.IFilter2#isTrue(fr.istic.dugl.pcmce.PCMReader
	 * .ICellContent)
	 */
	@Override
	public boolean isTrue(ICellContent valTest) {
		return value.compareTo(valTest.getVisitableCell()) == 0;
	}

	@Override
	public TypeFilter getTypeFilter() {
		return TypeFilter.TypeFilterProduct;
	}

	@Override
	public SortedSet<Integer> getIndices(IMatrix matrix) {

		final ICell[][] tabAll = matrix.getTabAllCells();
		boolean isRow = matrix.isFirstRowHeaderFeatures();

		SortedSet<Integer> all = matrix.getFeatureIndices();
		SortedSet<Integer> result = new TreeSet<Integer>();
		for (int i : all) {
			ICell cell = isRow ? tabAll[i][indFeature] : tabAll[indFeature][i];

			int res = value.compareTo(cell.getCellContent().getVisitableCell());
			boolean flagOk = true;
			if (!cell.isHeaderFeature()) {
				switch (op) {
				case EQUALS:
					flagOk = (res == 0);
					break;
				case GREATER_OR_EQUALS:
					flagOk = (res >= 0);
					break;
				case GREATER_THAN:
					flagOk = (res > 0);
					break;
				case LESS_OR_EQUALS:
					flagOk = (res <= 0);
					break;
				case LESS_THAN:
					flagOk = (res < 0);
					break;
				case NOT_EQUALS:
					flagOk = (res != 0);
					break;
				}
			}
			if (flagOk) {
				result.add(i);
			}
		}

		return result;

	}
}
