package org.sid;

import net.bytebuddy.utility.RandomString;
import org.sid.dao.CategoryRepository;
import org.sid.dao.ProductRepository;
import org.sid.entities.Category;
import org.sid.entities.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import java.util.Locale;
import java.util.Random;

@SpringBootApplication
public class LightEcomV1Application implements CommandLineRunner {

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private RepositoryRestConfiguration repositoryRestConfiguration;

    public static void main(String[] args) {
        SpringApplication.run(LightEcomV1Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        repositoryRestConfiguration.exposeIdsFor(Product.class,Category.class);

        Category c1=categoryRepository.save(new Category(null,"Computers",null,null,null));
        Category c2=categoryRepository.save(new Category(null,"Keyboards",null,null,null));
        Category c3=categoryRepository.save(new Category(null,"Smart phones",null,null,null));
        Category c4=categoryRepository.save(new Category(null,"Monitors",null,null,null));
        productRepository.save(new Product(null,"MSI GL65 LEOPARD","pc gamer",20000,true,false,true,"MSIGL65LEOPARD.jpg",20,c1));
        productRepository.save(new Product(null,"ASUS","pc gamer",17000,true,false,true,"ASUS.jpg",20,c1));
        productRepository.save(new Product(null,"ALIENWARE","pc gamer",20000,true,true,true,"ALIENWARE.jpg",20,c1));
        productRepository.save(new Product(null,"NITRO 5","pc gamer",15000,true,true,true,"NITRO 5.jpg",20,c1));
        productRepository.save(new Product(null,"DELL INSPIRON","pc gamer",16000,true,true,true,"DELL INSPIRON.jpg",20,c1));
        productRepository.save(new Product(null,"Corsair K100 RGB Optical","Keyboards",20000,true,false,true,"Corsair K100 RGB Optical.jpg",20,c2));
        productRepository.save(new Product(null,"Mountain Everest Max","Keyboards",2000,true,true,true,"Mountain Everest Max.jpg",20,c2));
        productRepository.save(new Product(null,"Razer Cynosa Chroma","Keyboards",1000,true,false,true,"Razer Cynosa Chroma.jpg",20,c2));
        productRepository.save(new Product(null,"G. Skill KM360","Keyboards",1200,true,false,true,"G. Skill KM360.jpg",20,c2));
        productRepository.save(new Product(null,"Logitech G915 Lightspeed","Keyboards",5000,true,false,true,"Logitech G915 Lightspeed.jpg",20,c2));
        productRepository.save(new Product(null,"HyperX Alloy Elite RGB","Keyboards",9000,true,true,true,"HyperX Alloy Elite RGB.jpg",20,c2));
        productRepository.save(new Product(null,"Kinesis Freestyle Edge RGB","Keyboards",10000,true,false,true,"Kinesis Freestyle Edge RGB.jpg",20,c2));
        productRepository.save(new Product(null,"azer Huntsman Elite","Keyboards",10000,true,true,true,"azer Huntsman Elite.jpg",20,c2));
        productRepository.save(new Product(null,"IPHONE 12 PRO MAX","Smart phones",20000,true,true,true,"IPHONE 12 PRO MAX.jpg",20,c3));
        productRepository.save(new Product(null,"IPHONE XR","Smart phones",10000,true,true,true,"IPHONE XR.jpg",20,c3));
        productRepository.save(new Product(null,"SAMSUNG GALAXY 20","Smart phones",20000,true,false,true,"SAMSUNG GALAXY 20.jpg",20,c3));
        productRepository.save(new Product(null,"Mi 11X Pro Specifications","Smart phones",18000,true,false,true,"Mi 11X Pro Specifications.jpg",20,c3));
        productRepository.save(new Product(null,"iQOO 7 Legend Specifications","Smart phones",17000,true,true,true,"iQOO 7 Legend Specifications.jpg",20,c3));
        productRepository.save(new Product(null,"OnePlus 9 Pro Specifications","Smart phones",15000,true,false,true,"OnePlus 9 Pro Specifications.jpg",20,c3));
        productRepository.save(new Product(null,"Xiaomi Mi 11 Ultra","Smart phones",9000,true,false,true,"Xiaomi Mi 11 Ultra.jpg",20,c3));
        productRepository.save(new Product(null,"LG 27GN950-B","Monitors",20000,true,true,true,"LG 27GN950-B.jpg",20,c4));
        productRepository.save(new Product(null,"Gigabyte G27Q","Monitors",30000,true,false,true,"Gigabyte G27Q.jpg",20,c4));
        productRepository.save(new Product(null,"Pixio PX277 Prime","Monitors",40000,true,false,true,"Pixio PX277 Prime.jpg",20,c4));
        productRepository.save(new Product(null,"Acer Predator X38","Monitors",50000,true,true,true,"Acer Predator X38.jpg",20,c4));
        productRepository.save(new Product(null,"ROG STRIX XG17AHPE Portable Monitor","Monitors",60000,true,true,true,"ROG STRIX.jpg",20,c4));
       /* Random rnd = new Random();
        categoryRepository.findAll().forEach(c->{
            for (int i = 0; i < 10; i++) {


                Product p = new Product();
                p.setName(RandomString.make(18));
                p.setCurrentprice(100 + rnd.nextInt(10000));
                p.setAvailable(rnd.nextBoolean());
                p.setPromotion(rnd.nextBoolean());
                p.setSelected(rnd.nextBoolean());
                p.setCategory(c);
                p.setPhotoName("unknown.png");
                productRepository.save(p);
            }
        });*/
    }
}
