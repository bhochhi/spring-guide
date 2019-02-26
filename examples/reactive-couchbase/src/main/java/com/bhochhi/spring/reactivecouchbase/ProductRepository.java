package com.bhochhi.spring.reactivecouchbase;

import org.springframework.data.couchbase.core.query.N1qlPrimaryIndexed;
import org.springframework.data.couchbase.core.query.ViewIndexed;
import org.springframework.data.couchbase.repository.ReactiveCouchbaseRepository;

@N1qlPrimaryIndexed
@ViewIndexed(designDoc = "product")
public interface ProductRepository extends ReactiveCouchbaseRepository<Product, String> {


}