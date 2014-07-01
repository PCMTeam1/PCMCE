package fr.istic.dugl.pcmce.PCMReader;

public class VisitorCellContentCompositeCompare implements IVisitorCellContent {
	
	ICellContentComposite b;
	
	VisitorCellContentCompositeCompare( ICellContentComposite b )
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
