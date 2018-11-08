package ninja.spring.orderservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
public class OrderController {

    @GetMapping("/orders")
    private List<Order> getOrders() {
        return Stream.of(Order.builder()
                        .id("1")
                        .name("ABC")
                        .build(),
                Order.builder()
                        .id("2")
                        .name("XYZ")
                        .build())
                .collect(Collectors.toList());
    }
}
