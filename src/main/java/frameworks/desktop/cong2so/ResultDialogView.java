package frameworks.desktop.cong2so;

import javax.swing.*;
import java.awt.*;

import interfaceadapters.cong2so.Cong2SoViewModel;
import frameworks.desktop.Subscriber;

public class ResultDialogView implements Subscriber {
	private Cong2SoViewModel model;
	
	public void setModel(Cong2SoViewModel model) {
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
