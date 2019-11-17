package com.lanzonprojects.omsapi.domain.repository.relationships;

import com.lanzonprojects.omsapi.domain.model.Brand;
import io.crnk.core.queryspec.QuerySpec;
import io.crnk.core.repository.OneRelationshipRepositoryBase;
import io.crnk.core.repository.RelationshipMatcher;
import org.jooq.DSLContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import static com.lanzonprojects.omsapi.jooq.generated.tables.Brands.BRANDS;

/**
 * @author lanzon-projects.
 */
@Repository
public class ProductToBrandRepository extends OneRelationshipRepositoryBase<Object, Long, Brand, Long> {
    private static final Logger LOGGER = LoggerFactory.getLogger(ProductToBrandRepository.class);

    @Autowired
    private DSLContext dsl;

    public ProductToBrandRepository(final DSLContext dsl) {
        this.dsl = dsl;
    }

    @Override
    public RelationshipMatcher getMatcher() {
        return new RelationshipMatcher().rule().target(Brand.class).add();
    }

    @Override
    public Map<Long, Brand> findOneRelations(Collection<Long> sourceIds, String fieldName, QuerySpec querySpec) {
        final Map<Long, Brand> map = new HashMap<>();

        sourceIds.forEach(sourceId -> {
            final Brand brand = dsl
                    .select()
                    .from(BRANDS)
                    .where(BRANDS.ID.eq(Math.toIntExact(sourceId)))
                    .fetchOneInto(Brand.class);

            map.put(sourceId, brand);
        });

        LOGGER.debug("Found brands: {}", map);
        return map;
    }
}
