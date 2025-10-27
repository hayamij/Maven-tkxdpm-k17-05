package interfaceadapters.nhan2so;

import usecases.nhan2so.OutputData;
import usecases.nhan2so.OutputInterface;

public class Nhan2SoPresenter implements OutputInterface {
	private Nhan2SoViewModel model;
	
	public Nhan2SoPresenter() {
	}
	
	public Nhan2SoPresenter(Nhan2SoViewModel model) {
		this.model = model;
	}
	
	public Nhan2SoViewModel getModel() {
		return model;
	}
	
	@Override
	public void present(OutputData outData) {

		Nhan2SoViewModel model = this.getModel();

		if (outData.errorMessage.length() > 0) {
			model.errorMessage = outData.errorMessage;
			model.result = null;
			return;
		}

		if (model.color == null) {
			model.color = "black";
		} else if (outData.isOdd) {
			model.color = "red";
		} else {
			model.color = "blue";
		}
		
		model.result = String.valueOf(outData.result);
		
	}
}
