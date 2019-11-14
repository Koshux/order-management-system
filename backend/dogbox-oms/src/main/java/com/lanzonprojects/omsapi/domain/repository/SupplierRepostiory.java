package com.lanzonprojects.omsapi.domain.repository;

import com.lanzonprojects.omsapi.domain.model.Supplier;
import com.lanzonprojects.omsapi.jooq.generated.tables.Suppliers;
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
public class SupplierRepostiory extends ResourceRepositoryBase<Supplier, Long> {
    private static final Logger LOGGER = LoggerFactory.getLogger(SupplierRepostiory.class);

    @Autowired
    private DSLContext dslContext;

    public SupplierRepostiory() {
        super(Supplier.class);
    }

    @Override
    public ResourceList<Supplier> findAll(QuerySpec querySpec) {
        final List<Supplier> suppliers = dslContext.select().from(Suppliers.SUPPLIERS).fetchInto(Supplier.class);

        LOGGER.debug("Found notes: {}", suppliers);
        return querySpec.apply(suppliers);
    }
}
