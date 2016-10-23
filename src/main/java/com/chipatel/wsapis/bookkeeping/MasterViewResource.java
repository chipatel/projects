package com.chipatel.wsapis.bookkeeping;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author cpatel
 *
 */

@Path("/master")
public class MasterViewResource {

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String getMasterList() {
		return "You have this may Credits in your account";
	}

}
