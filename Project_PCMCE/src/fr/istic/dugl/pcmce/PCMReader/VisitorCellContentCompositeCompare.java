package fr.istic.dugl.pcmce.PCMReader;

import java.util.Iterator;
import java.util.List;

public class VisitorCellContentCompositeCompare implements IVisitorCellContent {
	
	ICellContentComposite b;
	
	VisitorCellContentCompositeCompare( ICellContentComposite b )
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
		List<ICellContent> bl = b.getComposite();
		List<ICellContent> al = a.getComposite();
		Iterator<ICellContent> b_it = bl.iterator();
		Iterator<ICellContent> a_it = al.iterator();
		
		if ( bl.size() == al.size() )
		{
				
		}
		return 1;
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
