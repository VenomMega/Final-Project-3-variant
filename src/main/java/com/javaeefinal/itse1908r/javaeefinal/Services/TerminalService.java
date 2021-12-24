package com.javaeefinal.itse1908r.javaeefinal.Services;

import com.javaeefinal.itse1908r.javaeefinal.Models.Terminal;
import com.javaeefinal.itse1908r.javaeefinal.Repositories.TerminalRepository;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import javax.ejb.Stateful;
import javax.inject.Inject;
import java.util.List;

@Stateful
@RunWith(JUnit4.class)
public class TerminalService {
    @Inject
    TerminalRepository terminalRepository;

//    @Test
    public List<Terminal> getAllServicepoints() {return terminalRepository.findAll();}

//    @Test
    public Terminal getServicepointById(Long id) {return terminalRepository.findById(id);}

    public Terminal updateStatus(int id, int status) {return terminalRepository.changeTerminalStatusById(id, status);}
}
