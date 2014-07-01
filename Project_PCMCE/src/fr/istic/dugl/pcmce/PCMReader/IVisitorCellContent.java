package fr.istic.dugl.pcmce.PCMReader;


public interface IVisitorCellContent  {
	
	int compareToCellContentString( ICellContentString a );
	int compareToCellContentBoolean( ICellContentBoolean a );
	int compareToCellContentComposite( ICellContentComposite a );
	int compareToCellContentDouble( ICellContentDouble a );
	int compareToCellContentInteger( ICellContentInteger a );

}
