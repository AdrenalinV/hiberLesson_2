package ru.geekbrains.hiber.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.geekbrains.hiber.entities.Buyer;
import ru.geekbrains.hiber.entities.Product;
import ru.geekbrains.hiber.repositories.BuyersRepository;
import ru.geekbrains.hiber.repositories.ProductsRepository;

@Component
public class DataService {

    private ProductsRepository productsRepository;
    private BuyersRepository buyersRepository;

    @Autowired
    public DataService(ProductsRepository productsRepository, BuyersRepository buyersRepository) {
        this.productsRepository = productsRepository;
        this.buyersRepository = buyersRepository;
    }


    public void getPrintBuyersByProductId(long id) {
        Product p = this.productsRepository.readProduct(id);
        System.out.println(p.getTitle() + " bought:");
        for (Buyer b : p.getBuyers()) {
            System.out.println(b);
        }
    }
    public void getPrintProductsByBuyerId(long id) {
        Buyer b = this.buyersRepository.readBuyer(id);
        System.out.println("Buyer name "+ b.getName() + " bought:");
        for (Product p : b.getProducts()) {
            System.out.println(p);
        }
    }


}
