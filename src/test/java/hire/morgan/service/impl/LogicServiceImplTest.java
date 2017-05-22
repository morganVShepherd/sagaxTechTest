package hire.morgan.service.impl;

import hire.morgan.constants.Constants;
import hire.morgan.json.ResponseObj;
import hire.morgan.main.Driver;
import hire.morgan.service.LogicService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = Driver.class)
public class LogicServiceImplTest {
    @Autowired
    LogicService logicService;
    @Before
    public void setUp() throws Exception {
    }

    /**
     * test to check the First Example in Document
     * @throws Exception
     */
    @Test
    public void example1() throws Exception {
        int[] flights = new int[] {17};
        int stepsPerStride = 3;
        ResponseObj responseObj = logicService.calculateStrides(flights, stepsPerStride);
        Assert.assertEquals( 6,responseObj.getMinStrides());

    }

    /**
     * test to check the Second Example in Document
     * @throws Exception
     */
    @Test
    public void example2() throws Exception {
        int[] flights = new int[] {17,17};
        int stepsPerStride = 3;
        ResponseObj responseObj = logicService.calculateStrides(flights, stepsPerStride);
        Assert.assertEquals( 14,responseObj.getMinStrides());

    }

    /**
     * test to check the Third Example in Document
     * @throws Exception
     */
    @Test
    public void example3() throws Exception {
        int[] flights = new int[] {4,9,8,11,7,20,14};
        int stepsPerStride = 2;
        ResponseObj responseObj = logicService.calculateStrides(flights, stepsPerStride);
        Assert.assertEquals( 50, responseObj.getMinStrides());

    }


    /**
     * test to check the Own Example with large amount of data
     * @throws Exception
     */
    @Test
    public void largeFlight() throws Exception {
        int[] flights = new int[] {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,19,18,17,16,15,14,13,12,11};
        int stepsPerStride = 3;
        ResponseObj responseObj = logicService.calculateStrides(flights, stepsPerStride);
        Assert.assertEquals( 181, responseObj.getMinStrides());

    }

    /**
     * test to check when the stride length Bigger than flight of steps
     * @throws Exception
     */
    @Test
    public void strideMoreThanSteps() throws Exception {
        int[] flights = new int[] {1,1};
        int stepsPerStride = 4;
        ResponseObj responseObj = logicService.calculateStrides(flights, stepsPerStride);
        Assert.assertEquals( 4, responseObj.getMinStrides());

    }

    /**
     * test to check when that error is thrown if too many flights
     * @throws Exception
     */
    @Test
    public void tooManyFlights() {
        int[] flights = new int[Constants.MAX_FLIGHTS+1];
        int stepsPerStride = 2;
        try {
            ResponseObj responseObj = logicService.calculateStrides(flights, stepsPerStride);
            Assert.assertEquals(Constants.MAX_FLIGHTS_ERROR, responseObj.getMessage());
        }
        catch(Exception e){
           e.printStackTrace();
        }
    }

    /**
     * test to check when that error is thrown if too many Steps in flight
     * @throws Exception
     */
    @Test
    public void tooManySteps(){
        int[] flights = new int[]{20,Constants.MAX_STEPS+1};
        int stepsPerStride = 2;
        try {
            ResponseObj responseObj = logicService.calculateStrides(flights, stepsPerStride);
            Assert.assertEquals(Constants.MAX_STEPS_ERROR, responseObj.getMessage());
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    /**
     * test to check when that error is thrown if too many Steps in flight
     * @throws Exception
     */
    @Test
    public void pogoTest(){
        int[] flights = new int[]{20,5,4};
        int stepsPerStride = Constants.MAX_STEPS_PER_STRIDE+1;
        try {
            ResponseObj responseObj = logicService.calculateStrides(flights, stepsPerStride);
            Assert.assertEquals(Constants.MAX_STEPS_PER_STRIDE_ERROR, responseObj.getMessage());
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
