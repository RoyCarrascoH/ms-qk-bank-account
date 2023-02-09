package nttdata.bootcamp.quarkus.bankaccount;

import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import nttdata.bootcamp.quarkus.bankaccount.application.BankAccountService;
import nttdata.bootcamp.quarkus.bankaccount.entity.BankAccount;
import nttdata.bootcamp.quarkus.bankaccount.util.Utilitarios;
import org.jboss.logging.Logger;

import java.util.List;

@Path("/api/bank-account")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class BankAccountResource {

    private static final Logger LOGGER = Logger.getLogger(BankAccountResource.class.getName());

    @Inject
    private BankAccountService service;

    @GET
    public List<BankAccount> getBankAccounts() {
        return service.listAll();
    }

    @GET
    @Path("{idBankAccount}")
    public BankAccount viewBankAccountDetails(@PathParam("idBankAccount") Long idBankAccount) {
        BankAccount entity = service.findById(idBankAccount);
        if (entity == null) {
            throw new WebApplicationException("BankAccount with id of " + idBankAccount + " does not exist.", 404);
        }
        return entity;
    }

    @POST
    @Transactional
    public Response createBankAccount(BankAccount bankAccount) {
        if (bankAccount.getIdBankAccount() != null) {
            throw new WebApplicationException("Id was invalidly set on request.", 422);
        }
        service.save(bankAccount);
        return Response.ok(bankAccount).status(200).build();
    }

    @PUT
    @Path("{idBankAccount}")
    @Transactional
    public BankAccount updateBankAccount(@PathParam("idBankAccount") Long idBankAccount, BankAccount bankAccount) {
        if (bankAccount.getNumberAccount() == null) {
            throw new WebApplicationException("BankAccount number account was not set on request.", 422);
        }
        BankAccount entity = service.findById(idBankAccount);
        if (entity == null) {
            throw new WebApplicationException("BankAccount with id of " + idBankAccount + " does not exist.", 404);
        }
        entity = Utilitarios.saveBankAccount(entity, bankAccount);
        service.update(idBankAccount,entity);
        return entity;
    }

    @DELETE
    @Path("{idBankAccount}")
    @Transactional
    public Response delete(@PathParam("idBankAccount") Long idBankAccount) {
        BankAccount entity = service.findById(idBankAccount);
        if (entity == null) {
            throw new WebApplicationException("BankAccount with id of " + idBankAccount + " does not exist.", 404);
        }
        service.delete(entity.getIdBankAccount());
        return Response.status(200).build();
    }

}