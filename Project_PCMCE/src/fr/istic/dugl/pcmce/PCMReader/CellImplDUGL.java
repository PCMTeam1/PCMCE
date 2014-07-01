package fr.istic.dugl.pcmce.PCMReader;

import java.util.logging.Logger;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.EClassImpl;

import pcmmm.Cell;

/**
 * @author 29004736
 *
 */
public class CellImplDUGL implements ICell {
	public static Logger _LOGGER = Logger.getLogger("CellImplDUGL");
	public static final String HEADER_CLASS_NAME = "pcmmm.Header";
	public static final String FEATURE_CLASS_NAME = "pcmmm.Feature";
	public static final String PRODUCT_CLASS_NAME = "pcmmm.Product";
	public static final String EXTRA_CLASS_NAME = "pcmmm.Extra";
	public static final String VALUED_CELL_CLASS_NAME = "pcmmm.ValuedCell";
	
	public static final String VARIABILITY_CONCEPT_CLASS_NAME = "pcmmm.VariabilityConceptRef";
	public static final String DOUBLE_CLASS_NAME = "pcmmm.Double";
	public static final String BOOLEAN_CLASS_NAME = "pcmmm.Boolean";
	public static final String INTEGER_CLASS_NAME = "pcmmm.Integer";
	
	public static final String PARTIAL_CLASS_NAME = "pcmmm.Partial";
	public static final String MULTIPLE_CLASS_NAME = "pcmmm.Multiple";
	public static final String AND_CLASS_NAME = "pcmmm.And";
	public static final String OR_CLASS_NAME = "pcmmm.Or";
	public static final String XOR_CLASS_NAME = "pcmmm.XOr";
	
	
	public static final String INCONSISTANT_CLASS_NAME = "pcmmm.Inconsistant";
	public static final String EMPTY_CLASS_NAME = "pcmmm.Empty";
	public static final String UNKNOWN_CLASS_NAME = "pcmmm.Unknown";
	
	private int id;
	private String name;
	private String verbatim;
	private int row;
	private int rowSpan;
	private int column;
	private int columnSpan;
	private boolean isHeaderProduct = false;
	private boolean isHeaderFeature = false;
	private boolean isExtra = false;
	private boolean isValued = false;
	private ICellContent cellContent;
	
	
	public CellImplDUGL(Cell cell){
		this.name=cell.getName();
		this.verbatim=cell.getVerbatim();
		this.row=cell.getRow();
		this.rowSpan=cell.getRowspan();
		this.column=cell.getColumn();
		this.columnSpan=cell.getColspan();
		setCellType(cell);
		
		
	}
	
	private void setCellType(Cell cell){
		if(cell.eClass().getInstanceClassName().equals(HEADER_CLASS_NAME)){
			String instanceClassName = ((pcmmm.Header)cell).getConcept().eClass().getInstanceClassName();
			if(instanceClassName.equals(PRODUCT_CLASS_NAME)){
				isHeaderProduct = true;
			}
			else if(instanceClassName.equals(FEATURE_CLASS_NAME)){
				isHeaderFeature = true;
			}
			else if(instanceClassName.equals(EXTRA_CLASS_NAME)){
				isExtra=true;
			}
			else if(instanceClassName.equals(VALUED_CELL_CLASS_NAME)){
				isValued=true;
			}
			else {
				_LOGGER.info(instanceClassName + " not supported");
			}
		}
	}
	
	/**
	 * precondition : cell should be a VALUED_CELL_CLASS_NAME 
	 * 
	 * @param cell
	 * @return a 
	 */
	private ICellContent createCellContent(Cell cell){
		ICellContent myCell;
		
		if(cell.eClass().getInstanceClassName().equals(HEADER_CLASS_NAME)){
			
		}
		
		return myCell;
	}
	
	@Override
	public int getId() {
		return id;
	}

	@Override
	public void setId(int id) {
		this.id = id;
	}
	
	@Override
	public int getRowSpan() {
		return this.rowSpan;
	}



	public void setRowSpan(int rowSpan) {
		this.rowSpan = rowSpan;
	}

	@Override
	public int getColumnSpan() {
		return columnSpan;
	}

	@Override
	public void setColumnSpan(int columnSpan) {
		this.columnSpan = columnSpan;
	}


	
	@Override
	public String getName() {
		return name;
	}

	@Override
	public void setName(String name) {
		this.name=name;
	}

	@Override
	public String getVerbatim() {
		return verbatim;
	}

	@Override
	public void setVerbatim(String verbatim) {
		this.verbatim=verbatim;
	}

	@Override
	public int getRow() {
		return this.row;
	}

	@Override
	public void setRow(int row) {
		this.row=row;

	}

	@Override
	public int getColumn() {
		return this.column;
	}

	@Override
	public void setColumn(int column) {
		this.column=column;
	}


	@Override
	public ICellContent getCellContent() {
		return this.cellContent;
	}

	@Override
	public void setCellContent(ICellContent iCellContent) {
		this.cellContent=iCellContent;
	}
	
	@Override
	public boolean isHeaderProduct() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isHeaderFeature() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isExtra() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isValued() {
		// TODO Auto-generated method stub
		return false;
	}
	
}
