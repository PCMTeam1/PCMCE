package fr.istic.dugl.pcmce.client;

import java.util.Collection;
import java.util.List;

import com.google.gwt.user.client.rpc.AsyncCallback;

import fr.istic.dugl.pcmce.PCMReader.IMatrix;
import fr.istic.dugl.pcmce.ui.AccueilPCMUi;
import fr.istic.dugl.pcmce.ui.DetailPCMUi;
import fr.istic.dugl.pcmce.ui.SaisirPCMUi;

public class DetailPCMCtrl {
	
	public DetailPCMCtrl(){

	}
	
	public static void generateDETAIL_PCM(String PCM) {

		SuccesServiceAsync succesService = Project_PCMCE.getSuccesservice();
		succesService.generateDETAIL_PCM(PCM ,new AsyncCallback<IMatrix>() {

			@Override
			public void onFailure(Throwable caught) {
			}

			@Override
			public void onSuccess(IMatrix result) {
				DetailPCMUi.generateGrid(result);
			}
		}); 
	}
	
	
public static void generateMatrixList(String PCM) {

		SuccesServiceAsync succesService = Project_PCMCE.getSuccesservice();
		
		succesService.generateMatrixList(PCM ,new AsyncCallback<Collection<String>>() {

			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onSuccess(Collection<String> result) {
			//	generatePCMMatrix page = (generatePCMMatrix) MesPages.DETAIL_PCM.getPanel();
			//	page.init((List<String>) result);
			//	Pcm.show(MesPages.DETAIL_PCM);
				
			}
		}); 
	}
	
	
}



