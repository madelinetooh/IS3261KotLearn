/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws.restful;

import entity.TopicEntity;
import session.TopicSessionLocal;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.UriInfo;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

import static ws.restful.util.ResourceHelper.getExceptionDump;

/**
 * REST Web Service
 *
 * @author sinhv
 */
@Path("topics")
public class TopicResource {
    TopicSessionLocal topicSessionLocal = lookupTopicSessionLocal();
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
            List<TopicEntity> topicEntities = topicSessionLocal.retrieveAllTopics();
            List<LinkedHashMap<Object, Object>> results = new ArrayList<>();
            Collections.sort(topicEntities, (topic1, topic2) -> (int) (topic1.getHeaderIndex() - topic2.getHeaderIndex()));
            for (TopicEntity topicEntity : topicEntities) {
                LinkedHashMap<Object, Object> result = new LinkedHashMap<>();
                result.put("id", topicEntity.getHeaderIndex());
                result.put("text", topicEntity.getTopicHeader());
                result.put("content", topicEntity.getTopicContent());
                results.add(result);
            }
            return Response.status(Status.OK).entity(results).build();
        } catch (Exception e) {
            return Response.status(Status.INTERNAL_SERVER_ERROR).entity(errorRsp.put("error", getExceptionDump(e))).build();
        }
    }

    @GET
    @Path("getContent")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getContent(@QueryParam("id") Long id) {
        try {
            TopicEntity topic = topicSessionLocal.retrieveTopicByIndex(id);
            return Response.status(Status.OK).entity(topic.getTopicContent()).build();
        } catch (Exception e) {
            errorRsp.put("error", getExceptionDump(e));
            return Response.status(Status.NOT_ACCEPTABLE).entity(errorRsp).build();
        }
    }

    private TopicSessionLocal lookupTopicSessionLocal() {
        try {
            javax.naming.Context c = new InitialContext();
            return (TopicSessionLocal) c.lookup("java:global/KotlearnBackend/KotlearnBackend-ejb/TopicSession!session.TopicSessionLocal");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }
}
