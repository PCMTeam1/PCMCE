package fr.istic.dugl.pcmce.PCMReader;

public class VisitorCellContentStringCompare implements IVisitorCellContent {
	
	ICellContentString b;
	
	VisitorCellContentStringCompare( ICellContentString b )
	{
		this.b = b;
	}

	public int compareToCellContentString( ICellContentString a )
	{
		return a.getString().compareTo( b.getString() );
	}
	
	public int compareToCellContentBoolean( ICellContentBoolean a )
	{
		return IVisitorCellContent.inconsistentResult;
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

		return IVisitorCellContent.inconsistentResult;
	}


}
