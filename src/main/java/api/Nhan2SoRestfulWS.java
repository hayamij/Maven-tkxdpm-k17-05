package api;

import entities.chanle.KiemTraChanLe;
import entities.nhan2so.Nhan2So;
import interfaceadapters.nhan2so.Nhan2SoPresenterAPI;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import usecases.nhan2so.InputData;
import usecases.nhan2so.InputInterface;
import usecases.nhan2so.Nhan2SoUseCaseControl;

@Path("/nhan2so")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class Nhan2SoRestfulWS {

	public static class RequestBody {
		public Integer num1;
		public Integer num2;
	}

	@GET
	public Response infoGet() {
		Nhan2soResponse resp = new Nhan2soResponse();
		resp.setSuccess(false);
		resp.setMessage("This endpoint accepts POST only. Use POST /api/nhan2so with JSON {\"num1\":<int>,\"num2\":<int>}.");
		return Response.ok(resp).build();
	}

	@POST
	public Response nhan2so(RequestBody body) {

		if (body == null || body.num1 == null || body.num2 == null) {
			Nhan2soResponse resp = new Nhan2soResponse();
			resp.setSuccess(false);
			resp.setMessage("Missing num1 or num2 in request body");
			return Response.status(Response.Status.BAD_REQUEST).entity(resp).build();
		}

		// Create request-scoped ViewModel + Presenter
		Nhan2soResponse responseModel = new Nhan2soResponse();
		Nhan2SoPresenterAPI presenter = new Nhan2SoPresenterAPI(responseModel);
		KiemTraChanLe ktcl = new KiemTraChanLe();

		Nhan2So nhan2so = new Nhan2So();
		// Call use case
		InputData input = new InputData(body.num1, body.num2);
		InputInterface in = new Nhan2SoUseCaseControl(presenter, nhan2so, ktcl);
		in.execute(input);

		// Return responseModel as JSON (200 OK)
		return Response.ok(responseModel).build();

	}

}