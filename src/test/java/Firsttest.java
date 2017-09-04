import org.junit.*;

/**
 * Created by Administrator on 04/09/2017.
 */
public class Firsttest {


    @BeforeClass
    public static void beforeClass(){
        System.out.println("Before class");
    }
    @Before
    public void before(){
        System.out.println("Before");
    }
    @Test
    public void myTest(){
        System.out.println("Test");
    }
    @After
    public void myAfter(){
        System.out.println("After");
    }
    @AfterClass
    public static void myAfterClass(){
        System.out.println("After class");
    }
}
