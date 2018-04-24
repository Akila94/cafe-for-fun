package cafe.lavilla.food.menu.dto;

import cafe.lavilla.food.menu.dto.FoodDetailsDTO;
import java.util.ArrayList;
import java.util.List;

import io.swagger.annotations.*;
import com.fasterxml.jackson.annotation.*;

import javax.validation.constraints.NotNull;





@ApiModel(description = "")
public class CategoryDTO  {
  
  
  
  private List<FoodDetailsDTO> salad = new ArrayList<FoodDetailsDTO>();
  
  
  private List<FoodDetailsDTO> breakfast = new ArrayList<FoodDetailsDTO>();
  
  
  private List<FoodDetailsDTO> hotDrinks = new ArrayList<FoodDetailsDTO>();
  
  
  private List<FoodDetailsDTO> desserts = new ArrayList<FoodDetailsDTO>();
  
  
  private List<FoodDetailsDTO> frenchToast = new ArrayList<FoodDetailsDTO>();
  
  
  private List<FoodDetailsDTO> mainCource = new ArrayList<FoodDetailsDTO>();
  
  
  private List<FoodDetailsDTO> pancake = new ArrayList<FoodDetailsDTO>();
  
  
  private List<FoodDetailsDTO> pastas = new ArrayList<FoodDetailsDTO>();
  
  
  private List<FoodDetailsDTO> quenchers = new ArrayList<FoodDetailsDTO>();
  
  
  private List<FoodDetailsDTO> starters = new ArrayList<FoodDetailsDTO>();
  
  
  private List<FoodDetailsDTO> waffles = new ArrayList<FoodDetailsDTO>();

  
  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("salad")
  public List<FoodDetailsDTO> getSalad() {
    return salad;
  }
  public void setSalad(List<FoodDetailsDTO> salad) {
    this.salad = salad;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("breakfast")
  public List<FoodDetailsDTO> getBreakfast() {
    return breakfast;
  }
  public void setBreakfast(List<FoodDetailsDTO> breakfast) {
    this.breakfast = breakfast;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("hotDrinks")
  public List<FoodDetailsDTO> getHotDrinks() {
    return hotDrinks;
  }
  public void setHotDrinks(List<FoodDetailsDTO> hotDrinks) {
    this.hotDrinks = hotDrinks;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("desserts")
  public List<FoodDetailsDTO> getDesserts() {
    return desserts;
  }
  public void setDesserts(List<FoodDetailsDTO> desserts) {
    this.desserts = desserts;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("frenchToast")
  public List<FoodDetailsDTO> getFrenchToast() {
    return frenchToast;
  }
  public void setFrenchToast(List<FoodDetailsDTO> frenchToast) {
    this.frenchToast = frenchToast;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("mainCource")
  public List<FoodDetailsDTO> getMainCource() {
    return mainCource;
  }
  public void setMainCource(List<FoodDetailsDTO> mainCource) {
    this.mainCource = mainCource;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("pancake")
  public List<FoodDetailsDTO> getPancake() {
    return pancake;
  }
  public void setPancake(List<FoodDetailsDTO> pancake) {
    this.pancake = pancake;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("pastas")
  public List<FoodDetailsDTO> getPastas() {
    return pastas;
  }
  public void setPastas(List<FoodDetailsDTO> pastas) {
    this.pastas = pastas;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("quenchers")
  public List<FoodDetailsDTO> getQuenchers() {
    return quenchers;
  }
  public void setQuenchers(List<FoodDetailsDTO> quenchers) {
    this.quenchers = quenchers;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("starters")
  public List<FoodDetailsDTO> getStarters() {
    return starters;
  }
  public void setStarters(List<FoodDetailsDTO> starters) {
    this.starters = starters;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("waffles")
  public List<FoodDetailsDTO> getWaffles() {
    return waffles;
  }
  public void setWaffles(List<FoodDetailsDTO> waffles) {
    this.waffles = waffles;
  }

  

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class CategoryDTO {\n");
    
    sb.append("  salad: ").append(salad).append("\n");
    sb.append("  breakfast: ").append(breakfast).append("\n");
    sb.append("  hotDrinks: ").append(hotDrinks).append("\n");
    sb.append("  desserts: ").append(desserts).append("\n");
    sb.append("  frenchToast: ").append(frenchToast).append("\n");
    sb.append("  mainCource: ").append(mainCource).append("\n");
    sb.append("  pancake: ").append(pancake).append("\n");
    sb.append("  pastas: ").append(pastas).append("\n");
    sb.append("  quenchers: ").append(quenchers).append("\n");
    sb.append("  starters: ").append(starters).append("\n");
    sb.append("  waffles: ").append(waffles).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}
