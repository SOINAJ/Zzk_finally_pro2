package com.example;


import org.junit.jupiter.api.Test;

import java.util.List;


class Point {
    double x;
}
class PointArray {
    List<Point> datas;
}
class MyStruct {
    List<PointArray> datas;
    double min = 5;
    double max = 10;
}

/**
 * Unit test for simple App.
 */
public class AppTest {

    @Test
    void test1(){

        MyStruct myStruct = new MyStruct();

        //由小到大
        for (int i=0;i<myStruct.datas.size()-1;i++){
            for (int j=0;j<myStruct.datas.size()-1-i;j++){
                PointArray pointArray1 = myStruct.datas.get(i);
                PointArray pointArray2 = myStruct.datas.get(j);
            }

        }

    }



}
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
//    public AppTest( String testName )
//    {
//        super( testName );
//    }
//
//    /**
//     * @return the suite of tests being tested
//     */
//    public static Test suite()
//    {
//        return new TestSuite( AppTest.class );
//    }
//
//    /**
//     * Rigourous Test :-)
//     */
//    public void testApp()
//    {
//        assertTrue( true );
//    }
//}
