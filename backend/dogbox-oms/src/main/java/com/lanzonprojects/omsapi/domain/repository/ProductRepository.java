package com.lanzonprojects.omsapi.domain.repository;

import com.lanzonprojects.omsapi.domain.model.Product;
import com.lanzonprojects.omsapi.jooq.generated.tables.Products;
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
public class ProductRepository extends ResourceRepositoryBase<Product, Long> {
    private static final Logger LOGGER = LoggerFactory.getLogger(ProductRepository.class);

    @Autowired
    private DSLContext dslContext;

    public ProductRepository() {
        super(Product.class);
    }

    @Override
    public ResourceList<Product> findAll(QuerySpec querySpec) {
        final List<Product> products = dslContext.select().from(Products.PRODUCTS).fetchInto(Product.class);

        LOGGER.debug("Found notes: {}", products);
        return querySpec.apply(products);
    }
}
