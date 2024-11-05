package kz.bitlab.g128springfirst.service;

import java.util.ArrayList;
import java.util.List;
import kz.bitlab.g128springfirst.entity.Country;
import org.springframework.stereotype.Service;

@Service
public class CountryService {

  private List<Country> countries = new ArrayList<>();

  private Long id = 7L;
  {
    countries.add(new Country(1L, "Kazakhstan", "KAZ", "Eurasia", "Asia"));
    countries.add(new Country(2L, "United states of America", "USA", "North America", "America"));
    countries.add(new Country(3L, "Canada", "CND", "North America", "America"));
    countries.add(new Country(4L, "Italy", "ITL", "Eurasia", "Europe"));
    countries.add(new Country(5L, "France", "FNC", "Eurasia", "Europe"));
    countries.add(new Country(6L, "Germany", "GD", "Eurasia", "Europe"));
  }

  public void create(Country newCountry) {
    if (newCountry == null) {
      return;
    }
    newCountry.setId(id);

    Country country = getByCode(newCountry.getCode());
    if (country == null) {
      countries.add(newCountry);
    }
    id++;
  }

  public List<Country> getAll() {
    return countries;
  }

  public Country getById(Long id) {
    return countries.stream()
        .filter(country -> id.equals(country.getId()))
        .findAny()
        .orElse(null);
  }

  public Country getByCode(String code) {
    return countries.stream()
        .filter(country -> code.equals(country.getCode()))
        .findAny()
        .orElse(null);
  }

  public void edit(Country country) {
    // TODO: обновить страну
  }

  public void deleteById(Long id) {
    Country country = getById(id);
    countries.remove(country);
  }
}
