package online.bookstore.api.domain.cart;
import online.bookstore.api.domain.book.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CartItemService {

    @Autowired
    private CartItemRepository cartItemRepository;

    public Optional<CartItem> findByCartAndBook(Cart cart, Book book) {
        return cartItemRepository.findByCartAndBook(cart, book);
    }

    public CartItem createCartItem(CartItem cartItem) {
        return cartItemRepository.save(cartItem);
    }

    public CartItem updateCartItem(CartItem cartItem) {
        return cartItemRepository.save(cartItem);
    }

    // Outros métodos do serviço, se necessário
}
