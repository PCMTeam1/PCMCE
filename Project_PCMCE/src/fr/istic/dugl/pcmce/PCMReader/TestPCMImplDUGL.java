/**
 * @author Yves Le Monnier
 *
 */
package fr.istic.dugl.pcmce.PCMReader;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.logging.Logger;

import org.junit.Test;

public class TestPCMImplDUGL {

	@Test
	public void test() {
		
		IPCMFactory myPCMFactory = new PCMFactory();
		IPCM myPCM = myPCMFactory.getPCM(EnumPCMImpl.PCMImplDUGL);
		myPCM.loadPCM("Comparison_of_Business_Process_Modeling_Notation_tools.pcm");
		IMatrix myMatrix = myPCM.getMatrices().get(0);

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
		matrixContent+="</p>";
		matrixContent+="<p> myMatrix.isFirstRowHeaderFeatures() : "+ myMatrix.isFirstRowHeaderFeatures() +"<p>";
		
		matrixContent+="<p> myMatrix.getNbHeaderFeatureRows() : "+ myMatrix.getNbHeaderFeatureRows() +"<p>";
		matrixContent+="<p> myMatrix.getNbHeaderFeatureColumn() : "+ myMatrix.getNbHeaderFeatureColumn() +"<p>";
		
		matrixContent+="<p> myMatrix.getNbHeaderProductRow() : "+ myMatrix.getNbHeaderProductRow()+"<p>";
		matrixContent+="<p> myMatrix.getNbHeaderProductColumn() : "+ myMatrix.getNbHeaderProductColumn()+"<p>";
		
		
		matrixContent+="<html><body><title>"+myMatrix.getName()  +"</title><h1>"+myMatrix.getName() +"</h1><table>";
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
		matrixContent+="</table>";
		//_LOGGER.info(matrixContent);

		try{
			PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("others/Comparison_of_Business_Process_Modeling_Notation_tools.pcm-testImpl.html")));

			out.write(matrixContent);
			out.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	

}
