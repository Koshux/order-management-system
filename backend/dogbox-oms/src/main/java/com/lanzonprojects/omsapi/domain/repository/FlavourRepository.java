package com.lanzonprojects.omsapi.domain.repository;

import com.lanzonprojects.omsapi.domain.model.Allergy;
import com.lanzonprojects.omsapi.domain.model.Flavour;
import com.lanzonprojects.omsapi.jooq.generated.tables.Allergies;
import com.lanzonprojects.omsapi.jooq.generated.tables.Flavours;
import io.crnk.core.queryspec.QuerySpec;
import io.crnk.core.repository.ResourceRepositoryBase;
import io.crnk.core.resource.list.ResourceList;
import org.jooq.DSLContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author lanzon-projects.
 */
public class FlavourRepository extends ResourceRepositoryBase<Flavour, Long> {
    private static final Logger LOGGER = LoggerFactory.getLogger(FlavourRepository.class);

    @Autowired
    private DSLContext dslContext;

    public FlavourRepository() {
        super(Flavour.class);
    }

    @Override
    public ResourceList<Flavour> findAll(QuerySpec querySpec) {
        final List<Flavour> allergies = dslContext
                .select()
                .from(Flavours.FLAVOURS)
                .fetchInto(Flavour.class);

        LOGGER.debug("Found notes: {}", allergies);
        return querySpec.apply(allergies);
    }
}
