package taco.bootstrap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import taco.domain.Ingredient;
import taco.domain.IngredientType;
import taco.domain.Taco;
import taco.repository.IngredientRepository;
import taco.repository.TacoRepository;
import taco.repository.UserRepository;

import java.util.Arrays;

@Component
public class PreloadData implements CommandLineRunner {

  private static final Logger log = LoggerFactory.getLogger(PreloadData.class);


  final IngredientRepository repo;
  final UserRepository userRepository;
  final PasswordEncoder encoder;
  final TacoRepository tacoRepository;

  public PreloadData(IngredientRepository repo, UserRepository userRepository,
                     PasswordEncoder encoder, TacoRepository tacoRepository){
    this.repo = repo;
    this.userRepository = userRepository;
    this.encoder = encoder;
    this.tacoRepository = tacoRepository;
  }

  @Override
  public void run(String... args) throws Exception{



            Ingredient flourTortilla = new Ingredient(
            "FLTO", "Flour Tortilla", IngredientType.WRAP);

    Ingredient cornTortilla = new Ingredient(
            "COTO", "Corn Tortilla", IngredientType.WRAP);
    Ingredient groundBeef = new Ingredient(
            "GRBF", "Ground Beef", IngredientType.PROTEIN);
    Ingredient carnitas = new Ingredient(
            "CARN", "Carnitas", IngredientType.PROTEIN);
    Ingredient tomatoes = new Ingredient(
            "TMTO", "Diced Tomatoes", IngredientType.VEGGIES);
    Ingredient lettuce = new Ingredient(
            "LETC", "Lettuce", IngredientType.VEGGIES);
    Ingredient cheddar = new Ingredient(
            "CHED", "Cheddar", IngredientType.CHEESE);
    Ingredient jack = new Ingredient(
            "JACK", "Monterrey Jack", IngredientType.CHEESE);
    Ingredient salsa = new Ingredient(
            "SLSA", "Salsa", IngredientType.SAUCE);
    Ingredient sourCream = new Ingredient(
            "SRCR", "Sour Cream", IngredientType.SAUCE);

    log.info("Preloading "+ repo.save(flourTortilla));
    log.info("Preloading "+ repo.save(cornTortilla));
    log.info("Preloading "+ repo.save(groundBeef));
    log.info("Preloading "+ repo.save(carnitas));
    log.info("Preloading "+ repo.save(tomatoes));
    log.info("Preloading "+ repo.save(lettuce));
    log.info("Preloading "+ repo.save(cheddar));
    log.info("Preloading "+ repo.save(jack));
    log.info("Preloading "+ repo.save(salsa));
    log.info("Preloading "+ repo.save(sourCream));

    Taco taco1 = new Taco();
    taco1.setName("Carnivore");
    taco1.setIngredients(Arrays.asList(
            flourTortilla, groundBeef, carnitas,
            sourCream, salsa, cheddar));
    tacoRepository.save(taco1);
    Taco taco2 = new Taco();
    taco2.setName("Bovine Bounty");
    taco2.setIngredients(Arrays.asList(
            cornTortilla, groundBeef, cheddar,
            jack, sourCream));
    tacoRepository.save(taco2);
    Taco taco3 = new Taco();
    taco3.setName("Veg-Out");
    taco3.setIngredients(Arrays.asList(
            flourTortilla, cornTortilla, tomatoes,
            lettuce, salsa));
    tacoRepository.save(taco3);

  }
}
