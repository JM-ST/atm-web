package th.ac.ku.atmweb.Controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import th.ac.ku.atmweb.Model.BankAccount;
import th.ac.ku.atmweb.Service.BankAccountService;

@Controller
@RequestMapping("/bankaccount")
public class BankAccountController {

    private BankAccountService bankAccountService ;

    public BankAccountController(BankAccountService bankAccountService) {
        this.bankAccountService = bankAccountService;
    }

    @GetMapping
    public String getBankAccount(Model model){
        model.addAttribute("allBankAccounts",bankAccountService.getBankAccountArrayList());
        return "bankaccount";
    }

    @PostMapping
    public String createBankAccount(@ModelAttribute BankAccount bankAccount,Model model) {
        bankAccountService.createBankAccount(bankAccount);
        model.addAttribute("allBankAccounts",bankAccountService.getBankAccountArrayList());
        return "redirect:bankaccount";
    }



}