package com.microservices.demo.elastic.query.service.common.transformer;

import com.microservices.demo.elastic.model.index.impl.TwitterIndexModel;
import com.microservices.demo.elastic.query.service.common.model.ElasticQueryServiceResponseModel;
import org.springframework.stereotype.Component;

import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class ElasticToResponseModelTransformer {

    public ElasticQueryServiceResponseModel getResponseModel(TwitterIndexModel twitterIndexModel) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ssZ");

        return ElasticQueryServiceResponseModel
                .builder()
                .id(twitterIndexModel.getId())
                .userId(twitterIndexModel.getUserId())
                .text(twitterIndexModel.getText())
                .createdAt(OffsetDateTime.parse(twitterIndexModel.getCreatedAt(), formatter).toLocalDateTime())
                .build();
    }

    public List<ElasticQueryServiceResponseModel> getResponseModels(List<TwitterIndexModel> twitterIndexModels) {
        return twitterIndexModels.stream().map(this::getResponseModel).collect(Collectors.toList());
    }
}
