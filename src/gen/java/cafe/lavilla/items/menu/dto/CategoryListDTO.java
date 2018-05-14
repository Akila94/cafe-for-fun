package cafe.lavilla.items.menu.dto;

import cafe.lavilla.items.menu.dto.CategoryDetailsDTO;
import java.util.ArrayList;
import java.util.List;

import io.swagger.annotations.*;
import com.fasterxml.jackson.annotation.*;

import javax.validation.constraints.NotNull;





@ApiModel(description = "")
public class CategoryListDTO  {
  
  
  
  private List<CategoryDetailsDTO> categoryList = new ArrayList<CategoryDetailsDTO>();

  
  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("categoryList")
  public List<CategoryDetailsDTO> getCategoryList() {
    return categoryList;
  }
  public void setCategoryList(List<CategoryDetailsDTO> categoryList) {
    this.categoryList = categoryList;
  }

  

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class CategoryListDTO {\n");
    
    sb.append("  categoryList: ").append(categoryList).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}
