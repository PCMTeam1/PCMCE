import java.util.LinkedList;
import java.util.List;


public class PCMFactory implements IPCMFactory {
	@Override
	public IPCM getPCM(EnumPCMImpl pcm) {
		
		switch (pcm)
		{
		case PCMImplDUGL:
			return new PCMImplDUGL();
		default:
			return new PCMImplDUGL();
		}
	}
}
