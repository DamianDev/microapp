package com.damiandev.microapp.microappcustomers.mapper.base;

import com.damiandev.microapp.microappcustomers.model.CustomerDTO;
import com.damiandev.microapp.microappcustomers.model.tables.pojos.Customer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {
        CustomerMapperImpl.class
})
public class CustomerMapperTest {

    @Autowired
    private CustomerMapper customerMapper;

    @Test
    public void entityToDtoTest() {
        Customer customer = new Customer();
        customer.setId(1L);
        customer.setName("Testname");
        customer.setSurname("Testsurname");

        CustomerDTO dto = customerMapper.entityToDto(customer);

        Assertions.assertEquals(dto.getId(), customer.getId());
        Assertions.assertEquals(dto.getName(), customer.getName());
        Assertions.assertEquals(dto.getSurname(), customer.getSurname());
    }

    @Test
    public void dtoToEntityTest() {
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setId(1L);
        customerDTO.setName("Testname");
        customerDTO.setSurname("Testsurname");

        Customer customer = customerMapper.dtoToEntity(customerDTO);

        Assertions.assertEquals(customer.getId(), customerDTO.getId());
        Assertions.assertEquals(customer.getName(), customerDTO.getName());
        Assertions.assertEquals(customer.getSurname(), customerDTO.getSurname());
    }

}
