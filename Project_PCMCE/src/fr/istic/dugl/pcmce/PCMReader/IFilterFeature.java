package fr.istic.dugl.pcmce.PCMReader;

import java.util.BitSet;

public interface IFilterFeature extends IFilter  {
	
	
	
	public boolean isFeatureOK( int ind );
	
	public void setFeature( int ind, boolean value );
	public BitSet getBitmap();
	public void setBitmap( BitSet bitmap );

}
