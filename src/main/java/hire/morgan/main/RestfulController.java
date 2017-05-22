package hire.morgan.main;

import hire.morgan.constants.Constants;
import hire.morgan.json.ReceivedObj;
import hire.morgan.json.ResponseObj;
import hire.morgan.service.LogicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestfulController {

    @Autowired
    LogicService logicService;

    @RequestMapping(value = "/strideCount", method = RequestMethod.POST, produces = "application/json", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> strideCount(@RequestBody ReceivedObj json) {
        ResponseObj responseObj = new ResponseObj();
        try {
            responseObj = logicService.calculateStrides(json.getFlights(), json.getStepsPerStride());
        }
        catch(Exception e){
            responseObj.setMessage(e.getMessage());
            return new ResponseEntity<>(responseObj, HttpStatus.BAD_REQUEST);
        }
        if(responseObj.getMinStrides()> 0) {
            return new ResponseEntity<>(responseObj.getMinStrides(), HttpStatus.OK);
        }
        return new ResponseEntity<>(responseObj, HttpStatus.BAD_REQUEST);
    }

    @RequestMapping(value = "/api", method = RequestMethod.GET)
    @ResponseBody
    public String api() {
        return Constants.API;
    }

}