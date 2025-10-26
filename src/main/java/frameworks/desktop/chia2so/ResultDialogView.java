package frameworks.desktop.chia2so;

import javax.swing.JOptionPane;

import interfaceadapters.chia2so.Chia2SoViewModel;
import frameworks.desktop.Subscriber;

public class ResultDialogView implements Subscriber {
	private Chia2SoViewModel model;
	
	
	public void setModel(Chia2SoViewModel model) {
		this.model = model;
		//đăng ký view với model
		model.addSubscriber(this);
	}
	
	@Override
	public void update() {
		if (model.hasError) {
			JOptionPane.showMessageDialog(null, 
					"Error: " + model.result, 
					"Lỗi", 
					JOptionPane.ERROR_MESSAGE);
		} else {
			JOptionPane.showInternalMessageDialog(null, 
					"Result: " + model.result);
		}
	}

}
