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
		
		int ret = 0;
		while ( ret == 0  )
		{
			boolean boolB = b_it.hasNext();
			boolean boolA = a_it.hasNext();
			if ( ! (boolA && boolB) )
			{
				if ( !boolA && !boolB )
				{
					return 0;
				}
				return boolA ? 1 : -1; 
			}
			IVisitableCellContent cellA = a_it.next().getVisitableCell();
			IVisitableCellContent cellB = b_it.next().getVisitableCell();
			ret = cellA.compareTo(cellB);
		}
		return ret;
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
