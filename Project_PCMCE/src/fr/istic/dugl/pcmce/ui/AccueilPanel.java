package fr.istic.dugl.pcmce.ui;
 
import com.google.gwt.user.client.ui.RootPanel;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;

public class AccueilPanel extends HLayout{

	VLayout table = new VLayout();
	static final int NAME_COLUMN = 0;
	
	public AccueilPanel() {
		this.addMember(table);
	}
	
	public AccueilPanel(VLayout AccueilPanel){
		AccueilPanelInit();
	}
	
	
	public void AccueilPanelInit(){
		
		DynamicForm form = new DynamicForm();
		
		TextItem txtLoadFile = new TextItem();
		txtLoadFile.setTitle("Enter your URL here");
		txtLoadFile.setHint("<nobr>Please enter your PCM url here</nobr>");
		
		form.setFields(txtLoadFile);
		table.addMember(form);
		
		RootPanel.get("formContainer").add(this);
	}
}
