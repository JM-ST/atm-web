package th.ac.ku.atmweb.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import th.ac.ku.atmweb.Model.Customer;
import th.ac.ku.atmweb.Service.CustomerService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/customer")
public class CustomerRestController {

    private CustomerService customerService;

    public CustomerRestController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    public List<Customer> getAll() {
        return customerService.getCustomerArrayList();
    }
    @GetMapping("/{id}")
    public Customer getOne(@PathVariable int id){
        return customerService.findCustomer(id);
    }
}