package fr.istic.dugl.pcmce.PCMReader;

import sun.reflect.generics.visitor.Visitor;

public interface IVisitorCellContent extends Visitor<ICellContent> {
	
	int compareToCellContentString( ICellContentString a );
	int compareToCellContentBoolean( ICellContentBoolean a );
	int compareToCellContentComposite( ICellContentComposite a );
	int compareToCellContentDouble( ICellContentDouble a );
	int compareToCellContentInteger( ICellContentInteger a );

}
