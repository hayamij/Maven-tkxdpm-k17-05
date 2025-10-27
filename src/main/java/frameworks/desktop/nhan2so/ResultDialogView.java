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
			int result = Integer.parseInt(model.result);
			boolean laChan = model.laChan;
			
			// Tạo panel với màu nền tùy theo chẵn lẻ
			JPanel panel = new JPanel();
			panel.setLayout(new BorderLayout(10, 10));
			
			// Màu đỏ nếu chẵn, xanh lá nếu lẻ
			Color backgroundColor = laChan ? new Color(255, 200, 200) : new Color(200, 255, 200);
			panel.setBackground(backgroundColor);
			panel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
			
			// Label kết quả
			JLabel resultLabel = new JLabel("Kết quả: " + result, SwingConstants.CENTER);
			resultLabel.setFont(new Font("Arial", Font.BOLD, 20));
			resultLabel.setOpaque(true);
			resultLabel.setBackground(backgroundColor);
			
			// Label chẵn/lẻ
			String chanLeText = laChan ? "CHẴN" : "LẺ";
			JLabel chanLeLabel = new JLabel(chanLeText, SwingConstants.CENTER);
			chanLeLabel.setFont(new Font("Arial", Font.BOLD, 24));
			chanLeLabel.setForeground(laChan ? Color.RED : new Color(0, 150, 0));
			chanLeLabel.setOpaque(true);
			chanLeLabel.setBackground(backgroundColor);
			
			panel.add(resultLabel, BorderLayout.CENTER);
			panel.add(chanLeLabel, BorderLayout.SOUTH);
			
			JOptionPane.showMessageDialog(null, panel, 
				"Kết quả Nhân 2 số", JOptionPane.PLAIN_MESSAGE);
				
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, 
				"Result: " + model.result);
		}
	}
}
