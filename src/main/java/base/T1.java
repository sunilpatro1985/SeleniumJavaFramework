package base;

import org.slf4j.Logger;
import java.lang.invoke.MethodHandles;
import org.slf4j.LoggerFactory;

public class T1 {

    public static void main(String []args) {
        final Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
        //final Logger logger = LoggerFactory.getLogger(T1.class);

        logger.info("this is info message");
        logger.error("this is error message");
        logger.info("this is info");
    }
}
