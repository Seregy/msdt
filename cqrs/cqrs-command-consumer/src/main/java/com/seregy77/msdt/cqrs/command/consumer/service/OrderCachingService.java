package com.seregy77.msdt.cqrs.command.consumer.service;

import com.seregy77.msdt.cqrs.command.consumer.entity.CachedOrderEntity;
import com.seregy77.msdt.cqrs.command.consumer.repository.CachedOrderRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class OrderCachingService {
    private final CachedOrderRepository cachedOrderRepository;

    public boolean isCached(String externalId) {
        return cachedOrderRepository.existsById(externalId);
    }

    @Transactional
    public void cache(String externalId) {
        cachedOrderRepository.save(new CachedOrderEntity(externalId));
    }
}
