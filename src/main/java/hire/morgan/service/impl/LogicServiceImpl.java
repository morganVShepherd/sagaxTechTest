package hire.morgan.service.impl;

import hire.morgan.constants.Constants;
import hire.morgan.json.ResponseObj;
import hire.morgan.service.LogicService;

public class LogicServiceImpl implements LogicService {

    @Override
    public ResponseObj calculateStrides(int[] flightsOfStep, int stride) throws Exception {

        ResponseObj responseObj = new ResponseObj();
        int stridesTaken = 0;
        if (ErrorChecks.checkStrideLength(stride)) {
            responseObj.setMessage(Constants.MAX_STEPS_PER_STRIDE_ERROR);
            return responseObj;
        }

        if (ErrorChecks.checkFlights(flightsOfStep.length)) {
           responseObj.setMessage(Constants.MAX_FLIGHTS_ERROR);
           return responseObj;
        }
        for (int stepsPerFlight : flightsOfStep) {
            if (ErrorChecks.checkSteps(stepsPerFlight)) {
                responseObj.setMessage(Constants.MAX_STEPS_ERROR);
                return responseObj;
            }
            if (stepsPerFlight % stride == 0) {
                stridesTaken += stepsPerFlight / stride;
            } else {
                int thatExtraLittleStride = stepsPerFlight % stride;
                stridesTaken += ((stepsPerFlight - thatExtraLittleStride) / stride) + 1;
            }
            //Can't forget to add the landing
            stridesTaken += Constants.STRIDES_FOR_LANDING;
        }

        //Also can't forget that there is no landing at the top
        stridesTaken -= Constants.STRIDES_FOR_LANDING;

        responseObj.setMessage("Calculated Successfully");
        responseObj.setMinStrides(stridesTaken);
        return responseObj;
    }

    private static class ErrorChecks{

        private  static boolean checkFlights(int flightsOfStep){
            if(flightsOfStep > Constants.MAX_FLIGHTS){
                return true;
            }
            return false;
        }
        private static boolean checkSteps(int stepsPerFlight){
            if(stepsPerFlight > Constants.MAX_STEPS){
                return true;
            }
            return false;
        }
        private static boolean checkStrideLength(int stepsPerStride){
            if(stepsPerStride > Constants.MAX_STEPS_PER_STRIDE){
                return true;
            }
            return false;
        }
    }

}

