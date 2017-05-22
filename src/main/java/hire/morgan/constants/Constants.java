package hire.morgan.constants;

public class Constants {
    // Constants for Calculations
    public static int STRIDES_FOR_LANDING = 2;
    public static int MAX_FLIGHTS = 30;
    public static int MAX_STEPS = 20;
    public static int MAX_STEPS_PER_STRIDE =4;

    //Constants for Errors
    public static String MAX_FLIGHTS_ERROR = "There Cannot be more than "+MAX_FLIGHTS+" flights";
    public static String MAX_STEPS_ERROR = "There Cannot be more than "+MAX_STEPS+" steps per flight";
    public static String MAX_STEPS_PER_STRIDE_ERROR = "No Pogo Stick's on the stairwell";//there are too many strides per step


    //Constant for API
    /*
    Normally this would be a little better structured as a web page for a full on API
     */
    public static String API = "<p>Version 1.1</p>\n" +
            "<p>There are currently 2 methods:</p>\n" +
            "<p><strong>/api</strong></p>\n" +
            "<p>Requires: nothing<br /> Returns this document</p>\n" +
            "<p><strong>/strideCount( json requestObj)</strong></p>\n" +
            "<p>Requires:</p>\n" +
            "<p>json requestObj:<br /> \n" +
            "\t{<br /> \n" +
            "\t\"flights\":[4,9,8,11,7,22,14], //an int array of flights with steps per flight\n" +
            "\t<br /> \n" +
            "\t\"stepsPerStride\": \"2\" // an int of amount of steps a user can use per stride\n" +
            "\t<br /> \n" +
            "\t}\n" +
            "</p>\n" +
            "<p>Returns: 7 // minimum number of strides</p>\n" +
            "<p>\n" +
            "\t<br /> \n" +
            "\t<strong>Custom Errors:</strong>\n" +
            "\t<br /> Returns:\n" +
            "\t<br />{\n" +
            "\t\t<br /> \"minStrides\": 0,\n" +
            "\t\t<br /> \"message\": \"There Cannot be more than 20 steps per flight\"\n" +
            "\t<br /> }\n" +
            "\t<br /> then one of your flights of steps has too many steps.</p>\n" +
            "<p>\n" +
            "Returns:\n" +
            "\t<br /> {\n" +
            "\t\t<br />  \"minStrides\": 0,\n" +
            "\t\t<br />  \"message\": \"There Cannot be more than 30 flights\"\n" +
            "\t<br /> }\n" +
            "\t<br /> Then you have too many flights of steps\n" +
            "</p>"+
            "Returns:\n" +
            "\t<br /> {\n" +
            "\t\t<br />  \"minStrides\": 0,\n" +
            "\t\t<br />  \"message\": \"No Pogo Stick's on the stairwell\"\n" +
            "\t<br /> }\n" +
            "\t<br /> Then you are taking too many steps per \"stride\"\n" +
            "</p>";;

}
