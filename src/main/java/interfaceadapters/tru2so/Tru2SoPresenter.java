package interfaceadapters.tru2so;

import usecases.tru2so.OutputData;
import usecases.tru2so.OutputInterface;

public class Tru2SoPresenter implements OutputInterface {
	private Tru2SoViewModel model;
	
	public Tru2SoPresenter() {
	}
	
	public Tru2SoPresenter(Tru2SoViewModel model) {
		this.model = model;
	}
	
	public Tru2SoViewModel getModel() {
		return model;
	}
	
	@Override
	public void present(OutputData outData) {
		model.result = String.valueOf(outData.result);
		model.laChan = outData.laChan;
	}
}
