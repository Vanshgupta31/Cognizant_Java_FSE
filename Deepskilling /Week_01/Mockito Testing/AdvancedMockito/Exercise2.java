// Exercise 2: Mocking External Services (RESTful APIs)
You need to test a service that calls an external RESTful API.
Steps:
1. Create a mock REST client using Mockito.
2. Stub the REST client methods to return predefined responses.
3. Write a test to verify the service logic using the mocked REST client.

public interface RestClient {
    String getResponse();
}

public class ApiService {

  private   RestClient restClient;
    public  ApiService(RestClient restClient){
        this.restClient =restClient;
    }

    public String fetchData(){
        String response = restClient.getResponse();

        return  "Processed " + response;
    }

}


// Test 

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;



public class ApiServiceTest {
    @Test
    public void testApiService(){
        RestClient restClient = mock(RestClient.class);

        when(restClient.getResponse()).thenReturn("Mock Data");

        ApiService apiService =new ApiService(restClient);

        String result = apiService.fetchData();

        assertEquals("Processed Mock Data", result);
    }
}
