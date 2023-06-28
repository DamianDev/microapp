package com.damiandev.microapp.microappcustomers.service.impl;

import com.damiandev.microapp.microappcustomers.dao.CustomerDAO;
import com.damiandev.microapp.microappcustomers.mapper.base.CustomerMapper;
import com.damiandev.microapp.microappcustomers.model.CustomerDTO;
import com.damiandev.microapp.microappcustomers.service.CustomerService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {
    private final CustomerDAO customerDAO;
    private final CustomerMapper customerMapper;

    public CustomerServiceImpl(CustomerDAO customerDAO, CustomerMapper customerMapper) {
        this.customerDAO = customerDAO;
        this.customerMapper = customerMapper;
    }

    @Override
    public List<CustomerDTO> getCustomers() {
        return customerDAO.getAll()
                .stream()
                .map(customerMapper::entityToDto)
                .toList();
    }

    @Override
    public CustomerDTO addCustomer(CustomerDTO customerDTO) {
        return customerMapper.entityToDto(customerDAO.add(customerMapper.dtoToEntity(customerDTO)));
    }
}
