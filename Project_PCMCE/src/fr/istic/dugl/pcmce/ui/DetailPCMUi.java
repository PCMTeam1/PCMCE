package fr.istic.dugl.pcmce.ui;

import java.awt.Label;
import java.util.Collection;
import java.util.List;

import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.HTMLTable;
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

	
	public static void generateGrid(List<String> matrix){
		
		int Rows =Integer.valueOf(matrix.get(0)).intValue();
		int Columns = Integer.valueOf(matrix.get(1)).intValue();
		String html = matrix.get(2);

		grid.resize(Rows, Columns);
		grid.setText(Rows, Columns, html);
	
		
	}
	
}
