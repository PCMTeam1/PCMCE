package fr.istic.dugl.pcmce.client;


public interface IFilterElement {
	
	
	void setColumn( int col );
	
	
	boolean isTrue( ICellContent valTest )
}
