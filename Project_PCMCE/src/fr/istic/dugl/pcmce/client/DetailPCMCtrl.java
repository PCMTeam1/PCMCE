package fr.istic.dugl.pcmce.client;

import java.util.Collection;

import com.google.gwt.user.client.rpc.AsyncCallback;

import fr.istic.dugl.pcmce.ui.generateDETAIL_PCM;

public class DetailPCMCtrl {
	
	
	public DetailPCMCtrl(){

	}
	
	public static void generateDETAIL_PCM(String PCM) {

		SuccesServiceAsync succesService = Project_PCMCE.getSuccesservice();
		succesService.generateDETAIL_PCM(PCM ,new AsyncCallback<Collection<String>>() {

			@Override
			public void onFailure(Throwable caught) {
			}

			@Override
			public void onSuccess(Collection<String> result) {
				generateDETAIL_PCM page = (generateDETAIL_PCM) MesModules.DETAIL_PCM.getPanel();
				page.init(result);
				Project_PCMCE.show(MesModules.DETAIL_PCM);
			}
		}); 
	}
}



