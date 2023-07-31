package taco;

import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.web.client.TestRestTemplate;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import taco.domain.Ingredient;
//
//import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class TacoCloudApplicationTests {
//
//
//	private final TestRestTemplate testRestTemplate;
//
//	@Autowired
//	TacoCloudApplicationTests(TestRestTemplate testRestTemplate){
//		this.testRestTemplate = testRestTemplate;
//	}
//
//	@Test
//	void shouldReturnIngredientWhenDataIsSaved(){
//		ResponseEntity<String> response = testRestTemplate
//						.getForEntity("/api/FLTO", String.class);
//
//		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
//
//		DocumentContext documentContext = JsonPath.parse(response.getBody());
//		String id = documentContext.read("$.id");
//
//		assertThat(id).isNotNull();
//		assertThat(id).isEqualTo("FLTO");
//	}

//	@Test
//	void shouldNotReturnACashCardWithAnUnknownId() {
//		ResponseEntity<String> response = testRestTemplate.getForEntity("/api/1000", String.class);
//
//		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
//		assertThat(response.getBody()).isBlank();
//	}

}
