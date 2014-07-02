package fr.istic.dugl.pcmce.PCMReader;

import java.util.BitSet;
import java.util.SortedSet;
import java.util.TreeSet;

public class FilterFeatureImplDUGL implements IFilterFeature {

	private BitSet bitmap;
	
	public FilterFeatureImplDUGL( BitSet bitmap )
	{
		this.bitmap = bitmap;
	}
	
	@Override
	public TypeFilter getTypeFilter() {
		return TypeFilter.TypeFilterFeature;
	}

	@Override
	public SortedSet<Integer> getIndices(IMatrix matrix) {
		SortedSet<Integer> result= new TreeSet<Integer>(); 
		
		for ( int i = 0 ; i < bitmap.size() ; i++ )
		{
			if ( bitmap.get(i) )
			{
				result.add(i);
			}
		} 
		return result;
	}

	@Override
	public boolean isFeatureOK(int ind) {
		return bitmap.get(ind);
	}

	@Override
	public void setFeature(int ind, boolean value) {
		bitmap.set( ind, value );

	}

	@Override
	public BitSet getBitmap() {
		
		return bitmap;
	}

	@Override
	public void setBitmap(BitSet bitmap) {
		this.bitmap = bitmap;

	}

}
