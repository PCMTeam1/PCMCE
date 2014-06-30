package fr.istic.dugl.pcmce.PCMReader;

public class CellContentBooleanImplDugl implements ICellContentBoolean {

	
	private Boolean value;
	
	public CellContentBooleanImplDugl(Boolean value){
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
		return true;
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
		return EnumTypeCellContent.BOOLEAN;
	}
	
	@Override
	public Boolean getBoolean(){
		return this.value;
	}
	
	@Override
	public void setBoolean(Boolean value){
		this.value=value;
	}
	

}