package fr.istic.dugl.pcmce.ui;

import java.util.List;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

import fr.istic.dugl.pcmce.client.DetailPCMCtrl;
import fr.istic.dugl.pcmce.client.MesModules;
import fr.istic.dugl.pcmce.client.Project_PCMCE;
import fr.istic.dugl.pcmce.client.SaisirPCMCtrl;


public class SaisirPCMUi extends VerticalPanel {
	
	static final int numModule = 1;
	
	HorizontalPanel BrowseBar = new HorizontalPanel();
	Label lblSelectPCM  = new Label("Select a PCM available : ");
	static ListBox lstPCMs = new ListBox();
	
	Button viewPCM = new Button("Load");
	
	public SaisirPCMUi() {
		new SaisirPCMCtrl();
		init();
	}

	public void init() {
		
		/*
		 * init ui components
		 */
		lstPCMs.setTitle("List of PCMs available on the server");
		BrowseBar.add(lblSelectPCM);
		BrowseBar.add(lstPCMs);
		BrowseBar.add(viewPCM);	
		this.add(BrowseBar);
		
		//OnePCM.setText(nom);
		viewPCM.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
					DetailPCMCtrl.generateDETAIL_PCM(lstPCMs.getTitle());
					String DetailPCM = "DetailPCM";
					Project_PCMCE.show(DetailPCM);
				}		
			});

	}
	
	public static void addPCMinList(List<String> noms){
		for (int i=0; i<noms.size(); i++) {
			lstPCMs.addItem(noms.get(i));
		}
	}

}

