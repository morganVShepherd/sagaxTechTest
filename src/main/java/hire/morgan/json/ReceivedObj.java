package hire.morgan.json;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "flights",
        "stepsPerStride"
})
public class ReceivedObj {

    @JsonProperty("flights")
    private int[] flights = null;
    @JsonProperty("stepsPerStride")
    private int stepsPerStride;

    @JsonProperty("flights")
    public int[] getFlights() {
        return flights;
    }

    @JsonProperty("flights")
    public void setFlights(int[] flights) {
        this.flights = flights;
    }

    @JsonProperty("stepsPerStride")
    public int getStepsPerStride() {
        return stepsPerStride;
    }

    @JsonProperty("stepsPerStride")
    public void setStepsPerStride(int stepsPerStride) {
        this.stepsPerStride = stepsPerStride;
    }

}