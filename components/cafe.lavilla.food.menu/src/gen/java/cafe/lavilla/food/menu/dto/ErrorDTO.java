package cafe.lavilla.food.menu.dto;


import io.swagger.annotations.*;
import com.fasterxml.jackson.annotation.*;

import javax.validation.constraints.NotNull;





@ApiModel(description = "")
public class ErrorDTO  {
  
  
  @NotNull
  private String error = null;

  
  /**
   * Invalid input.
   **/
  @ApiModelProperty(required = true, value = "Invalid input.")
  @JsonProperty("error")
  public String getError() {
    return error;
  }
  public void setError(String error) {
    this.error = error;
  }

  

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class ErrorDTO {\n");
    
    sb.append("  error: ").append(error).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}
