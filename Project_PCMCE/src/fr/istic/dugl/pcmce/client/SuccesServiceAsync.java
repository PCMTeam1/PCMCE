package fr.istic.dugl.pcmce.client;

import java.util.Collection;
import java.util.List;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface SuccesServiceAsync {

	void getPCMFileList(AsyncCallback<Collection<String>> callback);

	void generateDETAIL_PCM(String PCM,
			AsyncCallback<Collection<String>> callback);
}

