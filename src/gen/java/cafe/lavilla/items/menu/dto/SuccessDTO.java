package cafe.lavilla.items.menu.dto;


import io.swagger.annotations.*;
import com.fasterxml.jackson.annotation.*;

import javax.validation.constraints.NotNull;





@ApiModel(description = "")
public class SuccessDTO  {
  
  
  
  private String succassMessage = null;
  
  
  private Integer successCode = null;

  
  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("succassMessage")
  public String getSuccassMessage() {
    return succassMessage;
  }
  public void setSuccassMessage(String succassMessage) {
    this.succassMessage = succassMessage;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("successCode")
  public Integer getSuccessCode() {
    return successCode;
  }
  public void setSuccessCode(Integer successCode) {
    this.successCode = successCode;
  }

  

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class SuccessDTO {\n");
    
    sb.append("  succassMessage: ").append(succassMessage).append("\n");
    sb.append("  successCode: ").append(successCode).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}
