package com.inventory.management.service.impl;

import com.inventory.management.entity.Settings;
import com.inventory.management.repository.SettingsRepository;
import com.inventory.management.service.SettingsService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Service;

@Service
public class SettingsServiceImpl implements SettingsService {

    private final SettingsRepository repo;

    private static final Logger log =
            LoggerFactory.getLogger(
                    SettingsServiceImpl.class);

    public SettingsServiceImpl(
            SettingsRepository repo) {

        this.repo = repo;
    }

    @Override
    public Settings getSettings() {

        log.info(
                "Fetching application settings");

        return repo.findById(1L)
                .orElseGet(() -> {

                    log.warn(
                            "Settings not found, creating default settings");

                    Settings s =
                            new Settings();

                    s.setSafetyStock(5);

                    s.setReorderLevel(10);

                    s.setStoreName("StockFlow");

                    s.setCurrencySymbol("₹");

                    Settings saved =
                            repo.save(s);

                    log.info(
                            "Default settings created successfully");

                    return saved;
                });
    }

    @Override
    public Settings save(
            Settings input) {

        log.info(
                "Updating application settings");

        input.setId(1L);

        Settings saved =
                repo.save(input);

        log.info(
                "Settings updated successfully");

        return saved;
    }
}