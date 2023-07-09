package com.damiandev.microapp.microappcustomers.dao;

import com.damiandev.microapp.microappcustomers.model.Tables;
import org.jooq.DSLContext;
import com.damiandev.microapp.microappcustomers.model.tables.pojos.Customer;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Objects;

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

    public Long add(Customer customer) {
        return Objects.requireNonNull(context.insertInto(Tables.CUSTOMER, Tables.CUSTOMER.NAME, Tables.CUSTOMER.SURNAME)
                        .values(customer.getName(), customer.getSurname())
                        .returning(Tables.CUSTOMER.ID)
                        .fetchOne())
                .getId();
    }

    public Long update(Customer customer) {
        return Objects.requireNonNull(context.update(Tables.CUSTOMER)
                        .set(Tables.CUSTOMER.NAME, customer.getName())
                        .set(Tables.CUSTOMER.SURNAME, customer.getSurname())
                        .where(Tables.CUSTOMER.ID.eq(customer.getId()))
                        .returning(Tables.CUSTOMER.ID)
                        .fetchOne())
                .getId();
    }

    public void delete(Long id) {
        context.delete(Tables.CUSTOMER)
                .where(Tables.CUSTOMER.ID.eq(id))
                .execute();
    }
}
