package kz.bitlab.g128springfirst.controller;

import java.util.List;
import kz.bitlab.g128springfirst.entity.Country;
import kz.bitlab.g128springfirst.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

  @Autowired
  private CountryService countryService;

  @GetMapping("/")
  public String homePage(Model model) {
    List<Country> countries = countryService.getAll();
    model.addAttribute("strany", countries);
    return "home";
  }

  @GetMapping("/country/{id}") // http://localhost:8085/country/2
  public String details(@PathVariable Long id, Model model) {
    Country country = countryService.getById(id);
    model.addAttribute("strana", country);
    return "countryDetails";
  }

  @PostMapping("/country/create")
  public String create(@RequestParam String name,
      @RequestParam String code,
      @RequestParam String mainland,
      @RequestParam String worldPart) {
    Country country = Country.builder()
        .name(name)
        .code(code)
        .mainland(mainland)
        .worldPart(worldPart)
        .build();
    countryService.create(country);
    return "redirect:/";
  }

  @GetMapping("/second")
  public String secondPage() {
    return "second";
  }
}
