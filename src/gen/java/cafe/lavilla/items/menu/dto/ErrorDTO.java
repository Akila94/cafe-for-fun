package cafe.lavilla.items.menu.dto;


import io.swagger.annotations.*;
import com.fasterxml.jackson.annotation.*;

import javax.validation.constraints.NotNull;





@ApiModel(description = "")
public class ErrorDTO  {
  
  
  
  private String errorCode = null;
  
  
  private String errorCause = null;
  
  
  private String errorMessage = null;

  
  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("errorCode")
  public String getErrorCode() {
    return errorCode;
  }
  public void setErrorCode(String errorCode) {
    this.errorCode = errorCode;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("errorCause")
  public String getErrorCause() {
    return errorCause;
  }
  public void setErrorCause(String errorCause) {
    this.errorCause = errorCause;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("errorMessage")
  public String getErrorMessage() {
    return errorMessage;
  }
  public void setErrorMessage(String errorMessage) {
    this.errorMessage = errorMessage;
  }

  

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class ErrorDTO {\n");
    
    sb.append("  errorCode: ").append(errorCode).append("\n");
    sb.append("  errorCause: ").append(errorCause).append("\n");
    sb.append("  errorMessage: ").append(errorMessage).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}
