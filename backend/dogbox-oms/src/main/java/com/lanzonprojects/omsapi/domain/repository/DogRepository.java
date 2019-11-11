package com.lanzonprojects.omsapi.domain.repository;

import com.lanzonprojects.omsapi.domain.model.Customer;
import com.lanzonprojects.omsapi.domain.model.Dog;
import com.lanzonprojects.omsapi.jooq.generated.tables.Customers;
import com.lanzonprojects.omsapi.jooq.generated.tables.Dogs;
import io.crnk.core.exception.InternalServerErrorException;
import io.crnk.core.queryspec.QuerySpec;
import io.crnk.core.repository.ResourceRepositoryBase;
import io.crnk.core.resource.list.ResourceList;
import org.jooq.DSLContext;
import org.jooq.Record;
import org.jooq.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author lanzon-projects.
 */
@Component
@Transactional
public class DogRepository  extends ResourceRepositoryBase<Dog, Long> {
    private static final Logger LOGGER = LoggerFactory.getLogger(CustomerRepository.class);

    @Autowired
    private DSLContext dslContext;

    public DogRepository() {
        super(Dog.class);
    }

    @Override
    public ResourceList<Dog> findAll(QuerySpec querySpec) {
        final Result<Record> dogs = dslContext.select().from(Dogs.DOGS).fetch();
        final List<Dog> dogsList = dogs
                .stream()
                .map(dog -> {
                    Dog doggy = new Dog();
                    /*doggy.setAge(dog.getValue(Dogs.DOGS.AGE));*/
                    doggy.setLimitCalories(Integer.parseInt(dog.getValue(Dogs.DOGS.LIMITCALORIES)));
                    return doggy;
                })
                .collect(Collectors.toList());
        LOGGER.debug("Found notes: {}", dogs);

        return querySpec.apply(dogsList);
    }

    @Override
    public <S extends Dog> S create(S entity) {
        return null;
    }

    @Override
    public synchronized void delete(Long id) {
        int execute = dslContext
                .deleteFrom(Dogs.DOGS)
                .where(Dogs.DOGS.ID.equal(Math.toIntExact(id)))
                .execute();

        if (execute == 0) {
            throw new InternalServerErrorException("Something went wrong while deleting the note, please try again.");
        }
    }
}