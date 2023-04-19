package com.uespeis.service_impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uespeis.model.Activity;
import com.uespeis.repository.ArchiveRepository;
import com.uespeis.service.ArchiveService;

@Service
public class ArchiveServiceImpl implements ArchiveService {

    @Autowired
    ArchiveRepository archiveRepository;

    @Override
    public Activity save(Activity a) {
        return archiveRepository.save(a);
    }

    @Override
    public List<Activity> getAll() {
        return archiveRepository.findAll();
    }

}
