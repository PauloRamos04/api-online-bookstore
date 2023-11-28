package online.bookstore.api.controller;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import online.bookstore.api.domain.EntityMapper;
import online.bookstore.api.domain.book.Book;
import online.bookstore.api.domain.book.BookRepository;
import online.bookstore.api.domain.book.BookService;
import online.bookstore.api.domain.cart.CartItem;
import online.bookstore.api.domain.cart.CartItemService;
import online.bookstore.api.domain.cart.CartItemVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/cart-items")
@SecurityRequirement(name = "bearer-key")
public class CartItemController {

    @Autowired
    private CartItemService cartItemService;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private EntityMapper entityMapper;

    @PostMapping("/add")
    public ResponseEntity<CartItem> addItemToCart(@RequestBody CartItemVo cartItemVo) {
        Book book = bookRepository.findById(cartItemVo.getBook()).get();
        Optional<CartItem> addedItem = cartItemService.findByCartAndBook(cartItemVo.getCart(), book);
        if (addedItem.isPresent()) {
            CartItem existingItem = addedItem.get();
            existingItem.setQuantity(existingItem.getQuantity() + cartItemVo.getQuantity());
            cartItemService.updateCartItem(existingItem);
            return new ResponseEntity<>(existingItem, HttpStatus.OK);
        } else {
            CartItem newItem = cartItemService.createCartItem(entityMapper.fromEntity(cartItemVo, book));
            return new ResponseEntity<>(newItem, HttpStatus.CREATED);
        }
    }


    // Outros métodos do controlador, se necessário
}
