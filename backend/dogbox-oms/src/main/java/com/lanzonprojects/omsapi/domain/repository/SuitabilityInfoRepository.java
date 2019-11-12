package com.lanzonprojects.omsapi.domain.repository;

import com.lanzonprojects.omsapi.domain.model.SuitabilityInfo;
import com.lanzonprojects.omsapi.jooq.generated.tables.Allergies;
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
public class SuitabilityInfoRepository extends ResourceRepositoryBase<SuitabilityInfo, Long> {
    private static final Logger LOGGER = LoggerFactory.getLogger(SuitabilityInfoRepository.class);

    @Autowired
    private DSLContext dslContext;

    public SuitabilityInfoRepository() {
        super(SuitabilityInfo.class);
    }

    @Override
    public ResourceList<SuitabilityInfo> findAll(QuerySpec querySpec) {
        final List<SuitabilityInfo> suitabilityInfoList = dslContext
                .select()
                .from(Allergies.ALLERGIES)
                .fetchInto(SuitabilityInfo.class);

        LOGGER.debug("Found notes: {}", suitabilityInfoList);
        return querySpec.apply(suitabilityInfoList);
    }
}
