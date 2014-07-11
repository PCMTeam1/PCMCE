package fr.istic.dugl.pcmce.client;

import java.util.Collection;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

import fr.istic.dugl.pcmce.PCMReader.IMatrix;


@RemoteServiceRelativePath("succes")
public interface SuccesService extends RemoteService {

	public Collection<String> getPCMFileList();
	public Collection<String> generateDETAIL_PCM(String MyPCM);
	public Collection<String> generateMatrixList(String PCM);
	
}


