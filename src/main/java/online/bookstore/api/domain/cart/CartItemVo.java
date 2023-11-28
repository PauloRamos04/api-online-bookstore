package online.bookstore.api.domain.cart;

import jakarta.persistence.*;
import lombok.Data;
import online.bookstore.api.domain.book.Book;

@Data
public class CartItemVo {


    private Long id;

    private Cart cart;

    private Long book;

    private int quantity;

}
