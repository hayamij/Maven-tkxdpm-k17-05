package interfaceadapters.chia2so;

import usecases.chia2so.OutputData;
import usecases.chia2so.OutputInterface;

public class Chia2SoPresenter implements OutputInterface {
	private Chia2SoViewModel model;
	
	public Chia2SoPresenter() {
	}
	
	public Chia2SoPresenter(Chia2SoViewModel model) {
		this.model = model;
	}
	
	public Chia2SoViewModel getModel() {
		return model;
	}
	
	@Override
	public void present(OutputData outData) {
		if (outData.errorMessage != null) {
			model.result = outData.errorMessage;
			model.hasError = true;
		} else {
			model.result = String.valueOf(outData.result);
			model.hasError = false;
		}
	}
}
