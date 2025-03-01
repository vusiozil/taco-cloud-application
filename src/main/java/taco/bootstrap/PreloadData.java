package taco.bootstrap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
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

  //  final PasswordEncoder encoder;

  final TacoRepository tacoRepository;

  public PreloadData(IngredientRepository repo, UserRepository userRepository,
                     TacoRepository tacoRepository){
    this.repo = repo;
    this.userRepository = userRepository;
    this.tacoRepository = tacoRepository;
  }

  @Override
  public void run(String... args){

    Ingredient flourTortilla = new Ingredient(
            "FLTO", "Flour Tortilla", IngredientType.WRAP,0.50);

    Ingredient cornTortilla = new Ingredient(
            "COTO", "Corn Tortilla", IngredientType.WRAP,1.00);

    Ingredient groundBeef = new Ingredient(
            "GRBF", "Ground Beef", IngredientType.PROTEIN,5.00);

    Ingredient carnitas = new Ingredient(
            "CARN", "Carnitas", IngredientType.PROTEIN,7.50);

    Ingredient tomatoes = new Ingredient(
            "TMTO", "Diced Tomatoes", IngredientType.VEGGIES,3.00);

    Ingredient lettuce = new Ingredient(
            "LETC", "Lettuce", IngredientType.VEGGIES,1.50);

    Ingredient cheddar = new Ingredient(
            "CHED", "Cheddar", IngredientType.CHEESE,2.00);

    Ingredient jack = new Ingredient(
            "JACK", "Monterrey Jack", IngredientType.CHEESE,1.50);

    Ingredient mozza = new Ingredient(
            "MOZZA", "Mozzarella", IngredientType.CHEESE,1.50);

    Ingredient salsa = new Ingredient(
            "SLSA", "Salsa", IngredientType.SAUCE,0.02);

    Ingredient sourCream = new Ingredient(
            "SRCR", "Sour Cream", IngredientType.SAUCE,00);

    log.debug("Preloading {}", repo.save(flourTortilla));
    log.debug("Preloading {}", repo.save(cornTortilla));
    log.debug("Preloading {}", repo.save(groundBeef));
    log.debug("Preloading {}", repo.save(carnitas));
    log.debug("Preloading {}", repo.save(tomatoes));
    log.debug("Preloading {}", repo.save(lettuce));
    log.debug("Preloading {}", repo.save(cheddar));
    log.debug("Preloading {}", repo.save(jack));
    log.debug("Preloading {}", repo.save(mozza));
    log.debug("Preloading {}", repo.save(salsa));
    log.debug("Preloading {}", repo.save(sourCream));

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
    taco3.setIngredients(Arrays.asList(flourTortilla, cornTortilla, tomatoes,
            lettuce, salsa));
    tacoRepository.save(taco3);

  }
}
