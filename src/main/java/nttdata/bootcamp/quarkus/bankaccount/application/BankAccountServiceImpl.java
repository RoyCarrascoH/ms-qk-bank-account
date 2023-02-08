package nttdata.bootcamp.quarkus.bankaccount.application;

import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import nttdata.bootcamp.quarkus.bankaccount.model.BankAccount;

import java.util.List;

@ApplicationScoped
public class BankAccountServiceImpl implements BankAccountService {
    @Override
    public Uni<List<BankAccount>> listAll() {
        return null;
    }
}
