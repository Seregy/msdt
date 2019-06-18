package com.seregy77.msdt.cqrs.command.consumer.repository;

import com.seregy77.msdt.cqrs.command.consumer.entity.CachedOrderEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CachedOrderRepository extends CrudRepository<CachedOrderEntity, String> {
}
