package com.book_order.service.order_service;


import com.book_order.model.BookOder;

import java.util.List;

public interface IOderService {
    List<BookOder> finAll();
    void save (BookOder bookOder);
    BookOder finById(Integer id);
    void update(BookOder bookOder);
    void remove(BookOder bookOder);
    BookOder finByOtp(int otp);
}
