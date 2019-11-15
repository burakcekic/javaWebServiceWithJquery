package controller;



import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import model.entity.ButtonAction;
//import org.jboss.resteasy.plugins.server.servlet.HttpServletDispatcher;

@Path("/webservice")
public class ButtonActionController 
{
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/get")
	public ButtonAction getApi()
	{
		return null;
	} 
	
	public ButtonAction postApi()
	{
		return null;
	}
}
