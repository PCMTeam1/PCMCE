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
