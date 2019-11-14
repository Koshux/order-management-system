package com.lanzonprojects.omsapi.domain.repository;

import com.lanzonprojects.omsapi.domain.model.FinancialInfo;
import com.lanzonprojects.omsapi.jooq.generated.tables.FinancialInformation;
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
public class FinancialInfoRepository extends ResourceRepositoryBase<FinancialInfo, Long> {
    private static final Logger LOGGER = LoggerFactory.getLogger(FinancialInfoRepository.class);

    @Autowired
    private DSLContext dslContext;

    public FinancialInfoRepository() {
        super(FinancialInfo.class);
    }

    @Override
    public ResourceList<FinancialInfo> findAll(QuerySpec querySpec) {
        final List<FinancialInfo> financialInfoList = dslContext
                .select()
                .from(FinancialInformation.FINANCIAL_INFORMATION)
                .fetchInto(FinancialInfo.class);

        LOGGER.debug("Found notes: {}", financialInfoList);
        return querySpec.apply(financialInfoList);
    }
}
