package com.damiandev.microapp.microappcustomers.mapper.base;

import com.damiandev.microapp.microappcustomers.model.CustomerDTO;
import com.damiandev.microapp.microappcustomers.model.tables.pojos.Customer;
import org.mapstruct.Mapper;

@Mapper
public interface CustomerMapper extends BaseMapper<CustomerDTO, Customer> {
}
