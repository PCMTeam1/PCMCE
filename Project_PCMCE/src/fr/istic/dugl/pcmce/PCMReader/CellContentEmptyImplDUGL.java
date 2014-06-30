package fr.istic.dugl.pcmce.PCMReader;

public class CellContentEmptyImplDUGL implements ICellContentEmpty {

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

}
