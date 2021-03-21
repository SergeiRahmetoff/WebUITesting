
package TriangleTest;

import ru.rahmetoff.areaCalc.Triangle;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TriangleTest {

    static final Logger log = LoggerFactory.getLogger(TriangleTest.class);

    int a = (int)(Math.random() * 100);
    int b = (int)(Math.random() * 100);
    int c = calcC(a, b);

    int calcC (int a, int b){
        int c = (int)(Math.random() * 100);
        while ((a+b)<=c || (b+c)<=a || (c+a)<=b){
            c = (int)(Math.random() * 100);
        }
        return c;
    }



    Triangle t = new Triangle(a, b, c);
    double act_result = t.triangleArea();



    @Test
    public void areaCalcTest(){
        log.info("\t\t\tSTART WORK TEST");
        double p = (double)(a + b + c)/2;
        double exp_result = Math.sqrt(p*(p - a)*(p - b)*(p - c));
        Assertions.assertEquals(exp_result, act_result);
        log.info("\t\t\tEND WORK TEST");
    }

    @Test
    public void areaCalcNotNullTest(){
        log.info("\t\t\tSTART WORK TEST");
        Assertions.assertNotNull(act_result);

        log.info("\t\t\tEND WORK TEST");
    }
}
//    Настроить генерацию отчета и - по желанию - логирование.

