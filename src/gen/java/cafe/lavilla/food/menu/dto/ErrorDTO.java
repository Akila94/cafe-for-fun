package cafe.lavilla.food.menu.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;


@ApiModel(description = "")
public class ErrorDTO {


    @NotNull
    private String error = null;

    private String errorMessage = null;

    private String errorCause = null;

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

    /**
     * Invalid input.
     **/
    @ApiModelProperty(required = true, value = "Invalid input.")
    @JsonProperty("errorMessage")
    public String getErrorMessage() {

        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {

        this.errorMessage = errorMessage;
    }

    /**
     * Invalid input.
     **/
    @ApiModelProperty(required = true, value = "Invalid input.")
    @JsonProperty("errorCause")
    public String getErrorCause() {

        return errorCause;
    }

    public void setErrorCause(String errorCause) {

        this.errorCause = errorCause;
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();
        sb.append("class ErrorDTO {\n");

        sb.append("  error: ").append(error).append("\n")
        .append("  errorMessage: ").append(errorMessage).append("\n")
        .append("  errorCause: ").append(errorCause).append("\n");
        sb.append("}\n");
        return sb.toString();
    }
}
