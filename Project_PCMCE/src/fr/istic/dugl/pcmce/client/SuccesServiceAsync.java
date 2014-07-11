package fr.istic.dugl.pcmce.client;

import java.util.Collection;
import java.util.List;

import com.google.gwt.user.client.rpc.AsyncCallback;

import fr.istic.dugl.pcmce.PCMReader.IMatrix;

public interface SuccesServiceAsync {

	void getPCMFileList(AsyncCallback<Collection<String>> callback);

	void generateDETAIL_PCM(String PCM,
			AsyncCallback<IMatrix> callback);
	
	void generateMatrixList(String PCM,
			AsyncCallback<Collection<String>> asyncCallback);
}

