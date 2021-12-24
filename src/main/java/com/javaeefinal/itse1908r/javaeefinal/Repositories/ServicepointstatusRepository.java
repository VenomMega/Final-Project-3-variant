package com.javaeefinal.itse1908r.javaeefinal.Repositories;

import com.javaeefinal.itse1908r.javaeefinal.Models.Servicepointstatus;

import java.util.List;

public interface ServicepointstatusRepository {
    List<Servicepointstatus> findAll();
    Servicepointstatus findById(Long id);
}
