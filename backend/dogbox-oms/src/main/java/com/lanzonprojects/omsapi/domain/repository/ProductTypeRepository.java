package com.lanzonprojects.omsapi.domain.repository;

import com.lanzonprojects.omsapi.domain.model.ProductType;
import com.lanzonprojects.omsapi.jooq.generated.tables.ProductTypes;
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
public class ProductTypeRepository extends ResourceRepositoryBase<ProductType, Long> {
    private static final Logger LOGGER = LoggerFactory.getLogger(ProductTypeRepository.class);

    @Autowired
    private DSLContext dslContext;

    public ProductTypeRepository() {
        super(ProductType.class);
    }

    @Override
    public ResourceList<ProductType> findAll(QuerySpec querySpec) {
        final List<ProductType> allergies = dslContext
                .select()
                .from(ProductTypes.PRODUCT_TYPES)
                .fetchInto(ProductType.class);

        LOGGER.debug("Found notes: {}", allergies);
        return querySpec.apply(allergies);
    }
}
