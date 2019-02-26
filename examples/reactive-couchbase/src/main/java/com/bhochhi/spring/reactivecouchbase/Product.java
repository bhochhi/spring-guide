package com.bhochhi.spring.reactivecouchbase;

import com.couchbase.client.java.repository.annotation.Field;
import com.couchbase.client.java.repository.annotation.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.couchbase.core.mapping.Document;

import javax.validation.constraints.NotNull;

@Document
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    @Id
    private String id;
    @Field
    @NotNull
    private String name;
    @Field
    @NotNull
    private String type;
}