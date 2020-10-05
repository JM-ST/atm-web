package th.ac.ku.atmweb.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import th.ac.ku.atmweb.Model.Customer;
import th.ac.ku.atmweb.Service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    private CustomerService customerService;
//    ArrayList<Customer> customers = new ArrayList<>();

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    public String getCustomerPage(Model model) {
        model.addAttribute("allCustomers",customerService.getCustomerArrayList());
        return "customer";
    }

    @PostMapping
    public String registerCustomer(@ModelAttribute Customer customer, Model model){
        customerService.createCustomer(customer);
        model.addAttribute("allCustomers",customerService.getCustomerArrayList());
        return "redirect:customer";
    }




}