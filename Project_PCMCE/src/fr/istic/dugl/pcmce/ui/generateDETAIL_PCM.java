package fr.istic.dugl.pcmce.ui;

import java.util.Collection;

import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.TabPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

import fr.istic.dugl.pcmce.client.MyClick;

public class generateDETAIL_PCM extends VerticalPanel{
	ListBox ListBOx = new ListBox();

	public generateDETAIL_PCM () {
		this.add(ListBOx);
	}

	public void init(Collection<String> initCol) {
		
	}
}
