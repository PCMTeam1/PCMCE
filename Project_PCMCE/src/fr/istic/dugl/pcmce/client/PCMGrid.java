package fr.istic.dugl.pcmce.client;

import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.Label;

public class PCMGrid extends Grid {
	
	public PCMGrid()
	{
		super( 10,10 );
		
		for ( int i = 0 ; i < 10 ; i++ )
		{
			for ( int j = 0 ; j < 10 ; j++ )
			{
				setWidget(i,j,new Label("case "+i+","+j));
			}
		}

	}


}
