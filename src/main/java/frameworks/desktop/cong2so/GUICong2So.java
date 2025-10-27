package frameworks.desktop.cong2so;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import interfaceadapters.cong2so.InputDTO;
import interfaceadapters.cong2so.Cong2SoController;
import interfaceadapters.cong2so.Cong2SoPresenter;
import interfaceadapters.cong2so.Cong2SoViewModel;
import entities.cong2so.Cong2So;
import entities.chanle.KiemTraChanLe;
import usecases.cong2so.Cong2SoUseCaseControl;

public class GUICong2So extends JFrame {
	
	public GUICong2So() {
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
		JButton btCong = new JButton("+");
		btCong.addActionListener(
			new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					InputDTO inDTO = new InputDTO();
					ResultDialogView view = new ResultDialogView();
					inDTO.num1 = tf1.getText();
					inDTO.num2 = tf2.getText();
					Cong2So c2so = new Cong2So();
					KiemTraChanLe ktcl = new KiemTraChanLe();
					Cong2SoViewModel model = new Cong2SoViewModel();
					//đăng ký view với model
					view.setModel(model);
					Cong2SoPresenter presenter = new Cong2SoPresenter(model);
					Cong2SoUseCaseControl uc = new 
							Cong2SoUseCaseControl(presenter, c2so, ktcl);
					
					Cong2SoController controller =
							new Cong2SoController(uc);
					controller.execute(inDTO);
					
					model.notifySubscribers(); //la làng tao có dữ liệu nè
				}
			}
		);
		add(btCong); //dòng 3 cột 2
		
		pack(); //gói gọn
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
	}
}
