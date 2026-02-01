package com.spring.store.services;

import com.spring.store.entities.Address;
import com.spring.store.entities.Category;
import com.spring.store.entities.Product;
import com.spring.store.entities.User;
import com.spring.store.repositories.AddressRepository;
import com.spring.store.repositories.ProductRepository;
import com.spring.store.repositories.ProfileRepository;
import com.spring.store.repositories.UserRepository;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@AllArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final ProfileRepository profileRepository;
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;
    private  AddressRepository adressRepository;
    private final EntityManager entityManager;
    private final AddressRepository addressRepository;

    @Transactional
    public void showEntityStates() {
     var user = User.builder()
             .name("someone")
             .email("solgaleo681@gmail.com")
             .password("something something")
             .build();
     if(entityManager.contains(user)) {
         System.out.println("persistence");
     }
     else {
         System.out.println("transient");
     }
     userRepository.save(user);

        if(entityManager.contains(user)) {
            System.out.println("persistence");
        }
        else {
            System.out.println("transient");
        }
    }

    @Transactional
    public void showRelatedEntities() {
        var profile = profileRepository.findById(12L).orElseThrow();
        System.out.println(profile.getUser().getEmail());
    }

    public void fetchAddress() {
        var address = addressRepository.findById(1L).orElseThrow();


    }

    public void persistRelated() {
        var user = User.builder()
                .name("Benedict Bridgerton")
                .email("btothetown@gmail.com")
                .password("sophiebaek")
                .build();
        var address = Address.builder()
                .street("bridgerton alley").city("london").state("london").zip("111111").build();
        user.addAddress(address);
        userRepository.save(user);


    }
    @Transactional
    public void deleteRelated() {
        var user = userRepository.findById(12L).orElseThrow();
        var address = user.getAddresses().get(0);
        user.removeAddress(address);
        userRepository.save(user);

    }

    public void manageProducts() {
        var category = new Category("Category1");

        var product = Product.builder()
                .name("Gaming Laptop")
                .description("High performance laptop for gaming")
                .price(BigDecimal.valueOf(1500.00))
                .category(category)
                .build();
        productRepository.save(product);
    }


}
