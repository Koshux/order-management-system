package com.lanzonprojects.omsapi.domain.repository;

import com.lanzonprojects.omsapi.domain.model.ToyType;
import com.lanzonprojects.omsapi.jooq.generated.tables.ToyTypes;
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
public class ToyTypeRepository extends ResourceRepositoryBase<ToyType, Long> {
    private static final Logger LOGGER = LoggerFactory.getLogger(ToyTypeRepository.class);

    @Autowired
    private DSLContext dslContext;

    public ToyTypeRepository() {
        super(ToyType.class);
    }

    @Override
    public ResourceList<ToyType> findAll(QuerySpec querySpec) {
        final List<ToyType> allergies = dslContext.select().from(ToyTypes.TOY_TYPES).fetchInto(ToyType.class);

        LOGGER.debug("Found notes: {}", allergies);
        return querySpec.apply(allergies);
    }
}
