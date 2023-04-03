package com.uespeis.controller;

import java.io.IOException;
import java.sql.Blob;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.uespeis.model.Archive;
import com.uespeis.service_impl.ArchiveServiceImpl;

import jakarta.persistence.EntityManagerFactory;

@RestController
@CrossOrigin("*")
@RequestMapping(path="/archives")
public class ArchiveController {

    @Autowired
    private ArchiveServiceImpl service; 
    @Autowired
    private EntityManagerFactory entityManagerFactory;

    @PostMapping("/save")
    public void uploadPdfFile(@RequestParam("archive") MultipartFile file) {

        try {
            Archive a = new Archive();
            Session session = null;
            try{
                session = getSessionFactory().getCurrentSession();
            }catch(Exception e){
                session = getSessionFactory().openSession();
            }
            Blob blob=session.getLobHelper().createBlob(file.getInputStream(),file.getSize());
            a.setResource(blob);
            a.setType(file.getContentType());
            service.save(a);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    private SessionFactory getSessionFactory() {
        return entityManagerFactory.unwrap(SessionFactory.class);
    }


}
