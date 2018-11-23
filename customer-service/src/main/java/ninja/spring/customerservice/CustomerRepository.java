package ninja.spring.customerservice;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

interface CustomerRepository extends JpaRepository<Customer, UUID> {
}
