package fr.istic.dugl.pcmce.client;

import java.util.Collection;
import java.util.List;

import com.google.gwt.user.client.rpc.AsyncCallback;

import fr.istic.dugl.pcmce.ui.SaisirPCMUi;
import fr.istic.dugl.pcmce.client.Project_PCMCE;

public class SaisirPCMCtrl {

	public SaisirPCMCtrl(){
		init();
	}
	
	public void init(){
		listePCM();
	}

	private void listePCM() {

		SuccesServiceAsync succesService = Project_PCMCE.getSuccesservice();
		succesService.getPCMFileList(new AsyncCallback<Collection<String>>() {

			@Override
			public void onFailure(Throwable caught) {
			}

			@Override
			public void onSuccess(Collection<String> result) {
				SaisirPCMUi.addPCMinList((List<String>) result);
			}
		}); 
	}
	
	/*
	public Collection<String> generateSAISIR_PCM() {

		SuccesServiceAsync succesService = Project_PCMCE.getSuccesservice();

		succesService.getPCMFile(new AsyncCallback<Collection<String>>() {

			@Override
			public void onFailure(Throwable caught) {
			}

			@Override
			public void onSuccess(Collection<String> result) {
			//	SaisirPCMUi page = (SaisirPCMUi) MesModules.SAISIR_PCM.getPanel();
				Collection<String>	
			//	page.init(result);
			//	Project_PCMCE.show(MesModules.SAISIR_PCM);
			}
		}); 
	}

	*/

}
