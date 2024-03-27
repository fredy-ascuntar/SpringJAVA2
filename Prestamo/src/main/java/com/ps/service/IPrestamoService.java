package com.ps.service;

import com.ps.model.Prestamo;

import java.util.List;

public interface IPrestamoService {

    Prestamo createPrestamo(Prestamo prestamo);
    Prestamo updatePrestamo(Prestamo prestamo);
    void deletePrestamo(Long id);

    Prestamo getPrestamoById(Long id);

    List<Prestamo> getPrestamoByLoanId(Long loanId);
}
