package com.lanzonprojects.omsapi.domain.repository;

import com.lanzonprojects.omsapi.domain.model.BehaviouralProblem;
import com.lanzonprojects.omsapi.jooq.generated.tables.BehaviouralProblems;
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
public class BehaviouralProblemRepository extends ResourceRepositoryBase<BehaviouralProblem, Long> {
    private static final Logger LOGGER = LoggerFactory.getLogger(BehaviouralProblemRepository.class);

    @Autowired
    private DSLContext dslContext;

    public BehaviouralProblemRepository() {
        super(BehaviouralProblem.class);
    }

    @Override
    public ResourceList<BehaviouralProblem> findAll(QuerySpec querySpec) {
        final List<BehaviouralProblem> behaviouralProblems = dslContext
                .select()
                .from(BehaviouralProblems.BEHAVIOURAL_PROBLEMS)
                .fetchInto(BehaviouralProblem.class);

        LOGGER.debug("Found notes: {}", behaviouralProblems);
        return querySpec.apply(behaviouralProblems);
    }
}
