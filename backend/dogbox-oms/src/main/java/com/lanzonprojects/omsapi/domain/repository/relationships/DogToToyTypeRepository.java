package com.lanzonprojects.omsapi.domain.repository.relationships;

import com.lanzonprojects.omsapi.domain.model.ToyType;
import io.crnk.core.queryspec.QuerySpec;
import io.crnk.core.repository.ManyRelationshipRepositoryBase;
import io.crnk.core.repository.RelationshipMatcher;
import io.crnk.core.resource.list.DefaultResourceList;
import io.crnk.core.resource.list.ResourceList;
import org.jooq.DSLContext;
import org.jooq.Record;
import org.jooq.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import static com.lanzonprojects.omsapi.jooq.generated.tables.Dogs.DOGS;
import static com.lanzonprojects.omsapi.jooq.generated.tables.DogsToyTypes.DOGS_TOY_TYPES;
import static com.lanzonprojects.omsapi.jooq.generated.tables.ToyTypes.TOY_TYPES;

/**
 * @author lanzon-projects.
 */
@Repository
public class DogToToyTypeRepository extends ManyRelationshipRepositoryBase<Object, Long, ToyType, Long> {
    private static final Logger LOGGER = LoggerFactory.getLogger(DogToToyTypeRepository.class);

    @Autowired
    private DSLContext dsl;

    public DogToToyTypeRepository(final DSLContext dsl) {
        this.dsl = dsl;
    }

    @Override
    public RelationshipMatcher getMatcher() {
        return new RelationshipMatcher().rule().target(ToyType.class).add();
    }

    @Override
    public Map<Long, ResourceList<ToyType>> findManyRelations(final Collection<Long> sourceIds,
                                                              final String fieldName,
                                                              final QuerySpec querySpec) {
        final Map<Long, ResourceList<ToyType>> map = new HashMap<>();
        sourceIds.forEach(sourceId -> {
            final Result<Record> dogToyTypeRecords = dsl.select()
                    .from(DOGS, DOGS_TOY_TYPES)
                    .where(DOGS.ID.eq(Math.toIntExact(sourceId)))
                    .and(DOGS_TOY_TYPES.DOG_ID.eq(DOGS.ID))
                    .fetch();

            final DefaultResourceList<ToyType> toyTypes = new DefaultResourceList<>();
            dogToyTypeRecords.forEach(dogToyTypeRecord -> {
                ToyType toyType = new ToyType();
                toyType.setId(dogToyTypeRecord.getValue(DOGS_TOY_TYPES.DOG_ID));
                toyType.setName(dogToyTypeRecord.getValue(TOY_TYPES.NAME));
                toyTypes.add(toyType);
            });

            map.put(sourceId, toyTypes);
        });

        LOGGER.debug("Found dogs-toy_types: {}", map);
        return map;
    }
}
