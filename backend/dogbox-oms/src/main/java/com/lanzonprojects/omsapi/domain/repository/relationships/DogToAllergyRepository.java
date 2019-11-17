package com.lanzonprojects.omsapi.domain.repository.relationships;

import com.lanzonprojects.omsapi.domain.model.Allergy;
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

import static com.lanzonprojects.omsapi.jooq.generated.tables.Allergies.ALLERGIES;
import static com.lanzonprojects.omsapi.jooq.generated.tables.Dogs.DOGS;
import static com.lanzonprojects.omsapi.jooq.generated.tables.DogsAllergies.DOGS_ALLERGIES;

/**
 * @author lanzon-projects.
 */
@Repository
public class DogToAllergyRepository extends ManyRelationshipRepositoryBase<Object, Long, Allergy, Long> {
    private static final Logger LOGGER = LoggerFactory.getLogger(DogToAllergyRepository.class);

    @Autowired
    private DSLContext dsl;

    public DogToAllergyRepository(final DSLContext dsl) {
        this.dsl = dsl;
    }

    @Override
    public RelationshipMatcher getMatcher() {
        return new RelationshipMatcher().rule().target(Allergy.class).add();
    }

    @Override
    public Map<Long, ResourceList<Allergy>> findManyRelations(final Collection<Long> sourceIds,
                                                              final String fieldName,
                                                              final QuerySpec querySpec) {
        final Map<Long, ResourceList<Allergy>> map = new HashMap<>();
        sourceIds.forEach(sourceId -> {
            final Result<Record> dogAllergiesRecords = dsl.select()
                    .from(DOGS, DOGS_ALLERGIES)
                    .where(DOGS.ID.eq(Math.toIntExact(sourceId)))
                    .and(DOGS_ALLERGIES.DOG_ID.eq(DOGS.ID))
                    .fetch();

            final DefaultResourceList<Allergy> allergies = new DefaultResourceList<>();
            dogAllergiesRecords.forEach(dogAlleryRecord -> {
                Allergy allergy = new Allergy();
                allergy.setId(dogAlleryRecord.getValue(DOGS_ALLERGIES.ALLERGY_ID));
                allergy.setName(dogAlleryRecord.getValue(ALLERGIES.NAME));
                allergies.add(allergy);
            });

            map.put(sourceId, allergies);
        });

        LOGGER.debug("Found dogs-allergies: {}", map);
        return map;
    }
}
