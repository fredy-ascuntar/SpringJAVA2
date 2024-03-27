package com.ps.service;

import com.ps.model.Prestamo;
import com.ps.repository.ClienteRepository;
import com.ps.service.IPrestamoService;
import com.ps.repository.PrestamoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
//@RequiredArgsConstructor
public class PrestamoService implements IPrestamoService {
    private final PrestamoRepository prestamoRepository;

    public PrestamoService(PrestamoRepository prestamoRepository) {
        this.prestamoRepository = prestamoRepository;
    }

    @Override
    public Prestamo getPrestamoById(Long id) {
        return prestamoRepository.getReferenceById(id);
    }

    @Override
    public List<Prestamo> getPrestamoByLoanId(Long loanId) {
        return prestamoRepository.findByLoanId(loanId);
    }

    @Override
    public Prestamo createPrestamo(Prestamo prestamo) {
        return prestamoRepository.save(prestamo);
    }

    @Override
    public Prestamo updatePrestamo(Prestamo prestamo) {
        return prestamoRepository.save((prestamo));
    }

    @Override
    public void deletePrestamo(Long id) {
        prestamoRepository.deleteById(id);

    }
}
