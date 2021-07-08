package com.bcopstein.CtrlCorredorV1.business_logic;

import com.bcopstein.CtrlCorredorV1.reporitory.Corredor;
import com.bcopstein.CtrlCorredorV1.reporitory.CorredorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ServicoCorredor {

    private CorredorRepository corredorRepository;

    @Autowired

    public ServicoCorredor(CorredorRepository corredorRepository) {
        this.corredorRepository = corredorRepository;
    }

    public void cadastraCorredor(Corredor corredor) {
        corredorRepository.removeTodos();
        corredorRepository.cadastraCorredor(corredor);
    }

    public List<Corredor> consultaCorredor() {
        return corredorRepository.consultaCorredor();
    }

    public void removeTodos() {
        corredorRepository.removeTodos();
    }
}
