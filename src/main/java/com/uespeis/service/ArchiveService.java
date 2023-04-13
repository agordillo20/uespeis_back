package com.uespeis.service;

import java.util.List;

import com.uespeis.model.Archive;

public interface ArchiveService {

    public Archive save(Archive a);
    public List<Archive> getAll();

}
