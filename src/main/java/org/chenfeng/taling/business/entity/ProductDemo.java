package org.chenfeng.taling.business.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Data
@Document(indexName = "product", type = "doc",shards = 1,replicas = 0)
public class ProductDemo {

    @Id
    private Long id;

    @Field(type = FieldType.Text, analyzer = "ik_max_word")
    private String goodsName;

    @Field(index = false, type = FieldType.Keyword)
    private String goodsImage;

    @Field(type = FieldType.Double)
    private Double price;
}
