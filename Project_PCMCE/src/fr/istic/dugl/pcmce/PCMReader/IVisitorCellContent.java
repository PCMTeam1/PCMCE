package fr.istic.dugl.pcmce.PCMReader;


/**
 * Visitor interface
 * @author yvesmocq
 *
 */
public interface IVisitorCellContent  {
	
	static int inconsistentResult=10;
	
	// the result of comparison of b ( in the implementation context ) and a is
	//	-1 when b < a
	//  0 when b == a
	//  1 when b > a
	//  resultInconsitent when the comparison has no sense 
	
	int compareToCellContentString( ICellContentString a );
	int compareToCellContentBoolean( ICellContentBoolean a );
	int compareToCellContentComposite( ICellContentComposite a );
	int compareToCellContentDouble( ICellContentDouble a );
	int compareToCellContentInteger( ICellContentInteger a );
	int compareToCellContentEmpty( ICellContentEmpty a );

}
