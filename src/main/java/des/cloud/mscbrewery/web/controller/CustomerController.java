package des.cloud.mscbrewery.web.controller;

import des.cloud.mscbrewery.services.CustomerService;
import des.cloud.mscbrewery.web.model.CustomerDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Slf4j
@RequestMapping("/api/v1/customer")
@RestController
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @RequestMapping("/{customerId}")
    public ResponseEntity<CustomerDto> getCustomer(@PathVariable UUID customerId) {
        return new ResponseEntity<>(customerService.getCustomerById(customerId), HttpStatus.OK);

    }

    @PostMapping
    public ResponseEntity handlePost(@RequestBody CustomerDto customerDto) {
      log.debug("Customer DTO : " + customerDto);

      CustomerDto savedDto = customerService.saveNewCustomer(customerDto);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Location", "/api/v1/customer/" + savedDto.getId());

        return new ResponseEntity(headers, HttpStatus.CREATED);

    }

    @PutMapping("/{customerId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void handleUpdate(@PathVariable("customerId") UUID customerId, @RequestBody CustomerDto customerDto) {

        log.debug("Customer DTO : " + customerDto);
        customerService.updateCustomer(customerId, customerDto);

    }

    @DeleteMapping("/{customerId}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void handleDelete(@PathVariable("customerId") UUID customerId) {
        customerService.deleteCustomer(customerId);
    }







}
