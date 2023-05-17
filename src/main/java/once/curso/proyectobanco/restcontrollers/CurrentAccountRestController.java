package once.curso.proyectobanco.restcontrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.Data;
import once.curso.proyectobanco.entities.CurrentAccount;
import once.curso.proyectobanco.services.CurrentAccountService;

@Data
@RestController
@RequestMapping("/once")
public class CurrentAccountRestController {
    @Autowired
    private CurrentAccountService currentAccountService;
    
    @GetMapping(value = "/currentAccounts/{id}")
    public EntityModel<CurrentAccount> findById(@PathVariable Integer id) {
        CurrentAccount currentAccount = currentAccountService.findById(id).get();
        currentAccount.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(CurrentAccountRestController.class)
                .findById(currentAccount.getId())).withSelfRel());
        return EntityModel.of(currentAccount);
    }
    
    @GetMapping(value = "/currentAccounts")
    public CollectionModel<CurrentAccount> findAll() {
        Iterable<CurrentAccount> currentAccounts = currentAccountService.findAll();
        currentAccounts.forEach(a -> {                                               
            a.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(CurrentAccountRestController.class)
                    .findById(a.getId())).withSelfRel());
            a.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(TypeAccountRestController.class)
                    .findById(a.getId())).withRel("typeAccount"));
            a.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(FeeRestController.class)
                    .findById(a.getId())).withRel("fee"));
        });
        return CollectionModel.of(currentAccounts);
    }
    
    @PostMapping(value = "/currentAccounts")
    public EntityModel<CurrentAccount> save(@RequestBody CurrentAccount currentAccount) {
        CurrentAccount savedAccount = currentAccountService.save(currentAccount);
        savedAccount.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(CurrentAccountRestController.class)
                .findById(savedAccount.getId())).withSelfRel());
        return EntityModel.of(savedAccount);
    }
    
    @DeleteMapping(value = "/currentAccounts/{id}")
    public void deleteById(@PathVariable Integer id) {
        currentAccountService.deleteById(id);
    }
}
