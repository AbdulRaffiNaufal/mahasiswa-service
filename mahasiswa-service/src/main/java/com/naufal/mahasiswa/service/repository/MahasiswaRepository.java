/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.naufal.mahasiswa.service.repository;

import com.naufal.mahasiswa.service.dto.Mahasiswa;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Repository;
/**
 *
 * @author IIISI
 */
@Repository
public class MahasiswaRepository {
    List<Mahasiswa> mahasiswaList = new ArrayList<>();
    
    public List<Mahasiswa> getAllMahasiswa() {
        return mahasiswaList;
    }

    public Mahasiswa getMahasiswa(String nobp) {
        Optional<Mahasiswa> first = mahasiswaList.stream().filter(u -> u.getNobp().equals(nobp)).findFirst();
        if(first.isPresent()){
            return first.get();
        }else{
            return new Mahasiswa();
        }
    }

    public void addMahasiswa(Mahasiswa mahasiswa) {
        mahasiswaList.add(mahasiswa);
    }

    public Mahasiswa updateMahasiswa(Mahasiswa mahasiswa) {
        for(Mahasiswa ul :mahasiswaList){
            if(ul.getNobp().equals(mahasiswa.getNobp())){                
                ul.setNama(mahasiswa.getNama());
                ul.setProdi(mahasiswa.getProdi());               
                ul.setKotaAsal(mahasiswa.getKotaAsal());
                ul.setNobp(mahasiswa.getNobp());
                return ul;
            }
        }
        return new Mahasiswa();
    }

    public Mahasiswa deleteMahasiswa(String nobp) {
        Optional<Mahasiswa> first = mahasiswaList.stream().filter(u -> u.getNobp().equals(nobp)).findFirst();
        if(first.isPresent()){
            Mahasiswa mahasiswa = first.get();
            mahasiswaList.remove(mahasiswa);
            return mahasiswa;
        }else{
            return new Mahasiswa();
        }
    }

}
