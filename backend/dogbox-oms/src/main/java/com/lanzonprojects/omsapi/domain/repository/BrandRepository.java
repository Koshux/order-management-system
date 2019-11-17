package com.lanzonprojects.omsapi.domain.repository;

import com.lanzonprojects.omsapi.domain.model.Brand;
import com.lanzonprojects.omsapi.domain.model.Breed;
import com.lanzonprojects.omsapi.jooq.generated.tables.Brands;
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
public class BrandRepository extends ResourceRepositoryBase<Brand, Long> {
    private static final Logger LOGGER = LoggerFactory.getLogger(BrandRepository.class);

    @Autowired
    private DSLContext dslContext;

    public BrandRepository() {
        super(Brand.class);
    }

    @Override
    public Brand findOne(Long id, QuerySpec querySpec) {
        final Brand brand = dslContext
                .select()
                .from(Brands.BRANDS)
                .where(Brands.BRANDS.ID.eq(Math.toIntExact(id)))
                .fetchOneInto(Brand.class);

        LOGGER.debug("Found brand: {}", brand);
        return brand;
    }

    @Override
    public ResourceList<Brand> findAll(QuerySpec querySpec) {
        final List<Brand> brands = dslContext
                .select()
                .from(Brands.BRANDS)
                .fetchInto(Brand.class);

        LOGGER.debug("Found notes: {}", brands);
        return querySpec.apply(brands);
    }
}
