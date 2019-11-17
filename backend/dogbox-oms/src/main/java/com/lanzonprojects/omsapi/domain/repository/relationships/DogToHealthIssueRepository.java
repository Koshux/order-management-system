package com.lanzonprojects.omsapi.domain.repository.relationships;

import com.lanzonprojects.omsapi.domain.model.HealthIssue;
import io.crnk.core.queryspec.QuerySpec;
import io.crnk.core.repository.ManyRelationshipRepositoryBase;
import io.crnk.core.repository.RelationshipMatcher;
import io.crnk.core.resource.list.DefaultResourceList;
import io.crnk.core.resource.list.ResourceList;
import org.jooq.DSLContext;
import org.jooq.Record;
import org.jooq.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import static com.lanzonprojects.omsapi.jooq.generated.tables.Dogs.DOGS;
import static com.lanzonprojects.omsapi.jooq.generated.tables.DogsHealthIssues.DOGS_HEALTH_ISSUES;
import static com.lanzonprojects.omsapi.jooq.generated.tables.HealthIssues.HEALTH_ISSUES;

/**
 * @author lanzon-projects.
 */
@Repository
public class DogToHealthIssueRepository extends ManyRelationshipRepositoryBase<Object, Long, HealthIssue, Long> {
    private static final Logger LOGGER = LoggerFactory.getLogger(DogToHealthIssueRepository.class);

    @Autowired
    private DSLContext dsl;

    public DogToHealthIssueRepository(final DSLContext dsl) {
        this.dsl = dsl;
    }

    @Override
    public RelationshipMatcher getMatcher() {
        return new RelationshipMatcher().rule().target(HealthIssue.class).add();
    }

    @Override
    public Map<Long, ResourceList<HealthIssue>> findManyRelations(final Collection<Long> sourceIds,
                                                                  final String fieldName,
                                                                  final QuerySpec querySpec) {
        final Map<Long, ResourceList<HealthIssue>> map = new HashMap<>();
        sourceIds.forEach(sourceId -> {
            final Result<Record> healthIssuesRecords = dsl.select()
                    .from(DOGS, DOGS_HEALTH_ISSUES)
                    .where(DOGS.ID.eq(Math.toIntExact(sourceId)))
                    .and(DOGS_HEALTH_ISSUES.DOG_ID.eq(DOGS.ID))
                    .fetch();

            final DefaultResourceList<HealthIssue> healthIssues = new DefaultResourceList<>();
            healthIssuesRecords.forEach(dogHealthIssueRecord -> {
                HealthIssue healthIssue = new HealthIssue();
                healthIssue.setId(dogHealthIssueRecord.getValue(DOGS_HEALTH_ISSUES.DOG_ID));
                healthIssue.setName(dogHealthIssueRecord.getValue(HEALTH_ISSUES.NAME));
                healthIssues.add(healthIssue);
            });

            map.put(sourceId, healthIssues);
        });

        LOGGER.debug("Found dogs-health_issues: {}", map);
        return map;
    }
}
