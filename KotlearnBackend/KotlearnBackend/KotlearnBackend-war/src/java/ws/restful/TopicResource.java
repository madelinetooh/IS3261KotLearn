/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws.restful;

import sun.security.pkcs11.wrapper.Functions;

import javax.faces.flow.Flow;
import javax.persistence.Inheritance;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import java.beans.Visibility;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import static ws.restful.util.ResourceHelper.getExceptionDump;

/**
 * REST Web Service
 *
 * @author sinhv
 */
@Path("topics")
public class TopicResource {
    private LinkedHashMap<Object, Object> errorRsp = new LinkedHashMap<>();

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of TopicResource
     */
    public TopicResource() {
    }

    /**
     * Retrieves representation of an instance of ws.restful.TopicResource
     * @return an instance of java.lang.String
     */
    @GET
    @Path("getTopics")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getTopics() {
        try {
            List<String> topics = new ArrayList<>();
            topics.add("Overview");
            topics.add("Environment Setup");
            topics.add("Architecture");
            topics.add("Basic Types");
            topics.add("Control Flow");
            topics.add("Class & Object");
            topics.add("Constructors");
            topics.add("Inheritance");
            topics.add("Interface ");
            topics.add("Visibility");
            topics.add("Control");
            topics.add("Extension");
            topics.add("Data Classes");
            topics.add("Sealed Class");
            topics.add("Generics");
            topics.add("Delegation");
            topics.add("Functions");
            topics.add("Destructuring");
            topics.add("Declarations");
            topics.add("Exception Handling");
            topics.add("Function");
            return Response.status(Status.OK).entity(topics).build();
        } catch (Exception e) {
            return Response.status(Status.INTERNAL_SERVER_ERROR).entity(errorRsp.put("error", getExceptionDump(e))).build();
        }
    }

    @GET
    @Path("getContent")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getContent(@QueryParam("id") Integer id) {
        try {
            String content = "This is a content";
            return Response.status(Status.OK).entity(content).build();
        } catch (Exception e) {
            return Response.status(Status.INTERNAL_SERVER_ERROR).entity(errorRsp.put("error", getExceptionDump(e))).build();
        }
    }
}
