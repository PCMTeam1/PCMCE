package fr.istic.dugl.pcmce.PCMReader;

public interface ICellContent {
	public enum EnumTypeCellContent{
		INTEGER,
		DOUBLE,
		BOOLEAN,
		UNKNOWN,
		EMPTY,
		COMPOSITE,
		STRING,
		
	}
	public boolean isInteger();
	public boolean isDouble();
	public boolean isBoolean();
	public boolean isUnknown();
	public boolean isEmpty();
	public boolean isComposite();
	public boolean isString();
}
