package com.damiandev.microapp.microappcustomers.api;

import com.damiandev.microapp.microappcustomers.model.CustomerDTO;
import com.damiandev.microapp.microappcustomers.service.CustomerService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CustomerControllerImpl implements CustomersApiDelegate {

    private final CustomerService customerService;

    public CustomerControllerImpl(CustomerService customerService) {
        this.customerService = customerService;
    }

    @Override
    public ResponseEntity<List<CustomerDTO>> getCustomers() {
        return ResponseEntity.ok(customerService.getCustomers());
    }

    @Override
    public ResponseEntity<CustomerDTO> getCustomerById(Long id) {
        return ResponseEntity.ok(customerService.getCustomerById(id));
    }

    @Override
    public ResponseEntity<Long> createCustomer(CustomerDTO customerDTO) {
        return ResponseEntity.ok(customerService.addCustomer(customerDTO));
    }

    @Override
    public ResponseEntity<Long> updateCustomer(CustomerDTO customerDTO) {
        return ResponseEntity.ok(customerService.updateCustomer(customerDTO));
    }

    @Override
    public ResponseEntity<Void> deleteCustomerById(Long id) {
        customerService.deleteCustomerById(id);
        return ResponseEntity.ok().build();
    }
}