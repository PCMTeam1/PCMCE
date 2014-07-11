package fr.istic.dugl.pcmce.ui;

import java.awt.Label;
import java.util.Collection;

import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.TabPanel;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.VerticalPanel;

import fr.istic.dugl.pcmce.PCMReader.EnumPCMImpl;
import fr.istic.dugl.pcmce.PCMReader.ICell;
import fr.istic.dugl.pcmce.PCMReader.ICellContentString;
import fr.istic.dugl.pcmce.PCMReader.IMatrix;
import fr.istic.dugl.pcmce.PCMReader.IPCM;
import fr.istic.dugl.pcmce.PCMReader.IPCMFactory;
import fr.istic.dugl.pcmce.PCMReader.PCMFactory;


public class DetailPCMUi extends VerticalPanel{
	
	static final int numModule = 2;

	Button editPCM = new Button("Edit");
	static Grid grid = new Grid();

	public DetailPCMUi() {
			init();
	}

	public void init() {
		
		// testIncludeMatrice();
		
		this.add(grid);
		this.add(editPCM);		
		grid.setTitle("waiting for loading PCMs");
		grid.resize(50, 25);
	}

	
	public static void generateGrid(IMatrix matrix){
		
		int nbRows = matrix.getNbRows();
		int nbColumns = matrix.getNbColumn();
		
		grid.setTitle(matrix.getName());
		grid.resize(nbRows, nbColumns);
		
		/*
		String matrixContent="";
		matrixContent+="<p><b>Features List : </b>";
		for(ICell header  : myMatrix.getListHeaderFeatureCells()){
			matrixContent+= header.getVerbatim()+ "\t";
		}
		matrixContent+="</p><p>";
		
		matrixContent+="<b>Product List : </b>";
		for(ICell header  : myMatrix.getListHeaderProductCells()){
			matrixContent+= header.getVerbatim()+ "\t";
		}
		
		
		
		for(int i=0; i<myMatrix.getNbRows(); i++){
			matrixContent+="<tr>";
			for(int j=0; j<myMatrix.getNbColumn(); j++){
				ICell myCell = myMatrix.getTabAllCells()[i][j];
				if(myCell.getCellContent().isString()){
				matrixContent+="<td>"+((ICellContentString)myCell.getCellContent()).getString()+"</td>";
				}
			}
			matrixContent+="</td>";
		}
		

		*/
		
	}
	
}
