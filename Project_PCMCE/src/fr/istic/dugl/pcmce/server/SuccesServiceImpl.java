package fr.istic.dugl.pcmce.server;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.servlet.http.HttpSession;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import fr.istic.dugl.pcmce.PCMReader.EnumPCMImpl;
import fr.istic.dugl.pcmce.PCMReader.ICell;
import fr.istic.dugl.pcmce.PCMReader.ICellContentString;
import fr.istic.dugl.pcmce.PCMReader.IMatrix;
import fr.istic.dugl.pcmce.PCMReader.IPCM;
import fr.istic.dugl.pcmce.PCMReader.IPCMFactory;
import fr.istic.dugl.pcmce.PCMReader.PCMFactory;
import fr.istic.dugl.pcmce.client.SuccesService;

public class SuccesServiceImpl extends RemoteServiceServlet implements SuccesService {

	@Override
	public Collection<String> getPCMFileList() {
		
			HttpSession session = this.getThreadLocalRequest().getSession();
			Collection<String> names = (Collection<String>) session.getAttribute("listOfPCMs");
			if (names == null) {
				names = new ArrayList<String>();
				session.setAttribute("listOfPCMs", names);
			}
			for (String s : getPCMFileNames("../input/")) {
				names.add(s);
			}
			return names;
	};
	
	public static Collection<String> getPCMFileNames(String directory) {

		File fDir = new File(directory);
		List<String> results = new ArrayList<String>();
		File[] files = fDir.listFiles();
		for (File file : files) {
			if (file.isFile()) {
				results.add(file.getName());
			}
		}
		return results;

	}

	@Override
	public Collection<String> generateDETAIL_PCM(String MyPCM){
		
		IPCMFactory myPCMFactory = new PCMFactory();
		IPCM myPCM = myPCMFactory.getPCM(EnumPCMImpl.PCMImplDUGL);
		myPCM.loadPCM(MyPCM);
		IMatrix myMatrix = myPCM.getMatrices().get(0);
		
		List<String> theMatrix = new ArrayList<String>();
		
		int nbRows = myMatrix.getNbRows();
		int nbColumns = myMatrix.getNbColumn();
		
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
		
		theMatrix.add(0, String.valueOf(nbRows));
		theMatrix.add(1, String.valueOf(nbColumns));
		theMatrix.add(3, matrixContent);
		
		
		return theMatrix;
	}


	@Override
	public Collection<String> generateMatrixList(String PCM) {
		// TODO Auto-generated method stub
		return null;
	};
}
