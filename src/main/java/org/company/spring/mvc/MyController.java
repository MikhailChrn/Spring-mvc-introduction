package org.company.spring.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/employee")
public class MyController {

    @RequestMapping("/")
    public String showFirstView() {
        return "first-view";
    }

    @RequestMapping("/askDetails")
    public String askEmployeeDetails(Model model) {

/*        Employee emp = new Employee();
        emp.setName("Ivan");
        emp.setSurname("Petrov");
        emp.setSalary(100000)*/;

        model.addAttribute("employee", new Employee());

        return "ask-emp-details-view";
    }

    @RequestMapping("/showDetails")
    public String showEmpDetails(@Valid @ModelAttribute("employee") Employee emp, BindingResult bindingResult) {

        if(bindingResult.hasErrors()) return "ask-emp-details-view";
        else {
            String name = emp.getName();
            emp.setName("Mr." + name);

            String surname = emp.getSurname();
            emp.setSurname(surname + " is java developer");

            int salary = emp.getSalary();
            emp.setSalary(salary + 100000);

            return "show-emp-details-view";
        }
    }
}
