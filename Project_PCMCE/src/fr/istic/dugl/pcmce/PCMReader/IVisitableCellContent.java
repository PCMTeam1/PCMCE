package fr.istic.dugl.pcmce.PCMReader;

public interface IVisitableCellContent {
	
	public int accept( IVisitorCellContent v );
	public int compareTo( IVisitableCellContent c );
	public ICellContent getCellContent();
	
}
