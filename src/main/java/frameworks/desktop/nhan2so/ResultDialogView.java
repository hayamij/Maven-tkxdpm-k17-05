package frameworks.desktop.nhan2so;

import javax.swing.*;
import java.awt.*;

import interfaceadapters.nhan2so.Nhan2SoViewModel;
import frameworks.desktop.Subscriber;

public class ResultDialogView implements Subscriber {
	private Nhan2SoViewModel model;
	
	public void setModel(Nhan2SoViewModel model) {
		this.model = model;
		//đăng ký view với model
		model.addSubscriber(this);
	}
	
	@Override
	public void update() {
		try {
			if (model.errorMessage != null) {
				JLabel message = new JLabel("Error: " + model.errorMessage);
				JOptionPane.showMessageDialog(null, message);
				return;
			}
			Color color;
			if (model.color.equals("red")) {
				color = Color.RED;
			} else if (model.color.equals("green")) {
				color = Color.GREEN;
			} else {
				color = Color.BLACK;
			}
			JLabel message = new JLabel("Result: " + model.result);
			message.setForeground(color);
			JOptionPane.showMessageDialog(null,
				message);

		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, 
				"Result: " + model.result);
		}
	}
}
