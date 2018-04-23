package cafe.lavilla.food.menu.dto;

import cafe.lavilla.food.menu.dto.FoodDetailsDTO;
import java.util.ArrayList;
import java.util.List;

import io.swagger.annotations.*;
import com.fasterxml.jackson.annotation.*;

import javax.validation.constraints.NotNull;





@ApiModel(description = "")
public class CategoryDTO  {
  
  
  
  private List<FoodDetailsDTO> salads = new ArrayList<FoodDetailsDTO>();
  
  
  private List<FoodDetailsDTO> breakfast = new ArrayList<FoodDetailsDTO>();
  
  
  private List<FoodDetailsDTO> cofeeAndTea = new ArrayList<FoodDetailsDTO>();
  
  
  private List<FoodDetailsDTO> desserts = new ArrayList<FoodDetailsDTO>();
  
  
  private List<FoodDetailsDTO> frenchToast = new ArrayList<FoodDetailsDTO>();
  
  
  private List<FoodDetailsDTO> mainCource = new ArrayList<FoodDetailsDTO>();
  
  
  private List<FoodDetailsDTO> panCake = new ArrayList<FoodDetailsDTO>();
  
  
  private List<FoodDetailsDTO> pasta = new ArrayList<FoodDetailsDTO>();
  
  
  private List<FoodDetailsDTO> quenchers = new ArrayList<FoodDetailsDTO>();
  
  
  private List<FoodDetailsDTO> starters = new ArrayList<FoodDetailsDTO>();
  
  
  private List<FoodDetailsDTO> waffles = new ArrayList<FoodDetailsDTO>();

  
  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("salads")
  public List<FoodDetailsDTO> getSalads() {
    return salads;
  }
  public void setSalads(List<FoodDetailsDTO> salads) {
    this.salads = salads;
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
  @JsonProperty("cofeeAndTea")
  public List<FoodDetailsDTO> getCofeeAndTea() {
    return cofeeAndTea;
  }
  public void setCofeeAndTea(List<FoodDetailsDTO> cofeeAndTea) {
    this.cofeeAndTea = cofeeAndTea;
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
  @JsonProperty("panCake")
  public List<FoodDetailsDTO> getPanCake() {
    return panCake;
  }
  public void setPanCake(List<FoodDetailsDTO> panCake) {
    this.panCake = panCake;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("pasta")
  public List<FoodDetailsDTO> getPasta() {
    return pasta;
  }
  public void setPasta(List<FoodDetailsDTO> pasta) {
    this.pasta = pasta;
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
    
    sb.append("  salads: ").append(salads).append("\n");
    sb.append("  breakfast: ").append(breakfast).append("\n");
    sb.append("  cofeeAndTea: ").append(cofeeAndTea).append("\n");
    sb.append("  desserts: ").append(desserts).append("\n");
    sb.append("  frenchToast: ").append(frenchToast).append("\n");
    sb.append("  mainCource: ").append(mainCource).append("\n");
    sb.append("  panCake: ").append(panCake).append("\n");
    sb.append("  pasta: ").append(pasta).append("\n");
    sb.append("  quenchers: ").append(quenchers).append("\n");
    sb.append("  starters: ").append(starters).append("\n");
    sb.append("  waffles: ").append(waffles).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}
