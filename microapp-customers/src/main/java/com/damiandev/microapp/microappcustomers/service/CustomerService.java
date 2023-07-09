package com.damiandev.microapp.microappcustomers.service;

import com.damiandev.microapp.microappcustomers.model.CustomerDTO;

import java.util.List;

public interface CustomerService {
    List<CustomerDTO> getCustomers();
    Long addCustomer(CustomerDTO customerDTO);
    Long updateCustomer(CustomerDTO customerDTO);
    CustomerDTO getCustomerById(Long id);
    void deleteCustomerById(Long id);
}
