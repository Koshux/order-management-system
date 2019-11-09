package com.lanzonprojects.omsapi.domain.repository;

import com.lanzonprojects.omsapi.domain.model.Customer;
import com.lanzonprojects.omsapi.jooq.generated.tables.Note;
import io.crnk.core.exception.InternalServerErrorException;
import io.crnk.core.queryspec.QuerySpec;
import io.crnk.core.repository.ResourceRepositoryBase;
import io.crnk.core.resource.list.ResourceList;
import org.jooq.DSLContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by @lanzon-projects.
 */
@Component
@Transactional
public class CustomerRepository extends ResourceRepositoryBase<Customer, Long> {
    private static final Logger LOGGER = LoggerFactory.getLogger(NoteRepositoryImpl.class);

    @Autowired
    private DSLContext dslContext;

    public CustomerRepository() {
        super(Customer.class);
    }

    @Override
    public ResourceList<Customer> findAll(QuerySpec querySpec) {
        return null;
    }

    @Override
    public  <S extends Customer> S create(S entity) {
        return null;
    }

    @Override
    public synchronized void delete(Long id) {
        int execute = dslContext.deleteFrom(Note.NOTE).where(Note.NOTE.ID.equal(Math.toIntExact(id))).execute();

        if (execute == 0) {
            throw new InternalServerErrorException("Something went wrong while deleting the note, please try again.");
        }
    }
}