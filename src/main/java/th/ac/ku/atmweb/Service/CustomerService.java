package th.ac.ku.atmweb.Service;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import th.ac.ku.atmweb.Model.Customer;
import th.ac.ku.atmweb.data.CustomerRepository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerService {

//    private ArrayList<Customer> customerArrayList ;

    private CustomerRepository customerRepository ;

    public CustomerService(CustomerRepository repository){
        this.customerRepository = repository;
    }


//    public void postConstruct(){
//        this.customerArrayList = new ArrayList<>();
//    }

    public void createCustomer(Customer customer){
        String hashPIN = hash(customer.getPin());
        customer.setPin(hashPIN);
        customerRepository.save(customer);
    }

    public Customer findCustomer(int id) {
       try{
           return customerRepository.findById(id);
       }catch (EmptyResultDataAccessException e){
           return null ;
       }
    }

        public List<Customer> getCustomerArrayList() {
        return customerRepository.findAll();
    }

    private String hash(String pin) {
        String salt = BCrypt.gensalt(12);
        return BCrypt.hashpw(pin, salt);
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