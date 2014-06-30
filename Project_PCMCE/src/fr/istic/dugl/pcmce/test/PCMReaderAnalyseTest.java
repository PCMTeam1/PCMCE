package fr.istic.dugl.pcmce.test;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Logger;

import org.eclipse.emf.common.util.EList;
import org.junit.Test;

import fr.istic.dugl.pcmce.PCMReader.PCMReader;
import pcmmm.Cell;
import pcmmm.Constraint;
import pcmmm.Feature;
import pcmmm.Matrix;
import pcmmm.Multiple;
import pcmmm.PCM;
import pcmmm.Partial;
import pcmmm.Product;
import pcmmm.Simple;
import pcmmm.ValuedCell;
import pcmmm.VariabilityConcept;



/**
 * Basic tests for the PCM reader.
 * @author Yves LMDG
 *
 */
public class PCMReaderAnalyseTest {

	private static Logger _LOGGER = Logger.getLogger("PCMReaderTest");

	/**
	 * very simple test for the reader 
	 */


	@Test
	public void testPCMFirstTest(){
		String fileName = "Comparison_of_feed_aggregators.pcm" ;
		PCM p = new PCMReader().getPCM(fileName);
		//	_LOGGER.info("Mon test" + p.getName());



		EList<Matrix> listeMatrice = p.getMatrices();
		Matrix maMatrice =   listeMatrice.get(3);
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
		//_LOGGER.info("Nombre de cellules : " + cellsCounter+ " Nb colones : " +nbColumns + " NbLignes : " + nbRows);
		//_LOGGER.info(output);


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

		String matrixContent="<html><body><title>"+maMatrice.getName()  +"</title><h1>"+maMatrice.getName() +"</h1><table>";

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
			PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("Comparison_of_feed_aggregators.pcm.Matrice4.html")));

			out.write(matrixContent);
			out.close();
		}catch(Exception e){
			e.printStackTrace();
		}

	}

	@Test
	public void testConcepts(){

		String fileName = "Comparison_of_free_web_hosting_services.pcm" ;
		PCM p = new PCMReader().getPCM(fileName);
		EList<VariabilityConcept> listConcept = p.getConcepts();
		String trace = "Comparison_of_free_web_hosting_services.pcm\n";
		int i=0,j=0;
		for(VariabilityConcept concept : listConcept){
			trace += "concept.getName() :"+concept.getName() + "\t";
			List<ValuedCell> listValuedCell= concept.getConstraints();
			for(ValuedCell valuedCell : listValuedCell){
				trace += " "+(valuedCell.getInterpretation().getClass())  + " valuedCell.getInterpretation().getVerbatim() : " +valuedCell.getInterpretation().getVerbatim();
				/**
				for (String note :valuedCell.getNote()){
					trace += "Note : "+ note+ " ";
				}
				trace+=("valuedCell.getName() " + valuedCell.getName() + "  "+ i++ +"--\t");
				List<AbstractFeature> listAbsFeature = valuedCell.getMyHeaderFeatures();
				for(AbstractFeature absFeature : listAbsFeature){
					trace += "getMyHeaderFeatures() : "+ absFeature.getName()+"  "+ j++ + "\t";
				}
				List<AbstractProduct> listAbsProduct = valuedCell.getMyHeaderProducts();
				for(AbstractProduct absProduct : listAbsProduct){
					trace += "getMyHeaderProducts() : "+ absProduct.getName()+"\t";
					for (Cell cell : absProduct.getMyValuedCells()){
						trace += "cell.getName() "+cell.getName() + "\t";
					}
					trace +="\n";
				}
				 **/
			}
			trace+="\n";

		}
		//_LOGGER.info(trace);
	}


	@Test 
	public void testMatrixMultiple(){
		String fileName = "Comparison_of_feed_aggregators.pcm" ;
		String trace="";
		int count = 0;
		PCM p = new PCMReader().getPCM(fileName);
		for(Matrix matrice : p.getMatrices()){
			trace +=  " Matrice : " + count++ +"  "+ matrice.getName()+"\t";

		}
		_LOGGER.info(trace);
	}

	@Test 
	public void testFeature(){
		String fileName = "Comparison_of_feed_aggregators.pcm" ;
		String trace="";
		int count = 0;
		PCM p = new PCMReader().getPCM(fileName);
		trace += "<html><body>";
		/**
		for(Matrix matrice : p.getMatrices()){
			trace +=  " Matrice : " + count++ +"  "+ matrice.getName()+"\t";
		 **/
		trace+="<table border='1'>\n";

		for(VariabilityConcept concept: p.getConcepts()){
			trace+="<tr>";
			trace+="<td>";
			trace +=concept.getName();
			trace+="</td>";
			trace+="<td>";
			trace +=concept.getClass().getSimpleName();
			trace+="</td>";
			trace+="<td>";
			if(concept instanceof Feature){
				trace +="Feature";
				trace+="<table border='1'>";
				pcmmm.Enum enumSimple =(pcmmm.Enum) ((Feature) concept).getDomain();
				for(Simple  simple : enumSimple.getValues() ){
					trace +="<tr>";
					trace+="<td>"+simple.getVerbatim()+"</td>";	
					trace+="<td>"+simple.getClass().getSimpleName()+"</td>";
					trace+="</tr>";
				}

				trace+="</table>";

			}
			if(concept instanceof Product){
				trace +="Product";
			}
			trace+="</td></tr>";
		}
		trace+="\n</table><br/>";
		//	}
		trace+="</body></html>";

		try{
			PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("output.html")));

			out.write(trace);
			out.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		//_LOGGER.info(trace);
	}

	@Test 
	public void testConstrainType(){
		String fileName = "Comparison_of_code_generation_tools.pcm" ;
		String trace="";
		int count = 0;
		PCM p = new PCMReader().getPCM(fileName);
		trace += "<html><body>";

		for(Matrix matrice : p.getMatrices()){
			trace +=  " Matrice : " + count++ +"  "+ matrice.getName()+"\t";

			trace+="<table border='1'>\n";
			for(Cell cell : matrice.getCells()){

				trace +="<tr>";
				trace+="<td>"+cell.getRow()+","+cell.getColumn()+"</td>";
				trace+="<td>"+cell.getVerbatim()+"</td>";	
				trace+="<td>"+cell.eClass().getInstanceClassName()+"</td>";


				if(cell instanceof ValuedCell){
					ValuedCell valuedCell=(ValuedCell)cell;
					trace+="<td>"+valuedCell.getInterpretation().eClass().getInstanceClassName();
					if(valuedCell.getInterpretation() instanceof Partial){
						trace+="</td><td>";
						trace+=((Partial)valuedCell.getInterpretation()).getArgument().eClass().getInstanceClassName();
						trace+="</td>";


						Constraint condition = ((Partial)valuedCell.getInterpretation()).getCondition();
						trace+="<td>";
						trace+=condition.eClass().getInstanceClassName();

						if(condition instanceof Multiple){
							trace+=outputMultipleConstraint((Multiple)condition);
						}

						trace+="</td>";
					}
					if(valuedCell.getInterpretation() instanceof Multiple){
						//trace+="<td>";
						trace+=outputMultipleConstraint((Multiple)valuedCell.getInterpretation());
						trace+="</td>";
					}





				}

			}
			trace+="</tr>";

		}

		trace+="\n</table><br/>";

		trace+="</body></html>";

		try{
			PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("TestTypesComparison_of_code_generation_tools.pcm.html")));

			out.write(trace);
			out.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		//_LOGGER.info(trace);
	}

	protected String outputMultipleConstraint(Multiple condition){
		String output ="";

		output+="<table border='1'>";
		Multiple multCond = (Multiple)condition;
		for(Constraint constraint : multCond.getContraints()){
			output+="<tr>";
			output+="<td>";
			output+=constraint.eClass().getInstanceClassName();

			if(constraint instanceof Multiple){
				//output+="<td>";
				output+=outputMultipleConstraint((Multiple)constraint);
				//output+="</td>";
			}
			output+="</td></tr>";
		}
		output+="</table>";
		return output;
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
