package com.project.WMS.Services.Implement;

import com.project.WMS.Dtos.DrinkDTO;
import com.project.WMS.Entities.Drink;
import com.project.WMS.Entities.Product;
import com.project.WMS.Repositories.DrinkRepository;
import com.project.WMS.Repositories.ProductRepository;
import com.project.WMS.Services.DrinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DrinkImplService implements DrinkService {
    private final DrinkRepository drinkRepository;
    private final ProductRepository productRepository;

    public DrinkImplService(DrinkRepository drinkRepository, ProductRepository productRepository) {
        this.drinkRepository = drinkRepository;
        this.productRepository = productRepository;
    }


    @Override
    public void createDrink(DrinkDTO drinkDTO) {
        if (drinkDTO == null) {
            throw new IllegalArgumentException("La información del producto no puede ser nula");
        }

        // Lógica de validación y creación de Drink
        Drink drink = new Drink();
        drink.setTypeOfPackaging(drinkDTO.getTypeOfPackaging());

        // Copiar propiedades de ProductDTO a Drink (clase padre)
        drink.setName(drinkDTO.getName());
        drink.setPrice(drinkDTO.getPrice());
        drink.setStock(drinkDTO.getStock());

        // Guardar en el repositorio
        drinkRepository.save(drink);
    }
}
