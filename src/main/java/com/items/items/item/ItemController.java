package com.items.items.item;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
// import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

// import java.util.List;

@Controller
public class ItemController {
    @Autowired
    @GetMapping("/items/list")
    public @ResponseBody List<?> listAutomoviles() {
        RestTemplate restTemplate = new RestTemplate();
        String fooResourceUrl = "http://localhost:8080/automoviles/lista";
        List<?> response = restTemplate.getForObject(fooResourceUrl, List.class);
        return response;
    }

    @GetMapping("/items/list/{amount}")
    public @ResponseBody List<?> listAutomovilesAmount(@PathVariable("amount") Integer amount) {
        RestTemplate restTemplate = new RestTemplate();
        String fooResourceUrl = "http://localhost:8080/automoviles/lista";
        List<?> response = restTemplate.getForObject(fooResourceUrl, List.class);
        // parse the previous response to a list of automoviles
        List<?> items = (List<?>) response;
        return items.subList(0, amount);
    }
    //  get by id
    @GetMapping("/items/{id}")
    public @ResponseBody String getAutomovil(@PathVariable("id") Integer id) {
        RestTemplate restTemplate = new RestTemplate();
        String fooResourceUrl = "http://localhost:8080/automoviles/"+id;
        String response = restTemplate.getForObject(fooResourceUrl, String.class);
        return response;
     }

     @GetMapping("/items/eliminar/{id}")
     public @ResponseBody String deleteAutomovil(@PathVariable("id") Integer id) {
        RestTemplate restTemplate = new RestTemplate();
        String fooResourceUrl = "http://localhost:8080/automoviles/eliminar/"+id;
        restTemplate.getForObject(fooResourceUrl, String.class);
        return "done";
     }
    
}
