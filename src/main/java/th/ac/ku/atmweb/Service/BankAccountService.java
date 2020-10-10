package th.ac.ku.atmweb.Service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import th.ac.ku.atmweb.Model.BankAccount;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class BankAccountService {

    private RestTemplate restTemplate ;

    private String url = "http://localhost:8091/api/bankaccount" ;

    public BankAccountService(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }

    public List<BankAccount> getCustomerBankAccounts(int customerId) {
        String url = this.url+"/customer/"+ customerId;

        ResponseEntity<BankAccount[]> response = restTemplate.getForEntity(url, BankAccount[].class);
        BankAccount[] accounts = response.getBody();

        return Arrays.asList(accounts);
    }
    public List<BankAccount> getBankAccounts() {
        String url = this.url;

        ResponseEntity<BankAccount[]> response = restTemplate.getForEntity(url,BankAccount[].class);
        BankAccount[] accounts = response.getBody();

        return Arrays.asList(accounts);
    }
    public void createBankAccount(BankAccount bankAccount) {
        restTemplate.postForEntity(url,bankAccount,BankAccount.class);
    }

}