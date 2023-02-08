package nttdata.bootcamp.quarkus.bankaccount.application;

import io.smallrye.mutiny.Uni;
import nttdata.bootcamp.quarkus.bankaccount.model.BankAccount;
import java.util.List;

public interface BankAccountService {
    public Uni<List<BankAccount>> listAll();

}
