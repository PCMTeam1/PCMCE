package fr.istic.dugl.pcmce.PCMReader;

/**
 * Visitor (processing) 
 * @author Yves Mocquard 
 *
 */
public class VisitorCellContentBooleanCompare implements IVisitorCellContent {
	
	ICellContentBoolean b;
	
	VisitorCellContentBooleanCompare( ICellContentBoolean b )
	{
		this.b = b;
	}

	public int compareToCellContentString( ICellContentString a )
	{
		return 1;
	}
	
	public int compareToCellContentBoolean( ICellContentBoolean a )
	{
		return 1;
	}
	public int compareToCellContentComposite( ICellContentComposite a )
	{
		return 1;
	}
	
	public int compareToCellContentDouble( ICellContentDouble a )
	{
		return 1;
	}
	
	public int compareToCellContentInteger( ICellContentInteger a )
	{
		return 1;
	}


}
