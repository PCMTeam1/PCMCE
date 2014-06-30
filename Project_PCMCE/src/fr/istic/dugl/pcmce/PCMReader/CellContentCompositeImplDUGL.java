package fr.istic.dugl.pcmce.PCMReader;

import java.util.List;

public class CellContentCompositeImplDUGL implements ICellContentComposite {
	
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

}
