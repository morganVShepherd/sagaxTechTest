package hire.morgan.json;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "minStrides",
        "message"
})
public class ResponseObj {

    @JsonProperty("minStrides")
    private int minStrides = 0;
    @JsonProperty("message")
    private String message;

    @JsonProperty("minStrides")
    public int getMinStrides() {
        return minStrides;
    }

    @JsonProperty("minStrides")
    public void setMinStrides(int minStrides) {
        this.minStrides = minStrides;
    }

    @JsonProperty("message")
    public String getMessage() {
        return message;
    }

    @JsonProperty("message")
    public void setMessage(String message) {
        this.message = message;
    }

}
