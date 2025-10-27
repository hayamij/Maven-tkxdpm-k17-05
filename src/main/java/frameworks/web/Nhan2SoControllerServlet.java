package frameworks.web;

import java.io.IOException;

import interfaceadapters.nhan2so.InputDTO;
import interfaceadapters.nhan2so.Nhan2SoPresenter;
import interfaceadapters.nhan2so.Nhan2SoViewModel;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import usecases.nhan2so.InputData;
import usecases.nhan2so.InputInterface;
import usecases.nhan2so.Nhan2SoUseCaseControl;

@WebServlet("/nhan2so")
public class Nhan2SoControllerServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//nhận dữ liệu từ web
		InputDTO inDTO = new InputDTO();
		inDTO.num1 = req.getParameter("num1");
		inDTO.num2 = req.getParameter("num2");
		
		//chuyển sang dạng Entity và Use case dùng được
		InputData inData = new InputData(Integer.parseInt(inDTO.num1),
				Integer.parseInt(inDTO.num2));
		
		Nhan2SoViewModel model = new Nhan2SoViewModel();
		//đăng ký view với model
		//view.setModel(model);
		Nhan2SoPresenter presenter = new Nhan2SoPresenter(model);
		InputInterface inBoundary  = new 
				Nhan2SoUseCaseControl(presenter);
		
		inBoundary.execute(inData);
		
		//đẩy Model qua 
		//cho View - result.jsp
		req.setAttribute("model", model);
		req.getRequestDispatcher("/result.jsp")
		.forward(req, resp);
		
		
	}
	
	
}
