package com.levelup.mutualfunds.modelEndpoint;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/config")
public class ConfigEndpoint {

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String returnString() {
		return "WebConfig reached";
	}
}
