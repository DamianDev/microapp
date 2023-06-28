package com.damiandev.microapp.microappcustomers.service;

import com.damiandev.microapp.microappcustomers.model.CustomerDTO;

import java.util.List;

public interface CustomerService {
    List<CustomerDTO> getCustomers();
    CustomerDTO addCustomer(CustomerDTO customerDTO);
}
