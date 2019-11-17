package com.lanzonprojects.omsapi.domain.repository;

import com.lanzonprojects.omsapi.domain.model.Customer;
import com.lanzonprojects.omsapi.domain.model.DogInfo;
import com.lanzonprojects.omsapi.jooq.generated.tables.DogsInformation;
import io.crnk.core.exception.InternalServerErrorException;
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

import static com.lanzonprojects.omsapi.jooq.generated.tables.DogsInformation.DOGS_INFORMATION;

/**
 * @author lanzon-projects.
 */
@Component
@Transactional
public class DogInfoRepository extends ResourceRepositoryBase<DogInfo, Long> {
    private static final Logger LOGGER = LoggerFactory.getLogger(DogInfoRepository.class);

    @Autowired
    private DSLContext dslContext;

    public DogInfoRepository() {
        super(DogInfo.class);
    }

    @Override
    public ResourceList<DogInfo> findAll(QuerySpec querySpec) {
        final List<DogInfo> dogsInfo = dslContext.select().from(DOGS_INFORMATION).fetchInto(DogInfo.class);
        LOGGER.debug("Found notes: {}", dogsInfo);
        return querySpec.apply(dogsInfo);
    }

    @Override
    public void delete(Long id) {
        int execute = dslContext
                .deleteFrom(DOGS_INFORMATION)
                .where(DOGS_INFORMATION.DOG_ID.equal(Math.toIntExact(id)))
                .execute();

        if (execute == 0) {
            throw new InternalServerErrorException("Something went wrong while deleting the note, please try again.");
        }
    }
}
