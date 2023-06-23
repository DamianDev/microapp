package com.damiandev.microapp.microappcustomers.dao;

import com.damiandev.microapp.microappcustomers.model.Tables;
import org.jooq.DSLContext;
import com.damiandev.microapp.microappcustomers.model.tables.pojos.Customer;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CustomerDAO {
    private final DSLContext context;

    public CustomerDAO(DSLContext context) {
        this.context = context;
    }

    public List<Customer> getAll() {
        return context.selectFrom(Tables.CUSTOMER).fetchInto(Customer.class);
    }

    public Customer getByID(Long id) {
        return context.selectFrom(Tables.CUSTOMER)
                .where(Tables.CUSTOMER.ID.eq(id))
                .fetchOneInto(Customer.class);
    }

    public void add(Customer customer) {
        context.insertInto(Tables.CUSTOMER, Tables.CUSTOMER.NAME, Tables.CUSTOMER.SURNAME)
                .values(customer.getName(), customer.getSurname())
                .execute();
    }
}
