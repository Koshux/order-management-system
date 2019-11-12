package com.lanzonprojects.omsapi.domain.repository;

import com.lanzonprojects.omsapi.domain.model.Ingredient;
import com.lanzonprojects.omsapi.jooq.generated.tables.Ingredients;
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
public class IngredientRepository extends ResourceRepositoryBase<Ingredient, Long> {
    private static final Logger LOGGER = LoggerFactory.getLogger(IngredientRepository.class);

    @Autowired
    private DSLContext dslContext;

    public IngredientRepository() {
        super(Ingredient.class);
    }

    @Override
    public ResourceList<Ingredient> findAll(QuerySpec querySpec) {
        final List<Ingredient> ingredients = dslContext.select().from(Ingredients.INGREDIENTS).fetchInto(Ingredient.class);

        LOGGER.debug("Found notes: {}", ingredients);
        return querySpec.apply(ingredients);
    }
}
