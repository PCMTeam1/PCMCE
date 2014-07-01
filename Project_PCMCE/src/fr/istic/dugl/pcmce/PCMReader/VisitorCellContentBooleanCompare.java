package fr.istic.dugl.pcmce.PCMReader;

/**
 * Visitor (processing) 
 * @author Yves Mocquard 
 *
 */
public class VisitorCellContentBooleanCompare implements IVisitorCellContent {
	
	private ICellContentBoolean b;
	
	public VisitorCellContentBooleanCompare( ICellContentBoolean b )
	{
		this.b = b;
	}

	public int compareToCellContentString( ICellContentString a )
	{
		return IVisitorCellContent.inconsistentResult;
	}
	
	public int compareToCellContentBoolean( ICellContentBoolean a )
	{
		return ( a.getBoolean() == b.getBoolean() )? 0 : 1 ;
	}
	public int compareToCellContentComposite( ICellContentComposite a )
	{
		return IVisitorCellContent.inconsistentResult;
	}
	
	public int compareToCellContentDouble( ICellContentDouble a )
	{
		return IVisitorCellContent.inconsistentResult;
	}
	
	public int compareToCellContentInteger( ICellContentInteger a )
	{
		return IVisitorCellContent.inconsistentResult;
	}

	@Override
	public int compareToCellContentEmpty(ICellContentEmpty a) {
		return 1;
	}




}
