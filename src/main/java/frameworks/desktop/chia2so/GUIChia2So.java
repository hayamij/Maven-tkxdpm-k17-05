package frameworks.desktop.chia2so;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import interfaceadapters.chia2so.InputDTO;
import interfaceadapters.chia2so.Chia2SoController;
import interfaceadapters.chia2so.Chia2SoPresenter;
import interfaceadapters.chia2so.Chia2SoViewModel;
import entities.chia2so.Chia2So;
import usecases.chia2so.Chia2SoUseCaseControl;

public class GUIChia2So extends JFrame {
	
	public GUIChia2So() {
		GridLayout grid = new GridLayout(3, 2);
		setLayout(grid);
		
		JLabel lbl1 = new JLabel("Number 1:");
		add(lbl1); //dòng 1 cột1
		JTextField tf1 = new JTextField(20);
		add(tf1); //dòng 1 cột 2
		
		JLabel lbl2 = new JLabel("Number 2:");
		add(lbl2); //dòng 2 cột1
		JTextField tf2 = new JTextField(20);
		add(tf2); //dòng 2 cột 2
		
		JLabel lbl3 = new JLabel("");
		add(lbl3); //dòng 3 cột1
		JButton btChia = new JButton("/");
		btChia.addActionListener(
			new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					InputDTO inDTO = new InputDTO();
					ResultDialogView view = new ResultDialogView();
					inDTO.num1 = tf1.getText();
					inDTO.num2 = tf2.getText();
					Chia2So c2so = new Chia2So();
					Chia2SoViewModel model = new Chia2SoViewModel();
					//đăng ký view với model
					view.setModel(model);
					Chia2SoPresenter presenter = new Chia2SoPresenter(model);
					Chia2SoUseCaseControl uc = new 
							Chia2SoUseCaseControl(presenter, c2so);
					
					Chia2SoController controller =
							new Chia2SoController(uc);
					controller.execute(inDTO);
					
					model.notifySubscribers(); //la làng tao có dữ liệu nè
				}
			}
		);
		add(btChia); //dòng 3 cột 2
		
		pack(); //gói gọn
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
	}
}
