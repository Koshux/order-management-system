package com.lanzonprojects.omsapi.domain.repository.relationships;

import com.lanzonprojects.omsapi.domain.model.DogInfo;
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
import static com.lanzonprojects.omsapi.jooq.generated.tables.DogsInformation.DOGS_INFORMATION;

/**
 * @author lanzon-projects.
 */
@Repository
public class DogToDogInfoRepository extends ManyRelationshipRepositoryBase<Object, Long, DogInfo, Long> {
    private static final Logger LOGGER = LoggerFactory.getLogger(DogToDogInfoRepository.class);

    @Autowired
    private DSLContext dsl;

    public DogToDogInfoRepository(final DSLContext dsl) {
        this.dsl = dsl;
    }

    @Override
    public RelationshipMatcher getMatcher() {
        return new RelationshipMatcher().rule().target(DogInfo.class).add();
    }

    @Override
    public Map<Long, ResourceList<DogInfo>> findManyRelations(final Collection<Long> sourceIds,
                                                              final String fieldName,
                                                              final QuerySpec querySpec) {
        final Map<Long, ResourceList<DogInfo>> map = new HashMap<>();
        sourceIds.forEach(sourceId -> {
            final Result<Record> dogInformationRecords = dsl.select()
                    .from(DOGS, DOGS_INFORMATION)
                    .where(DOGS.ID.eq(Math.toIntExact(sourceId)))
                    .and(DOGS_INFORMATION.DOG_ID.eq(DOGS.ID))
                    .fetch();

            final DefaultResourceList<DogInfo> dogsInfoList = new DefaultResourceList<>();
            dogInformationRecords.forEach(dogInfoRecord -> {
                DogInfo dogInfo = new DogInfo();
                dogInfo.setDogId(dogInfoRecord.getValue(DOGS_INFORMATION.DOG_ID));
                dogInfo.setAllergyId(dogInfoRecord.getValue(DOGS_INFORMATION.ALLERGY_ID));
                dogInfo.setToyTypeId(dogInfoRecord.getValue(DOGS_INFORMATION.TOY_TYPE_ID));
                dogInfo.setHealthIssueId(dogInfoRecord.getValue(DOGS_INFORMATION.HEALTH_ISSUE_ID));
                dogInfo.setBehaviouralProblemId(dogInfoRecord.getValue(DOGS_INFORMATION.BEHAVIOURAL_PROBLEM_ID));
                dogsInfoList.add(dogInfo);
            });

            map.put(sourceId, dogsInfoList);
        });

        LOGGER.debug("Found dogs-information: {}", map);
        return map;
    }
}
