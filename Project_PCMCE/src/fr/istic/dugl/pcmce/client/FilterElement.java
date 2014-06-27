package fr.istic.dugl.pcmce.client;

public enum OperatorTest
{
	EQUAL, NOT_EQUAL, LESS_THAN, GEATER_THAN, LESS_OR_EQUALS, GREATER_OR_EQUAL 
}

public class FilterElement {
	private int column;
	private ICellContent value;
	private OperatorTest op;
	private boolean exact;
	boolean isTrue( ICellContent valTest )
	{
		
	}
}
