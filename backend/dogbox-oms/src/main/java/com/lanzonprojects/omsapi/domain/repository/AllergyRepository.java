package com.lanzonprojects.omsapi.domain.repository;

import com.lanzonprojects.omsapi.domain.model.Allergy;
import com.lanzonprojects.omsapi.jooq.generated.tables.Allergies;
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
public class AllergyRepository extends ResourceRepositoryBase<Allergy, Long> {
    private static final Logger LOGGER = LoggerFactory.getLogger(AllergyRepository.class);

    @Autowired
    private DSLContext dslContext;

    public AllergyRepository() {
        super(Allergy.class);
    }

    @Override
    public ResourceList<Allergy> findAll(QuerySpec querySpec) {
        final List<Allergy> allergies = dslContext.select().from(Allergies.ALLERGIES).fetchInto(Allergy.class);

        LOGGER.debug("Found notes: {}", allergies);
        return querySpec.apply(allergies);
    }
}
