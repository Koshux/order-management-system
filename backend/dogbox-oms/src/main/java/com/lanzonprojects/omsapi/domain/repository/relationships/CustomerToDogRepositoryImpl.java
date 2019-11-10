package com.lanzonprojects.omsapi.domain.repository.relationships;

import com.lanzonprojects.omsapi.domain.model.Customer;
import com.lanzonprojects.omsapi.domain.model.Dog;
import io.crnk.core.repository.RelationshipRepositoryBase;
import org.springframework.stereotype.Component;

/**
 * @author lanzon-projects.
 */
@Component
public class CustomerToDogRepositoryImpl extends RelationshipRepositoryBase<Customer, Long, Dog, Long> {
    protected CustomerToDogRepositoryImpl(Class<Customer> sourceResourceClass, Class<Dog> targetResourceClass) {
        super(sourceResourceClass, targetResourceClass);
    }
}
