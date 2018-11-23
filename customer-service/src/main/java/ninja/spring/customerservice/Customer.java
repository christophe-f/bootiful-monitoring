package ninja.spring.customerservice;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
class Customer implements Serializable {

    @Id
    @GeneratedValue
    @Column(columnDefinition = "uuid", unique = true, updatable = false)
    private UUID id;

    @NotBlank
    private String name;

    @Email
    private String email;

    private String address;
    private String city;
    private String country;
}
