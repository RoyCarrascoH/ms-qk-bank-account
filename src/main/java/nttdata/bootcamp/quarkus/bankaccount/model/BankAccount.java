package nttdata.bootcamp.quarkus.bankaccount.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BankAccount {

    private String idBankAccount;
    private String numberAccount;
    private Date openingDate;
    private String description;
    private Double amount;

}
