package taco.bootstrap;

import org.springframework.batch.item.file.FlatFileItemReader;
import taco.domain.Ingredient;

public class IngredientReader extends FlatFileItemReader<Ingredient> {
}
