import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class PlaneTest {

    Plane plane;

    @Before
    public void before(){
        plane = new Plane(PlaneType.CODECLAN300);
    }

    @Test
    public void planeHasPlaneType(){
        //Given we have a plane
        assertNotNull(plane);
        //When
        //Then plane type should be CODECLAN300
        assertEquals(PlaneType.CODECLAN300, plane.getPlaneType());
        //AND total planeWeight should be 300
        assertEquals(300, plane.getPlaneWeight());
        //AND total capacity should be 5
        assertEquals(5, plane.getTotalCapacity());

    }

}
