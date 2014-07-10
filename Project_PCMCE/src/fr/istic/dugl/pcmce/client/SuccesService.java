package fr.istic.dugl.pcmce.client;

import java.util.Collection;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;


@RemoteServiceRelativePath("succes")
public interface SuccesService extends RemoteService {

	public Collection<String> getPCMFileList();
	public Collection<String> generateDETAIL_PCM(String MyPCM);
	
}


