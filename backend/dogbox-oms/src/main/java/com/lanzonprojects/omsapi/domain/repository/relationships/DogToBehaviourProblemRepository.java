package com.lanzonprojects.omsapi.domain.repository.relationships;

import com.lanzonprojects.omsapi.domain.model.BehaviouralProblem;
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

import static com.lanzonprojects.omsapi.jooq.generated.tables.BehaviouralProblems.BEHAVIOURAL_PROBLEMS;
import static com.lanzonprojects.omsapi.jooq.generated.tables.Dogs.DOGS;
import static com.lanzonprojects.omsapi.jooq.generated.tables.DogsBehaviouralProblems.DOGS_BEHAVIOURAL_PROBLEMS;

/**
 * @author lanzon-projects.
 */
@Repository
public class DogToBehaviourProblemRepository extends ManyRelationshipRepositoryBase<Object, Long, BehaviouralProblem, Long> {
    private static final Logger LOGGER = LoggerFactory.getLogger(DogToBehaviourProblemRepository.class);

    @Autowired
    private DSLContext dsl;

    public DogToBehaviourProblemRepository(final DSLContext dsl) {
        this.dsl = dsl;
    }

    @Override
    public RelationshipMatcher getMatcher() {
        return new RelationshipMatcher().rule().target(BehaviouralProblem.class).add();
    }

    @Override
    public Map<Long, ResourceList<BehaviouralProblem>> findManyRelations(final Collection<Long> sourceIds,
                                                                         final String fieldName,
                                                                         final QuerySpec querySpec) {
        final Map<Long, ResourceList<BehaviouralProblem>> map = new HashMap<>();
        sourceIds.forEach(sourceId -> {
            final Result<Record> behaviourProblemRecords = dsl.select()
                    .from(DOGS, DOGS_BEHAVIOURAL_PROBLEMS)
                    .where(DOGS.ID.eq(Math.toIntExact(sourceId)))
                    .and(DOGS_BEHAVIOURAL_PROBLEMS.DOG_ID.eq(DOGS.ID))
                    .fetch();

            final DefaultResourceList<BehaviouralProblem> behaviouralProblems = new DefaultResourceList<>();
            behaviourProblemRecords.forEach(dogBehaviouralProblemRecord -> {
                BehaviouralProblem behaviouralProblem = new BehaviouralProblem();
                behaviouralProblem.setId(dogBehaviouralProblemRecord.getValue(DOGS_BEHAVIOURAL_PROBLEMS.DOG_ID));
                behaviouralProblem.setName(dogBehaviouralProblemRecord.getValue(BEHAVIOURAL_PROBLEMS.NAME));
                behaviouralProblems.add(behaviouralProblem);
            });

            map.put(sourceId, behaviouralProblems);
        });

        LOGGER.debug("Found dogs-behavioural_problems: {}", map);
        return map;
    }
}
