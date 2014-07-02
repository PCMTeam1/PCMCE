package fr.istic.dugl.pcmce.PCMReader;

import java.util.SortedSet;

public interface IFilter {
	enum TypeFilter
	{
		TypeFilterProduct,
		TypeFilterFeature
	}
	public TypeFilter getTypeFilter();
	
	/**
	 * @return the result of the filter, a set of indices ( of product or feature )
	 */
	public SortedSet<Integer> getIndices( IMatrix matrix );
}
