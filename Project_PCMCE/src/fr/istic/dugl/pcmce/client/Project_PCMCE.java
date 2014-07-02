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
		
		deckPanel.add(MesPages.ACCUEIL_PCM.getPanel());
		Project_PCMCE.show(MesPages.ACCUEIL_PCM);
		// generateSAISIR_PCM();
	}

	public static void show(MesPages page) {
		deckPanel.showWidget(page.ordinal());
	}
	
	public static void show(MesModules module) {
		deckPanel.showWidget(module.ordinal());
	}
	
	public static SuccesServiceAsync getSuccesservice() {
		return succesService;
	}
}
