package fr.istic.dugl.pcmce.client;

import com.google.gwt.user.client.rpc.AsyncCallback;

import fr.istic.dugl.pcmce.ui.generateSAISIR_PCM;
import fr.istic.dugl.pcmce.client.Project_PCMCE;

public class SaisirPCMCtrl {

	public SaisirPCMCtrl(){

	}

	public void generateSAISIR_PCM() {

		SuccesServiceAsync succesService = Project_PCMCE.getSuccesservice();

		succesService.getPCMFile(new AsyncCallback<String>() {

			@Override
			public void onFailure(Throwable caught) {
			}

			@Override
			public void onSuccess(String result) {
				generateSAISIR_PCM page = (generateSAISIR_PCM) MesModules.SAISIR_PCM.getPanel();
				page.init(result);
				Project_PCMCE.show(MesModules.SAISIR_PCM);
			}
		}); 
	}



}
