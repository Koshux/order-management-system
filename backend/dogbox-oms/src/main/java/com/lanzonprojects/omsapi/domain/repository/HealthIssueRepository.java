package com.lanzonprojects.omsapi.domain.repository;

import com.lanzonprojects.omsapi.domain.model.HealthIssue;
import com.lanzonprojects.omsapi.jooq.generated.tables.HealthIssues;
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
public class HealthIssueRepository extends ResourceRepositoryBase<HealthIssue, Long> {
    private static final Logger LOGGER = LoggerFactory.getLogger(HealthIssueRepository.class);

    @Autowired
    private DSLContext dslContext;

    public HealthIssueRepository() {
        super(HealthIssue.class);
    }

    @Override
    public ResourceList<HealthIssue> findAll(QuerySpec querySpec) {
        final List<HealthIssue> healthIssues = dslContext
                .select()
                .from(HealthIssues.HEALTH_ISSUES)
                .fetchInto(HealthIssue.class);

        LOGGER.debug("Found notes: {}", healthIssues);
        return querySpec.apply(healthIssues);
    }
}
