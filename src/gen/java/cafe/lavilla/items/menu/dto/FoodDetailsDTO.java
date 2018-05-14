package cafe.lavilla.items.menu.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


@ApiModel(description = "")
public class FoodDetailsDTO {

  private Integer categoryId = null;

  private String category = null;

  private Integer itemId = null;


  private String title = null;


  private String description = null;


  private Float price = null;


  private String imageSource = null;

  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("categoryId")
  public Integer getCategoryId() {
    return categoryId;
  }

  public void setCategoryId(Integer categoryId) {
    this.categoryId = categoryId;
  }


  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("category")
  public String getCategory() {
    return category;
  }

  public void setCategory(String category) {
    this.category = category;
  }


  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("itemId")
  public Integer getItemId() {
    return itemId;
  }

  public void setItemId(Integer itemId) {
    this.itemId = itemId;
  }


  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("title")
  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }


  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("description")
  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }


  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("price")
  public Float getPrice() {
    return price;
  }

  public void setPrice(float price) {
    this.price = price;
  }


  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("imageSource")
  public String getImageSource() {
    return imageSource;
  }

  public void setImageSource(String imageSource) {
    this.imageSource = imageSource;
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class FoodDetailsDTO {\n");

    sb.append("  categoryId: ").append(categoryId).append("\n");
    sb.append("  category: ").append(category).append("\n");
    sb.append("  itemId: ").append(itemId).append("\n");
    sb.append("  title: ").append(title).append("\n");
    sb.append("  description: ").append(description).append("\n");
    sb.append("  price: ").append(price).append("\n");
    sb.append("  imageSource: ").append(imageSource).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}