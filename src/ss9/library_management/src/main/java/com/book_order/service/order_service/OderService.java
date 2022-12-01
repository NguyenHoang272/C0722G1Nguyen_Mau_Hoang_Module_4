package com.book_order.service.order_service;

import com.book_order.model.BookOder;
import com.book_order.repository.IOderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class OderService implements IOderService {
    @Autowired
    private IOderRepository oderRepository;


    @Override
    public List<BookOder> finAll() {
        return oderRepository.findAll();
    }

    @Override
    public void save(BookOder bookOder) {
        oderRepository.save(bookOder);
    }

    @Override
    public BookOder finById(Integer id) {
        return oderRepository.findById(id).orElse(null);
    }

    @Override
    public void update(BookOder bookOder) {
        oderRepository.save(bookOder);
    }

    @Override
    public void remove(BookOder bookOder) {
        oderRepository.delete(bookOder);
    }

    @Override
    public BookOder finByOtp(int otp) {
        return null;
    }
}
