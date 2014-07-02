package fr.istic.dugl.pcmce.PCMReader;

public class VisitorCellContentIntegerCompare implements IVisitorCellContent {
	
	ICellContentInteger b;
	
	VisitorCellContentIntegerCompare( ICellContentInteger b )
	{
		this.b = b;
	}

	public int compareToCellContentString( ICellContentString a )
	{
		return IVisitorCellContent.inconsistentResult;
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
		return b.getInteger().compareTo( a.getDouble().intValue() );
	}
	
	public int compareToCellContentInteger( ICellContentInteger a )
	{
		return b.getInteger().compareTo(a.getInteger());
	}

	@Override
	public int compareToCellContentEmpty(ICellContentEmpty a) {
		// TODO Auto-generated method stub
		return 0;
	}


}
