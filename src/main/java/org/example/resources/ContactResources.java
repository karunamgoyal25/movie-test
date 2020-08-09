package org.example.resources;

import org.example.api.Contact;
import org.example.dao.ContactDAO;
import org.jdbi.v3.core.Jdbi;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/contacts")
@Produces(MediaType.APPLICATION_JSON)
public class ContactResources {

    private final ContactDAO contactDAO;

    public ContactResources(Jdbi jdbi){
        contactDAO = jdbi.onDemand(ContactDAO.class);
    }
    @GET
    @Path("/{id}")
    public Response getContact(@PathParam("id") int id){
        Contact contact = contactDAO.findById(id);
        return Response.ok(contact).build();
    }
    @POST
    public Response createContact(Contact contact){
        contactDAO.insert(contact);
        return Response.created(null).build();
    }
    @DELETE
    @Path("/{id}")
    public Response deleteContact(@PathParam("id")int id){
        //delete the contact with that id
        contactDAO.delete(id);
        return Response.noContent().build();
    }
    @PUT
    @Path("/{id}")
    public Response updateContact(@PathParam("id") int id,Contact contact){
        //Update Contact;
        contactDAO.update(id,contact);
        return Response.ok(new Contact(id,contact.getFirstName(),contact.getLastName(),contact.getPhone())).build();

    }
}
