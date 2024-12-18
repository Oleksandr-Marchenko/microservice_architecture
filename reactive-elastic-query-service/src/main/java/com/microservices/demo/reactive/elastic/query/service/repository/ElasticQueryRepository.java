package com.microservices.demo.reactive.elastic.query.service.repository;

import com.microservices.demo.elastic.model.index.impl.TwitterIndexModel;
import org.springframework.data.elasticsearch.repository.config.EnableReactiveElasticsearchRepositories;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
@EnableReactiveElasticsearchRepositories
public interface ElasticQueryRepository extends ReactiveCrudRepository<TwitterIndexModel, String> {

    Flux<TwitterIndexModel> findByText(String text);
}
