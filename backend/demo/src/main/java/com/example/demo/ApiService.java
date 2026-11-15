package com.example.demo;

import com.example.demo.ApiData;
import com.example.demo.ApiRepository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ApiService {

    private final ApiRepository repository;

    public ApiService(ApiRepository repository) {
        this.repository = repository;
    }

    public ApiData savePayload(String encryptedPayload) {
        ApiData data = new ApiData();
        data.setPayload(encryptedPayload);

        return repository.save(data);
    }
    public Page<ApiData> getAllPayloads(Pageable pageable) {
        return repository.findAll(pageable);
    }

    public long getTotalPayloads() {
        return repository.count();
    }
}