package online.bookstore.api.domain.cart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class CartService {

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private CartItemService cartItemService;

    public List<Cart> getAllCarts() {
        return cartRepository.findAll();
    }

    public Optional<Cart> getCartByUserId(Long userId) {
        return cartRepository.findByUserId(userId);
    }

    public Cart createCart(Cart cart) {
        return cartRepository.save(cart);
    }

    @Transactional
    public Cart updateCart(Long cartId, Cart updatedCart) {
        return cartRepository.findById(cartId)
                .map(existingCart -> {
                    // O Spring Data JPA atualizará automaticamente as propriedades
                    // Não é necessário mapear manualmente
                    return existingCart;
                })
                .orElseThrow(() -> new RuntimeException("Cart not found with ID: " + cartId));
    }

    public void deleteCart(Long cartId) {
        cartRepository.deleteById(cartId);
    }

    // Outros métodos do serviço, se necessário
}
