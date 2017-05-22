package hire.morgan.service;

import hire.morgan.json.ResponseObj;

public interface LogicService {
    /**
     *
     * @param flightsOfStep
     * @param stride
     * @return
     * @throws Exception
     */
    public ResponseObj calculateStrides(int[] flightsOfStep, int stride)throws Exception;
}
