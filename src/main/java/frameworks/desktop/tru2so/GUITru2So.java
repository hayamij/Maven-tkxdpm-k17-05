package frameworks.desktop.tru2so;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import interfaceadapters.tru2so.InputDTO;
import interfaceadapters.tru2so.Tru2SoController;
import interfaceadapters.tru2so.Tru2SoPresenter;
import interfaceadapters.tru2so.Tru2SoViewModel;
import entities.tru2so.Tru2So;
import usecases.tru2so.Tru2SoUseCaseControl;

public class GUITru2So extends JFrame {
	
	public GUITru2So() {
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
		JButton btTru = new JButton("-");
		btTru.addActionListener(
			new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					InputDTO inDTO = new InputDTO();
					ResultDialogView view = new ResultDialogView();
					inDTO.num1 = tf1.getText();
					inDTO.num2 = tf2.getText();
					Tru2So t2so = new Tru2So();
					Tru2SoViewModel model = new Tru2SoViewModel();
					//đăng ký view với model
					view.setModel(model);
					Tru2SoPresenter presenter = new Tru2SoPresenter(model);
					Tru2SoUseCaseControl uc = new 
							Tru2SoUseCaseControl(presenter, t2so);
					
					Tru2SoController controller =
							new Tru2SoController(uc);
					controller.execute(inDTO);
					
					model.notifySubscribers(); //la làng tao có dữ liệu nè
				}
			}
		);
		add(btTru); //dòng 3 cột 2
		
		pack(); //gói gọn
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
	}
}
