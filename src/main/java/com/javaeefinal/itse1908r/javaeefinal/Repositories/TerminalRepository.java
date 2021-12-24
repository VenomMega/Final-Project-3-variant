package com.javaeefinal.itse1908r.javaeefinal.Repositories;

import com.javaeefinal.itse1908r.javaeefinal.Models.Terminal;

import java.util.List;

public interface TerminalRepository {
    List<Terminal> findAll();
    Terminal findById(Long id);
    Terminal changeTerminalStatusById(int id, int status);
}
