package kz.bitlab.g128springfirst.controller;

import java.util.ArrayList;
import java.util.List;
import kz.bitlab.g128springfirst.entity.Country;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

  @GetMapping("/")
  public String homePage(Model model) {
    List<Country> countries = new ArrayList<>();
    countries.add(new Country(1L, "Kazakhstan", "KAZ", "Eurasia", "Asia"));
    countries.add(new Country(2L, "United states of America", "USA", "North America", "America"));
    countries.add(new Country(3L, "Canada", "CND", "North America", "America"));
    countries.add(new Country(4L, "Italy", "ITL", "Eurasia", "Europe"));
    countries.add(new Country(5L, "France", "FNC", "Eurasia", "Europe"));
    countries.add(new Country(6L, "Germany", "GD", "Eurasia", "Europe"));
    model.addAttribute("strany", countries);
    return "home";
  }

  @GetMapping("/second")
  public String secondPage() {
    return "second";
  }
}
