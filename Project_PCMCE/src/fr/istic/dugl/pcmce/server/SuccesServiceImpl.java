package fr.istic.dugl.pcmce.server;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.servlet.http.HttpSession;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import fr.istic.dugl.pcmce.PCMReader.EnumPCMImpl;
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
	
	

	public IMatrix generateDETAIL_PCM(String MyPCM){
		
		IPCMFactory myPCMFactory = new PCMFactory();
		IPCM myPCM = myPCMFactory.getPCM(EnumPCMImpl.PCMImplDUGL);
		myPCM.loadPCM(MyPCM);
		IMatrix myMatrix = myPCM.getMatrices().get(0);
				
		return myMatrix;
	}


	@Override
	public Collection<String> generateMatrixList(String PCM) {
		// TODO Auto-generated method stub
		return null;
	};
}
