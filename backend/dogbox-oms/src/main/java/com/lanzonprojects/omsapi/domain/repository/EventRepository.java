package com.lanzonprojects.omsapi.domain.repository;

import com.lanzonprojects.omsapi.domain.model.Event;
import com.lanzonprojects.omsapi.jooq.generated.tables.Events;
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
public class EventRepository extends ResourceRepositoryBase<Event, Long> {
    private static final Logger LOGGER = LoggerFactory.getLogger(EventRepository.class);

    @Autowired
    private DSLContext dslContext;

    public EventRepository() {
        super(Event.class);
    }

    @Override
    public ResourceList<Event> findAll(QuerySpec querySpec) {
        final List<Event> events = dslContext.select().from(Events.EVENTS).fetchInto(Event.class);

        LOGGER.debug("Found notes: {}", events);
        return querySpec.apply(events);
    }
}
