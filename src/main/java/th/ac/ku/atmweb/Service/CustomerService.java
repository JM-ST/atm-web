package th.ac.ku.atmweb.Service;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;
import th.ac.ku.atmweb.Model.Customer;

import javax.annotation.PostConstruct;
import java.util.ArrayList;

@Service
public class CustomerService {

    private ArrayList<Customer> customerArrayList ;

    @PostConstruct
    public void postConstruct(){
        this.customerArrayList = new ArrayList<>();
    }

    public void createCustomer(Customer customer){
        String hashPIN = hash(customer.getPin());
        customer.setPin(hashPIN);
        customerArrayList.add(customer);
    }

    public ArrayList<Customer> getCustomerArrayList() {
        return new ArrayList<>(this.customerArrayList);
    }

    private String hash(String pin) {
        String salt = BCrypt.gensalt(12);
        return BCrypt.hashpw(pin, salt);
    }

    public Customer findCustomer(int id) {
        for (Customer customer : customerArrayList) {
            if (customer.getId() == id)
                return customer;
        }
        return null;
    }
    public Customer checkPin(Customer inputCustomer) {
        Customer storedCustomer = findCustomer(inputCustomer.getId());

        if (storedCustomer != null) {
            String hashPin = storedCustomer.getPin();

            if (BCrypt.checkpw(inputCustomer.getPin(), hashPin))
                return storedCustomer;
        }

        return null;
    }





}