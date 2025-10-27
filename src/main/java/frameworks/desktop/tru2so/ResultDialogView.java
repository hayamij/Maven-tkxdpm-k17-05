package frameworks.desktop.tru2so;

import javax.swing.*;

import interfaceadapters.tru2so.Tru2SoViewModel;
import frameworks.desktop.Subscriber;

public class ResultDialogView implements Subscriber {
	private Tru2SoViewModel model;
	
	public void setModel(Tru2SoViewModel model) {
		this.model = model;
		//đăng ký view với model
		model.addSubscriber(this);
	}
	
	@Override
	public void update() {
		try {
			JLabel message = new JLabel("Result: " + model.result);
			JOptionPane.showMessageDialog(null,
				message);
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, 
				"Result: " + model.result);
		}
	}
}
