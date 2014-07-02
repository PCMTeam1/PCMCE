/**
 * @author Yves Le Monnier
 *
 */

package fr.istic.dugl.pcmce.PCMReader;
import java.util.ArrayList;
import java.util.List;

import pcmmm.Matrix;
import pcmmm.PCM;


public class PCMImplDUGL implements IPCM {
	
	private PCM pcm;
	private List<IMatrix> listMatrices;

	@Override
	public void loadPCM(String fileName){
		pcm = new PCMReader().getPCM(fileName);
		listMatrices = new ArrayList<>();
		
		for(Matrix m : pcm.getMatrices()){
			IMatrix myMatrix = new MatrixImplDUGL(m);
			listMatrices.add(myMatrix);
		}
	}
	
	@Override
	public String getTitle() {
		return pcm.getTitle();
	}

	@Override
	public void setTitle(String title) {
		pcm.setTitle(title);

	}

	@Override
	public List<String> getDescription() {
		return pcm.getDescription();
	}

	@Override
	public List<IMatrix> getMatrices() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getName() {
		return pcm.getName();
	}

	@Override
	public void setName(String name) {
		pcm.setName(name);

	}

}
