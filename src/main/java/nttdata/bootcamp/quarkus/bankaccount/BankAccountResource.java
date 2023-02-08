package nttdata.bootcamp.quarkus.bankaccount;

import io.smallrye.mutiny.Uni;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import nttdata.bootcamp.quarkus.bankaccount.application.BankAccountService;
import nttdata.bootcamp.quarkus.bankaccount.model.BankAccount;
import java.util.List;

@Path("/api/bank-account")
public class BankAccountResource {

    @Inject
    private BankAccountService service;

    @GET
    //@Path("/")
    @Produces(MediaType.TEXT_PLAIN)
    public Uni<List<BankAccount>> getClients() {
        return service.listAll();
    }
}
