package org.chenfeng.taling.business.entity.service;

import org.chenfeng.taling.business.entity.ProductDemo;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface ProductRepository extends ElasticsearchRepository<ProductDemo,Long> {
}
