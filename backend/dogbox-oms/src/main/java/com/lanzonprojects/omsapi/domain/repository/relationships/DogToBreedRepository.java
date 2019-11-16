package com.lanzonprojects.omsapi.domain.repository.relationships;

import com.google.common.collect.Iterables;
import com.lanzonprojects.omsapi.domain.model.Breed;
import io.crnk.core.queryspec.QuerySpec;
import io.crnk.core.repository.OneRelationshipRepositoryBase;
import io.crnk.core.repository.RelationshipMatcher;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import static com.lanzonprojects.omsapi.jooq.generated.tables.Breeds.BREEDS;

/**
 * @author lanzon-projects.
 */
@Repository
public class DogToBreedRepository extends OneRelationshipRepositoryBase<Object, Long, Breed, Long> {

    @Autowired
    private DSLContext dsl;

    public DogToBreedRepository(final DSLContext dsl) {
        this.dsl = dsl;
    }

    @Override
    public RelationshipMatcher getMatcher() {
        return new RelationshipMatcher().rule().target(Breed.class).add();
    }

    @Override
    public Map<Long, Breed> findOneRelations(Collection<Long> sourceIds, String fieldName, QuerySpec querySpec) {
        final Map<Long, Breed> map = new HashMap<>();

        sourceIds.forEach(sourceId -> {
            final Breed breed = dsl
                    .select()
                    .from(BREEDS)
                    .where(BREEDS.ID.eq(Math.toIntExact(sourceId)))
                    .fetchOneInto(Breed.class);

            map.put(sourceId, breed);
        });

        return map;
    }
}
