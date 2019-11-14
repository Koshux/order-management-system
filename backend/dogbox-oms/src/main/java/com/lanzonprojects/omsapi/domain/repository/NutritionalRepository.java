package com.lanzonprojects.omsapi.domain.repository;

import com.lanzonprojects.omsapi.domain.model.NutritionalInfo;
import com.lanzonprojects.omsapi.jooq.generated.tables.Allergies;
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
public class NutritionalRepository extends ResourceRepositoryBase<NutritionalInfo, Long> {
    private static final Logger LOGGER = LoggerFactory.getLogger(NutritionalRepository.class);

    @Autowired
    private DSLContext dslContext;

    public NutritionalRepository() {
        super(NutritionalInfo.class);
    }

    @Override
    public ResourceList<NutritionalInfo> findAll(QuerySpec querySpec) {
        final List<NutritionalInfo> nutritionalInfoList = dslContext
                .select()
                .from(Allergies.ALLERGIES)
                .fetchInto(NutritionalInfo.class);

        LOGGER.debug("Found notes: {}", nutritionalInfoList);
        return querySpec.apply(nutritionalInfoList);
    }
}
