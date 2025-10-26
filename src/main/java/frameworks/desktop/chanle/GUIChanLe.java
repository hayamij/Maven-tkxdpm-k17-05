package frameworks.desktop.chanle;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import interfaceadapters.chanle.ChanLeController;
import interfaceadapters.chanle.ChanLePresenter;
import interfaceadapters.chanle.ChanLeViewModel;
import interfaceadapters.chanle.InputDTO;
import entities.chanle.KiemTraChanLe;
import usecases.chanle.KiemTraChanLeUseCaseControl;
import entities.nhan2so.Nhan2So;

public class GUIChanLe extends JFrame {
	
	public GUIChanLe() {
		GridLayout grid = new GridLayout(3, 2);
		setLayout(grid);
		
		JLabel lbl1 = new JLabel("Number 1:");
		add(lbl1); // dòng 1 cột 1
		JTextField tf1 = new JTextField(20);
		add(tf1); // dòng 1 cột 2
		
		JLabel lbl2 = new JLabel("Number 2:");
		add(lbl2); // dòng 2 cột 1
		JTextField tf2 = new JTextField(20);
		add(tf2); // dòng 2 cột 2
		
		JLabel lbl3 = new JLabel("");
		add(lbl3); // dòng 3 cột 1
		JButton btX = new JButton("Nhân & Kiểm tra Chẵn/Lẻ");
		btX.addActionListener(
			new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					InputDTO inDTO = new InputDTO();
					ResultChanLeDialogView view = new ResultChanLeDialogView();
					inDTO.num1 = tf1.getText();
					inDTO.num2 = tf2.getText();
					
					// Khởi tạo các entity
					Nhan2So n2so = new Nhan2So();
					KiemTraChanLe kiemTra = new KiemTraChanLe();
					
					// Khởi tạo view model
					ChanLeViewModel model = new ChanLeViewModel();
					
					// Đăng ký view với model
					view.setModel(model);
					
					// Khởi tạo presenter
					ChanLePresenter presenter = new ChanLePresenter(model);
					
					// Khởi tạo use case control
					KiemTraChanLeUseCaseControl uc = new KiemTraChanLeUseCaseControl(presenter, n2so, kiemTra);
					
					// Khởi tạo controller
					ChanLeController controller = new ChanLeController(uc);
					controller.execute(inDTO);
					
					// Thông báo cho subscribers
					model.notifySubscribers();
				}
			}
		);
		add(btX); // dòng 3 cột 2
		
		pack(); // gói gọn
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new GUIChanLe();
	}
}
