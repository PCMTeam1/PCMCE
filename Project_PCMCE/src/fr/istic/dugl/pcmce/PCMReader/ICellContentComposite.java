package fr.istic.dugl.pcmce.PCMReader;

import java.util.List;

public interface ICellContentComposite extends ICellContent {
	public List<ICellContent> getComposite();
	
	public void setComposite(List<ICellContent> value);
}
