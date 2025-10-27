package frameworks.desktop.chia2so;

import javax.swing.*;

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
		try {
			JLabel message;
			if (model.errorMessage != null) {
				message = new JLabel("Error: " + model.errorMessage);
			} else {
				message = new JLabel("Result: " + model.result);
			}
			JOptionPane.showMessageDialog(null, message);
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null,
				"Result: " + model.result);
		}
	}
}
