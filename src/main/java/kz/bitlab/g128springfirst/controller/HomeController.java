package kz.bitlab.g128springfirst.controller;

import kz.bitlab.g128springfirst.entity.Country;
import kz.bitlab.g128springfirst.entity.Developer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

  @GetMapping("/") // @WebServlet(value = "/") + doGet()
  public String homePage() {
    Country country = new Country(1L, "Kazakhstan", "KAZ");
    Developer developer = Developer.builder()
        .id(1L)
        .name("Jack")
        .birthCounty(country)
        .email("jack@gmail.com")
        .build();

    System.out.println(developer.getEmail());
    return "home"; // req.getRequestDispatcher("/home.jsp").forward(req, resp)
  }

  @GetMapping("/second") // @WebServlet(value = "/second") + doGet()
  public String secondPage() {
    return "second"; // req.getRequestDispatcher("/second.jsp").forward(req, resp)
  }
}
