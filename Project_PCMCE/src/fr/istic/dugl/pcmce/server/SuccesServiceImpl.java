package fr.istic.dugl.pcmce.server;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.servlet.http.HttpSession;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

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
	
	

	public Collection<String> generateDETAIL_PCM(String MyPCM){
		List<String> col = new ArrayList<String>();
		return col;
	};
}
