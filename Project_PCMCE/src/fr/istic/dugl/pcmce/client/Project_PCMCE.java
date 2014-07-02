package fr.istic.dugl.pcmce.client;

import java.util.Collection;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.DeckPanel;
import com.google.gwt.user.client.ui.RootPanel;

import fr.istic.dugl.pcmce.client.MesPages;
import fr.istic.dugl.pcmce.client.SuccesServiceAsync;
import fr.istic.dugl.pcmce.client.SuccesService;
import fr.istic.dugl.pcmce.ui.generateDETAIL_PCM;
import fr.istic.dugl.pcmce.ui.generateSAISIR_PCM;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class Project_PCMCE implements EntryPoint {

	private final static SuccesServiceAsync succesService = GWT.create(SuccesService.class);
	
	static private DeckPanel deckPanel = new DeckPanel();
		
	@Override
	public void onModuleLoad() {
		RootPanel.get("Project_PCMCE").add(deckPanel);
		deckPanel.add(MesPages.SAISIR_PCM.getPanel());
		deckPanel.add(MesPages.DETAIL_PCM.getPanel());
		
		generateSAISIR_PCM();
	}
	
	public static void show(MesPages page) {
		deckPanel.showWidget(page.ordinal());
	}

	private  void generateSAISIR_PCM() {


         succesService.getPCMFile(new AsyncCallback<String>() {

			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onSuccess(String result) {
				generateSAISIR_PCM page = (generateSAISIR_PCM) MesPages.SAISIR_PCM.getPanel();
				page.init("test");
				Project_PCMCE.show(MesPages.SAISIR_PCM);
				
			}
		}); 
	}
	
	
	public static void generateDETAIL_PCM(String PCM) {


        succesService.generateDETAIL_PCM(PCM ,new AsyncCallback<Collection<String>>() {

			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onSuccess(Collection<String> result) {
				generateDETAIL_PCM page = (generateDETAIL_PCM) MesPages.DETAIL_PCM.getPanel();
				//page.init((List<String>) result);
				Project_PCMCE.show(MesPages.DETAIL_PCM);
				
			}
		}); 
	}
	
	
}
