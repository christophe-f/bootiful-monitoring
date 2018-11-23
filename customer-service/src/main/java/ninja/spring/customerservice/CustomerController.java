package ninja.spring.customerservice;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    private final CustomerRepository customerRepository;

    public CustomerController(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @GetMapping("")
    ResponseEntity<List<Customer>> getCustomers() {
        return ResponseEntity.ok(customerRepository.findAll());
    }

    @GetMapping("/{customerId}")
    ResponseEntity<Customer> getCustomer(@PathVariable UUID customerId) {
        return customerRepository.findById(customerId)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }


    @PostMapping("")
    ResponseEntity<Customer> createCustomer(@RequestBody Customer customer) {
        Customer createdCustomer = customerRepository.save(customer);
        return ResponseEntity.created(URI.create("/customers/" + createdCustomer.getId())).body(createdCustomer);
    }


    @DeleteMapping("/{customerId}")
    ResponseEntity<Void> deleteCustomer(@PathVariable UUID customerId) {
        customerRepository.deleteById(customerId);
        return ResponseEntity.noContent().build();
    }
}
