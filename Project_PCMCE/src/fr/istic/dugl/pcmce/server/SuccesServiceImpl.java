package fr.istic.dugl.pcmce.server;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import fr.istic.dugl.pcmce.client.SuccesService;

public class SuccesServiceImpl extends RemoteServiceServlet implements SuccesService {

	public String getPCMFile() {
		String str="test";
		return str;
	};

	public Collection<String> generateDETAIL_PCM(String MyPCM){
		List<String> col = new ArrayList<String>();
		return col;
	};
}
