package taco.controller.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import taco.domain.Ingredient;
import taco.domain.IngredientType;
import taco.domain.Taco;
import taco.domain.TacoOrder;
import taco.repository.IngredientRepository;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/design")
@SessionAttributes("tacoOrder")
public class DesignTacoController {

  private final IngredientRepository ingredientRepository;

  public DesignTacoController(IngredientRepository ingredientRepository){
    this.ingredientRepository = ingredientRepository;
  }

  @ModelAttribute
  public void addIngredientsToModel(Model model){

    List<Ingredient> ingredients = ingredientRepository.findAll();

    for(IngredientType Type: IngredientType.values()) {
      System.out.println(Type.toString().toLowerCase());
      model.addAttribute(Type.toString().toLowerCase(), filterByIngredientType(ingredients,Type));
    }
  }


  @ModelAttribute("tacoOrder")
  public TacoOrder tacoOrder(){
    return new TacoOrder();
  }

  @ModelAttribute(name = "taco")
  public Taco taco(){
   return new Taco();
  }

  @GetMapping
  public String showDesignForm(){
    return "design";
  }

  private List<Ingredient> filterByIngredientType(List<Ingredient> ingredients,
                                                  IngredientType type){
    return ingredients
            .stream()
            .filter(ingredient -> ingredient.getType()==type)
            .collect(Collectors.toList());


  }
  
  @PostMapping
  private String save(@Valid Taco taco, Errors errors, @ModelAttribute TacoOrder tacoOrder){

//    if(errors.hasErrors()){
//
//      System.out.println("tacox = " + taco);
//      return "design";
//    }
    System.out.println("taco = " + taco);
    tacoOrder.addOrder(taco);
    return "redirect:/orders/current";
  }
}
