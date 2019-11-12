package com.lanzonprojects.omsapi.domain.repository;

import com.lanzonprojects.omsapi.domain.model.Size;
import com.lanzonprojects.omsapi.jooq.generated.tables.Sizes;
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
public class SizeRepository extends ResourceRepositoryBase<Size, Long> {
    private static final Logger LOGGER = LoggerFactory.getLogger(SizeRepository.class);

    @Autowired
    private DSLContext dslContext;

    public SizeRepository() {
        super(Size.class);
    }

    @Override
    public ResourceList<Size> findAll(QuerySpec querySpec) {
        final List<Size> allergies = dslContext.select().from(Sizes.SIZES).fetchInto(Size.class);

        LOGGER.debug("Found notes: {}", allergies);
        return querySpec.apply(allergies);
    }
}
