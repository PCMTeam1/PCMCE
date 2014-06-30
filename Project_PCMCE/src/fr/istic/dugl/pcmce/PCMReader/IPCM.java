package fr.istic.dugl.pcmce.PCMReader;

public interface IPCM {
	  
	  public java.lang.String getTitle();
	  
	  public void setTitle(java.lang.String title);

	  public java.util.List<String>  getDescription();  

	  public java.util.List<IMatrix>  getMatrices();

	  public java.lang.String getName();
	  
	  public void setName(java.lang.String name);
	  
}
