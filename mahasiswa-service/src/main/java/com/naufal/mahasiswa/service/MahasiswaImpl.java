/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.naufal.mahasiswa.service;

import com.naufal.mahasiswa.service.dto.Mahasiswa;
import com.naufal.mahasiswa.service.repository.MahasiswaRepository;
import com.naufal.mahasiswa.service.userservice.MahasiswaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 *
 * @author IIISI
 */
@Service
public class MahasiswaImpl implements MahasiswaService{
    @Autowired
    private MahasiswaRepository mahasiswaRepository;
    
    @Override
    public List<Mahasiswa> getAllMahasiswa() {
        return mahasiswaRepository.getAllMahasiswa();
    }

    @Override
    public Mahasiswa getMahasiswa(String nobp) {
        return mahasiswaRepository.getMahasiswa(nobp);
    }

    @Override
    public void addMahasiswa(Mahasiswa mahasiswa) {
        mahasiswaRepository.addMahasiswa(mahasiswa);
    }

    @Override
    public Mahasiswa updateMahasiswa(Mahasiswa mahasiswa) {
        return mahasiswaRepository.updateMahasiswa(mahasiswa);
    }

    @Override
    public Mahasiswa deleteMahasiswa(String nobp) {
        return mahasiswaRepository.deleteMahasiswa(nobp);
    }
}
