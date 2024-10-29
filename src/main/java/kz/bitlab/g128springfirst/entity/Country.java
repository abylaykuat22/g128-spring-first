package kz.bitlab.g128springfirst.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Country {

  private Long id;
  private String name;
  private String code;
  private String mainland;
  private String worldPart;
}
