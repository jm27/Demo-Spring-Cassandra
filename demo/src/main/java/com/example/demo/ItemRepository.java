package com.example.demo;

import org.springframework.data.cassandra.repository.ReactiveCassandraRepository;

import java.util.UUID;

public interface ItemRepository extends ReactiveCassandraRepository<Item, UUID> {

}
