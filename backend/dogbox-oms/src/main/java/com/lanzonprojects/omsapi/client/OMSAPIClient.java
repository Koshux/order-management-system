package com.lanzonprojects.omsapi.client;

import com.lanzonprojects.omsapi.domain.model.Customer;
import io.crnk.client.CrnkClient;
import io.crnk.core.queryspec.QuerySpec;
import io.crnk.core.repository.ResourceRepositoryV2;
import io.crnk.core.resource.list.ResourceList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @author lanzon-projects
 */
@Component
public class OMSAPIClient {

    private static final Logger LOGGER = LoggerFactory.getLogger(com.lanzonprojects.omsapi.client.OMSAPIClient.class);

    private CrnkClient crnkClient = new CrnkClient("http://localhost:8081/lanzonprojects/api");
    private ResourceRepositoryV2<Customer, Long> resourceRepositoryV2;

    @PostConstruct
    public void init() {
        resourceRepositoryV2 = crnkClient.getRepositoryForType(Customer.class);
    }

    public ResourceList<Customer> findAll() {
        final ResourceList<Customer> customers = resourceRepositoryV2.findAll(new QuerySpec(Customer.class));

        LOGGER.info("found {}", customers.toString());
        return customers;
    }

    public Customer create(Customer entity) {
        Customer customer = resourceRepositoryV2.create(entity);

        LOGGER.info("created {}", customer);
        return customer;
    }


    public void delete(long id) {
        resourceRepositoryV2.delete(id);
        LOGGER.info("deleted note {}", id);
    }
}
