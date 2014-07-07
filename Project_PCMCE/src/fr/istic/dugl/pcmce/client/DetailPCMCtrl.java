package fr.istic.dugl.pcmce.client;

import java.util.Collection;

import com.google.gwt.user.client.rpc.AsyncCallback;

import fr.istic.dugl.pcmce.ui.AccueilPCMUi;
import fr.istic.dugl.pcmce.ui.DetailPCMUi;

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
				DetailPCMUi page = (DetailPCMUi) MesModules.DETAIL_PCM.getPanel();
				// page.init(result);
				//AccueilPCMUi.
				//Project_PCMCE.show(MesModules.DETAIL_PCM)
			}
		}); 
	}
}



