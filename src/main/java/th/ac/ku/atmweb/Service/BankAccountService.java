package th.ac.ku.atmweb.Service;

import org.springframework.stereotype.Service;
import th.ac.ku.atmweb.Model.BankAccount;

import javax.annotation.PostConstruct;
import java.util.ArrayList;

@Service
public class BankAccountService {
    private ArrayList<BankAccount> bankAccountArrayList ;

    @PostConstruct
    public void bankAccountConstruct() {
        this.bankAccountArrayList = new ArrayList<>();
    }

    public void createBankAccount(BankAccount bankAccount) {
        bankAccountArrayList.add(bankAccount);
    }

    public ArrayList<BankAccount> getBankAccountArrayList() {
        return new ArrayList<>(this.bankAccountArrayList);
    }
}