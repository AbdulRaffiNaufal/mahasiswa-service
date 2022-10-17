/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.naufal.mahasiswa.service.controller;

import com.naufal.mahasiswa.service.dto.Mahasiswa;
import com.naufal.mahasiswa.service.userservice.MahasiswaService;
import java.net.URI;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
/**
 *
 * @author IIISI
 */
@RestController
public class MahasiswaController {
    @Autowired
    private MahasiswaService mahasiswaService;
    @GetMapping("/mahasiswa")
    public List<Mahasiswa> getAllMahasiswa(){
        return mahasiswaService.getAllMahasiswa();
    }
    
    @GetMapping("/mahasiswa/{nobp}")
    public Mahasiswa getMahasiswa(@PathVariable String nobp){
        return mahasiswaService.getMahasiswa(nobp);
    }
    @PostMapping("/mahasiswa")
    public ResponseEntity<Object> addMahasiswa(@RequestBody Mahasiswa mahasiswa){
        mahasiswaService.addMahasiswa(mahasiswa);
        URI path = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{nobp}")
                .buildAndExpand(mahasiswa.getNobp())
                .toUri();
        return ResponseEntity.created(path).build();
    }
    
    @PutMapping("/mahasiswa")
    public Mahasiswa updateMahasiswa(@RequestBody Mahasiswa mahasiswa){
        return mahasiswaService.updateMahasiswa(mahasiswa);
    }
    
    @DeleteMapping("/mahasiswa{nobp}")
    public Mahasiswa deleteMahasiswa(String nobp){
        return mahasiswaService.deleteMahasiswa(nobp);
    }
}
