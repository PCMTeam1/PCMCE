package fr.istic.dugl.pcmce.PCMReader;

import java.util.LinkedList;
import java.util.List;

import pcmmm.Cell;
import pcmmm.Matrix;

public class MatrixImplDUGL implements IMatrix {
	
	private int id;
	private String name;
	
	private int nbRows;
	private int nbColumns;
	
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
	
	public MatrixImplDUGL(Matrix matrix){
		listAllCells = new LinkedList<ICell>();
		
		listValuedCells = new LinkedList<ICell>();
		
		listHeaderProductCells = new LinkedList<ICell>();
		
		listHeaderFeatureCells = new LinkedList<ICell>();
		
		listExtraCells = new LinkedList<ICell>();
		
		//Compute number of rows and numbers of columns
		for(Cell cell : matrix.getCells()){
			int column = cell.getColumn();
			int row =  cell.getRow();
			if(row>nbRows) {nbRows=row;}
			if(column>nbColumns) {nbColumns=column;}
			
			ICell myCellDUGL = new CellImplDUGL(cell);
			listAllCells.add(myCellDUGL);
		}
		nbRows++; nbColumns++;
		
		tabAllCells = new ICell[nbRows][nbColumns];
		
		for(Cell cell : matrix.getCells()){
			int column = cell.getColumn();
			int row =  cell.getRow();
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
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getNbColumn() {
		// TODO Auto-generated method stub
		return 0;
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

}
