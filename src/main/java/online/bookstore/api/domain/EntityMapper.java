package online.bookstore.api.domain;

import online.bookstore.api.domain.book.Book;
import online.bookstore.api.domain.cart.CartItem;
import online.bookstore.api.domain.cart.CartItemVo;
import org.springframework.stereotype.Component;

@Component
public class EntityMapper {

    public CartItem fromEntity(CartItemVo cartItemVo, Book book) {
        return new CartItem(cartItemVo.getId(), cartItemVo.getCart(), book, cartItemVo.getQuantity());
    }
}
