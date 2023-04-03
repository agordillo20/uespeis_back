package com.uespeis.service_impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.uespeis.repository.ArchiveRepository;
import com.uespeis.service.ArchiveService;

@Service
public class ArchiveServiceImpl implements ArchiveService {

    @Autowired
    ArchiveRepository archiveRepository;

    @Override
    public com.uespeis.model.Archive save(com.uespeis.model.Archive a) {
        return archiveRepository.save(a);
    }

}
