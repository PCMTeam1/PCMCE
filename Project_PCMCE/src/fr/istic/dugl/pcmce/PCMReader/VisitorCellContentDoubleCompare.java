package fr.istic.dugl.pcmce.PCMReader;

public class VisitorCellContentDoubleCompare implements IVisitorCellContent {
	
	ICellContentDouble b;
	
	public VisitorCellContentDoubleCompare( ICellContentDouble b )
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
		return b.getDouble().compareTo( a.getDouble() );
	}
	
	public int compareToCellContentInteger( ICellContentInteger a )
	{
		Double ad = new Double(a.getInteger());
		return b.getDouble().compareTo( ad );
	}

	@Override
	public int compareToCellContentEmpty(ICellContentEmpty a) {
		// TODO Auto-generated method stub
		return 0;
	}


}
