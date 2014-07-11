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
			for (String s : getPCMFileNames("../war/input/")) {
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
	public Collection<String> generateDETAIL_PCM(String PCM){
		
		IPCMFactory myPCMFactory = new PCMFactory();
		IPCM myPCM = myPCMFactory.getPCM(EnumPCMImpl.PCMImplDUGL);
		myPCM.loadPCM(PCM);
		IMatrix myMatrix = myPCM.getMatrices().get(0);
		
		List<String> theMatrix = new ArrayList<String>();
		String htmlContent = "";
		
		List<ICell> allCell = myMatrix.getListAllCells();
		
		for(ICell cell : allCell){
			htmlContent = htmlContent+" "+cell.getVerbatim();
		}
		
		
		int nbRows = myMatrix.getNbRows();
		int nbColumns = myMatrix.getNbColumn();
			
		theMatrix.add(0, String.valueOf(nbRows));
		theMatrix.add(1, String.valueOf(nbColumns));
		theMatrix.add(2, htmlContent);
		
		return theMatrix;
	}


	@Override
	public Collection<String> generateMatrixList(String PCM) {
		// TODO Auto-generated method stub
		return null;
	};
}
