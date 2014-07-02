package fr.istic.dugl.pcmce.PCMReader;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.logging.Logger;

import pcmmm.Cell;
import pcmmm.Matrix;

public class MatrixImplDUGL implements IMatrix {
	
	public static Logger _LOGGER = Logger.getLogger("MatrixImplDUGL");
	private int id;
	private String name;
	
	private int nbAllRows;
	private int nbAllColumns;
	
	private int nbHeadersProductRows;
	private int nbHeadersProductColumns;
	
	private int nbHeadersFeatureRows;
	private int nbHeadersFeatureColumns;
	
	private int nbExtraRows;
	private int nbExtraColumns;
	
	
	private List<ICell> listAllCells;
	private ICell[][] tabAllCells;
	
	private List<ICell> listValuedCells;
	private ICell[][] tabValuedCells;
	
	private List<ICell> listHeaderProductCells;
	private ICell[][] tabHeaderProductCells;
	
	private List<ICell> listHeaderFeatureCells;
	private ICell[][] tabHeaderFeatureCells;
	
	private List<ICell> listExtraCells;
	private ICell[][] tabExtraCells;
	
	private SortedSet<Integer> featureIndices;
	private SortedSet<Integer> productIndices;
	
	public MatrixImplDUGL(Matrix matrix){
		listAllCells = new ArrayList<ICell>();
		
		listValuedCells = new ArrayList<ICell>();
		
		listHeaderProductCells = new ArrayList<ICell>();
		
		listHeaderFeatureCells = new ArrayList<ICell>();
		
		listExtraCells = new ArrayList<ICell>();
		
		//Compute number of rows and numbers of columns
		int column,row;
		nbAllRows = 0;
		nbAllColumns = 0;
		for(Cell cell : matrix.getCells()){
			column = cell.getColumn();
			row =  cell.getRow();
			if(row>nbAllRows) {nbAllRows=row;}
			if(column>nbAllColumns) {nbAllColumns=column;}
		}
		nbAllRows++; nbAllColumns++;
		
		tabAllCells = new ICell[nbAllRows][nbAllColumns];

		
		for(Cell cell : matrix.getCells()){
			column = cell.getColumn();
			row =  cell.getRow();
			ICell myCellImplDUGL = new CellImplDUGL(cell);
			listAllCells.add(myCellImplDUGL);
			tabAllCells[row][column] = myCellImplDUGL;
			if(myCellImplDUGL.isHeaderFeature()){
				listHeaderFeatureCells.add(myCellImplDUGL);
			}
			else if(myCellImplDUGL.isHeaderProduct()){
				listHeaderProductCells.add(myCellImplDUGL);
			}
			else if(myCellImplDUGL.isExtra()){
				listExtraCells.add(myCellImplDUGL);
			}
			else if(myCellImplDUGL.isValued()){
				listValuedCells.add(myCellImplDUGL);
			}
			else{
				_LOGGER.info("Type of Cell not supported");
			}
		}
	}
	
	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public void setName(String name) {
		this.name=name;
	}
	

	@Override
	public int getNbRows() {
		return nbAllRows;
	}
	@Override
	public int getNbColumn() {
		return nbAllColumns;
	}

	@Override
	public int getId() {
		return this.id;
	}

	@Override
	public void setId(int id) {
		this.id=id;
		
	}

	@Override
	public ICell getCell(int row, int column) {
		return tabAllCells[row][column];
	}

	@Override
	public int getNbHeaderProductColumn() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getNbHeaderFeatureRows() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<ICell> getListAllCells() {
		return this.listAllCells;
	}

	@Override
	public ICell[][] getTabAllCells() {
		return this.tabAllCells;
	}

	@Override
	public List<ICell> getListValuedCells() {
		return this.listValuedCells;
	}

	@Override
	public ICell[][] getTabValuedCells() {
		return this.tabValuedCells;
	}

	@Override
	public List<ICell> getListHeaderProductCells() {
		return this.listHeaderProductCells;
	}

	@Override
	public ICell[][] getTabHeaderProductCells() {
		return this.tabHeaderProductCells;
	}

	@Override
	public List<ICell> getHeaderFeatureCells() {
		return this.listHeaderFeatureCells;
	}

	@Override
	public ICell[][] getTabHeaderFeatureCells() {
		return this.tabHeaderFeatureCells; 
	}

	@Override
	public List<ICell> getListExtraCells() {
		return this.listExtraCells;
	}

	@Override
	public ICell[][] getTabExtraCells() {
		return this.tabExtraCells;
	}

	@Override
	public DetailsOfCells getDetailsOfAllCells() {
		DetailsOfCells detailsOfCells = new DetailsOfCells();
		detailsOfCells.headerFeatureCells = getTabHeaderFeatureCells();
		detailsOfCells.headerProductCells = getTabHeaderFeatureCells();
		detailsOfCells.extraCells = getListExtraCells();
		return detailsOfCells;
	}

	/**
	 * @param a first set of indices ( we assume that it is sorted )
	 * @param b second set of indices ( sorted also )
	 * @return the set of intersection
	 */
	private SortedSet<Integer> intersection( SortedSet<Integer> a, SortedSet<Integer> b )
	{
		SortedSet<Integer> result = new TreeSet<Integer>();
		
		for ( Integer i:a )
		{
			if ( b.contains(i) )
			{
				result.add(i);
			}
		}
		return result;
	}
	
	public  SortedSet<Integer> getFeatureIndices()
	{
		return featureIndices;
	}
	
	public  SortedSet<Integer> getProductIndices()
	{
		return productIndices;
	}
	
	
	@Override
	public DetailsOfCells getDetailsOfCellsFromFilters(List<IFilter> listFilters)
	{
		SortedSet<Integer> productIndicesSet=null;
		SortedSet<Integer> featureIndicesSet=new TreeSet<Integer>();
			
		for( IFilter filter:listFilters )
		{
			SortedSet<Integer> resultFiltre = filter.getIndices(this);
			if ( filter.getTypeFilter() == IFilter.TypeFilter.TypeFilterProduct )
			{
				productIndicesSet = intersection( productIndicesSet, resultFiltre );
			}
			else
			{
				featureIndicesSet = intersection( featureIndicesSet, resultFiltre );
			}
		}
		
		
		return null;
	}

}
