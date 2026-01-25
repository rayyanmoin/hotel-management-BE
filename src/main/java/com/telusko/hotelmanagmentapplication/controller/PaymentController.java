package com.telusko.hotelmanagmentapplication.controller;

import com.telusko.hotelmanagmentapplication.domains.Payment;
import com.telusko.hotelmanagmentapplication.dto.PaymentDTO;
import com.telusko.hotelmanagmentapplication.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/payments")
@RequiredArgsConstructor
public class PaymentController {

    private final PaymentService paymentService;

    @GetMapping
    public List<PaymentDTO> getAll() {
        return paymentService.getAll();
    }

    @GetMapping("/{id}")
    public PaymentDTO get(@PathVariable Long id) {
        return paymentService.get(id);
    }

    @PostMapping
    public PaymentDTO create(@RequestBody PaymentDTO dto) {
        return paymentService.create(dto);
    }
}