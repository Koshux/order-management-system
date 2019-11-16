package com.lanzonprojects.omsapi.domain.repository.relationships;

import com.lanzonprojects.omsapi.domain.model.Dog;
import io.crnk.core.queryspec.QuerySpec;
import io.crnk.core.repository.ManyRelationshipRepositoryBase;
import io.crnk.core.repository.RelationshipMatcher;
import io.crnk.core.resource.list.DefaultResourceList;
import io.crnk.core.resource.list.ResourceList;
import org.jooq.DSLContext;
import org.jooq.Record;
import org.jooq.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import static com.lanzonprojects.omsapi.jooq.generated.tables.CustomersDogs.CUSTOMERS_DOGS;
import static com.lanzonprojects.omsapi.jooq.generated.tables.Dogs.DOGS;

/**
 * @author lanzon-projects.
 */
@Repository
public class CustomerToDogRepository extends ManyRelationshipRepositoryBase<Object, Long, Dog, Long> {

    @Autowired
    private DSLContext dsl;

    public CustomerToDogRepository(final DSLContext dsl) {
        this.dsl = dsl;
    }

    @Override
    public RelationshipMatcher getMatcher() {
        return new RelationshipMatcher().rule().target(Dog.class).add();
    }

    @Override
    public Map<Long, ResourceList<Dog>> findManyRelations(final Collection<Long> sourceIds,
                                                          final String fieldName,
                                                          final QuerySpec querySpec) {
        final Map<Long, ResourceList<Dog>> map = new HashMap<>();
        sourceIds.forEach(sourceId -> {
            Result<Record> dogs = dsl.select()
                    .from(CUSTOMERS_DOGS, DOGS)
                    .where(CUSTOMERS_DOGS.CUSTOMER_ID.eq(Math.toIntExact(sourceId)))
                    .and(CUSTOMERS_DOGS.DOG_ID.eq(DOGS.ID))
                    .fetch();

            final DefaultResourceList<Dog> customersDogsList = new DefaultResourceList<>();
            dogs.forEach(dog -> {
                Dog customersDog = new Dog();
                customersDog.setId(dog.getValue(DOGS.ID));
                customersDog.setAge(dog.getValue(DOGS.AGE));
                customersDog.setLimitCalories(dog.getValue(DOGS.LIMITCALORIES));
                customersDog.setName(dog.getValue(DOGS.NAME));
                customersDogsList.add(customersDog);
            });

            map.put(sourceId, customersDogsList);
        });

        return map;
    }
}
