package com.damiandev.microapp.microappcustomers.service.impl;

import com.damiandev.microapp.microappcustomers.dao.CustomerDAO;
import com.damiandev.microapp.microappcustomers.mapper.base.CustomerMapper;
import com.damiandev.microapp.microappcustomers.model.CustomerDTO;
import com.damiandev.microapp.microappcustomers.service.CustomerService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    @Transactional
    public List<CustomerDTO> getCustomers() {
        return customerDAO.getAll()
                .stream()
                .map(customerMapper::entityToDto)
                .toList();
    }

    @Override
    @Transactional
    public Long addCustomer(CustomerDTO customerDTO) {
        return customerDAO.add(customerMapper.dtoToEntity(customerDTO));
    }

    @Override
    @Transactional
    public Long updateCustomer(CustomerDTO customerDTO) {
        return customerDAO.update(customerMapper.dtoToEntity(customerDTO));
    }

    @Override
    @Transactional
    public CustomerDTO getCustomerById(Long id) {
        return customerMapper.entityToDto(customerDAO.getByID(id));
    }

    @Override
    @Transactional
    public void deleteCustomerById(Long id) {
        customerDAO.delete(id);
    }
}
