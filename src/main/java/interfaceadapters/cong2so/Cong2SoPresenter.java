package interfaceadapters.cong2so;

import usecases.cong2so.OutputData;
import usecases.cong2so.OutputInterface;

public class Cong2SoPresenter implements OutputInterface {
	private Cong2SoViewModel model;
	
	public Cong2SoPresenter() {
	}
	
	public Cong2SoPresenter(Cong2SoViewModel model) {
		this.model = model;
	}
	
	public Cong2SoViewModel getModel() {
		return model;
	}
	
	@Override
	public void present(OutputData outData) {
		model.result = String.valueOf(outData.result);
		model.laChan = outData.laChan;
	}
}
