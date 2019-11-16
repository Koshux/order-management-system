package com.lanzonprojects.omsapi.domain.repository;

import com.lanzonprojects.omsapi.domain.model.Breed;
import com.lanzonprojects.omsapi.jooq.generated.tables.Allergies;
import com.lanzonprojects.omsapi.jooq.generated.tables.Breeds;
import io.crnk.core.queryspec.QuerySpec;
import io.crnk.core.repository.ResourceRepositoryBase;
import io.crnk.core.resource.list.ResourceList;
import org.jooq.DSLContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author lanzon-projects.
 */
@Component
@Transactional
public class BreedRepository extends ResourceRepositoryBase<Breed, Long> {
    private static final Logger LOGGER = LoggerFactory.getLogger(BreedRepository.class);

    @Autowired
    private DSLContext dslContext;

    public BreedRepository() {
        super(Breed.class);
    }

    @Override
    public Breed findOne(Long id, QuerySpec querySpec) {
        final Breed breed = dslContext
                .select()
                .from(Breeds.BREEDS)
                .where(Breeds.BREEDS.ID.eq(Math.toIntExact(id)))
                .fetchOneInto(Breed.class);

        LOGGER.debug("Found breed: {}", breed);
        return breed;
    }

    @Override
    public ResourceList<Breed> findAll(QuerySpec querySpec) {
        final List<Breed> breeds = dslContext
                .select()
                .from(Breeds.BREEDS)
                .fetchInto(Breed.class);

        LOGGER.debug("Found notes: {}", breeds);
        return querySpec.apply(breeds);
    }
}
