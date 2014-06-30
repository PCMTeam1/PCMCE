package fr.istic.dugl.pcmce.client;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Logger;


import org.junit.Test;




/**
 * Basic tests for the PCM reader
 * @author macher1
 *
 */
public class PCMReaderAnalyseTest {
	
	private static Logger _LOGGER = Logger.getLogger("PCMReaderTest");
	
	/**
	 * very simple test for the reader 
	 */
	
	
	@Test
	public void testPCMFirstTest(){
		String fileName = "Comparison_of_BitTorrent_tracker_software.pcm" ;
		PCM p = new PCMReader().getPCM(fileName);
	//	_LOGGER.info("Mon test" + p.getName());
		
		
		
		EList<Matrix> listeMatrice = p.getMatrices();
		Matrix maMatrice =   listeMatrice.get(0);
		EList<Cell> cells = maMatrice.getCells();
		
		int cellsCounter = 0;
		String verbatim,note,link ="";
		String output = "\n";
		Cell thatCell;
		int column, row, colSpan, rowSpan;
		List maListe;
		int nbColumns = 0, nbRows = 0;
		
		for (Iterator<Cell> it = cells.iterator(); it.hasNext();){
			thatCell = it.next();
			column = thatCell.getColumn();
			row =  thatCell.getRow();
			if(row>nbRows) {nbRows=row;}
			if(column>nbColumns) {nbColumns=column;}
			rowSpan = thatCell.getRowspan();
			colSpan = thatCell.getColspan();
			verbatim = thatCell.getVerbatim();
			
			output += (//"colSpan : "+ colSpan+"\trowSpan : " + rowSpan+
					   "\tcolumn : " + column + "\trow : " + row + "\tcontent : " + verbatim + "\n");
			cellsCounter++;
		}
		
		nbColumns++; nbRows++;
		_LOGGER.info("Nombre de cellules : " + cellsCounter+ " Nb colones : " +nbColumns + " NbLignes : " + nbRows);
		_LOGGER.info(output);
		
		
		String[][] tabCells = new String[nbRows][nbColumns];
		for(Cell maCell : cells){
			
		}
		
		for (Iterator<Cell> it = cells.iterator(); it.hasNext();){
			thatCell = it.next();
			column = thatCell.getColumn();
			row =  thatCell.getRow();
			verbatim = thatCell.getVerbatim();
			tabCells[row][column]= verbatim;
			
		}
		
		String matrixContent="<html><body><table>";
		
		for(int i=0; i<nbRows; i++){
			matrixContent+="<tr>";
			for(int j=0; j<nbColumns; j++){
				matrixContent+="<td>"+tabCells[i][j]+"</td>";
			}
			matrixContent+="</td>";
		}
		matrixContent+="</table>";
		//_LOGGER.info(matrixContent);
		
		try{
		 PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("Comparison_of_BitTorrent_tracker_software.pcm.html")));
		 
		 out.write(matrixContent);
		 out.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	@Test
	public void testConcepts(){
		
		String fileName = "Comparison_of_BitTorrent_tracker_software.pcm" ;
		PCM p = new PCMReader().getPCM(fileName);
		EList<VariabilityConcept> listConcept = p.getConcepts();
		String trace = "Concepts name : \n";
		for(VariabilityConcept concept : listConcept){
			trace+=concept.getName()+"\n";
		}
		//_LOGGER.info(trace);
	}
	
	
	/**
	 * Utility function
	 * @param dir
	 * @return set of filenames contained in the directory dir
	 */
	public static Collection<String> getPCMFileNames(String dir) {

		File fDir = new File(dir);
		List<String> results = new ArrayList<String>();
		File[] files = fDir.listFiles(); // TODO: filter .pcm files

		for (File file : files) {
		    if (file.isFile()) {
		        results.add(file.getName());
		    }
		}
		return results ; 

		
		
	}
	
	
}
