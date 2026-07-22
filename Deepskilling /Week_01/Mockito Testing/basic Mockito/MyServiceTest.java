import org.junit.jupiter.api.Test;
import org.mockito.InOrder;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class MyServiceTest {

    // Exercise 1
    @Test
    void testExternalApi() {

        ExternalApi mockApi = mock(ExternalApi.class);

        when(mockApi.getData()).thenReturn("Mock Data");

        MyService service = new MyService(mockApi);

        assertEquals("Mock Data", service.fetchData());
    }

    // Exercise 2
    @Test
    void verifyMethodCall() {

        ExternalApi mockApi = mock(ExternalApi.class);

        when(mockApi.getData()).thenReturn("Mock Data");

        MyService service = new MyService(mockApi);

        service.fetchData();

        verify(mockApi).getData();
    }

    // Exercise 3
    @Test
    void verifyArgument() {

        ExternalApi mockApi = mock(ExternalApi.class);

        when(mockApi.getUser(101)).thenReturn("Sahil");

        MyService service = new MyService(mockApi);

        assertEquals("Sahil", service.fetchUser(101));

        verify(mockApi).getUser(101);
    }

    // Exercise 4
    @Test
    void verifyVoidMethod() {

        ExternalApi mockApi = mock(ExternalApi.class);

        doNothing().when(mockApi).getUser();

        MyService service = new MyService(mockApi);

        service.fetchUser();

        verify(mockApi).getUser();
    }

    // Exercise 5
    @Test
    void verifyMultipleCalls() {

        ExternalApi mockApi = mock(ExternalApi.class);

        when(mockApi.getData())
                .thenReturn("First Call")
                .thenReturn("Second Call")
                .thenReturn("Third Call");

        MyService service = new MyService(mockApi);

        String first = service.fetchMultipleData();
        String second = service.fetchMultipleData();
        String third = service.fetchMultipleData();

        assertEquals("First Call", first);
        assertEquals("Second Call", second);
        assertEquals("Third Call", third);

        verify(mockApi, times(3)).getData();
    }

    // Exercise 6
    @Test
    void verifyInteractionOrder() {

        ExternalApi mockApi = mock(ExternalApi.class);

        when(mockApi.getData()).thenReturn("Mock Data");

        MyService service = new MyService(mockApi);

        service.fetchDataWithConnection();

        InOrder order = inOrder(mockApi);

        order.verify(mockApi).connect();
        order.verify(mockApi).getData();
        order.verify(mockApi).disconnect();
    }
}
