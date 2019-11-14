package com.lanzonprojects.omsapi.domain.repository;

import com.lanzonprojects.omsapi.domain.model.Attribute;
import com.lanzonprojects.omsapi.jooq.generated.tables.Attributes;
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
public class AttributeRepository extends ResourceRepositoryBase<Attribute, Long> {
    private static final Logger LOGGER = LoggerFactory.getLogger(AttributeRepository.class);

    @Autowired
    private DSLContext dslContext;

    public AttributeRepository() {
        super(Attribute.class);
    }

    @Override
    public ResourceList<Attribute> findAll(QuerySpec querySpec) {
        final List<Attribute> attributes = dslContext.select().from(Attributes.ATTRIBUTES).fetchInto(Attribute.class);

        LOGGER.debug("Found notes: {}", attributes);
        return querySpec.apply(attributes);
    }
}
