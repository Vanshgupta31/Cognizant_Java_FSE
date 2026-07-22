// Ques  Exercise 1: Mocking Databases and Repositories
You need to test a service that interacts with a database repository.
Steps:
1. Create a mock repository using Mockito.
2. Stub the repository methods to return predefined data.
3. Write a test to verify the service logic using the mocked repository. 


public interface Repository {
        String getData();
}

public class Service {
   private Repository repository;
    public  Service(Repository repository){
        this.repository = repository;
    }
    public String processData(){
        String Data = repository.getData();

        return "Processed" + Data;
    }
}


// Test File 

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.*;

public class ServiceTest {

    @Test
    public  void testServiceWithMockRepository() {
        Repository repository = mock(Repository.class);

        when(repository.getData()).thenReturn("Rahul");

        Service service = new Service(repository);

         String result = service.processData();

         assertEquals("ProcessedRahul" ,result);



    }
}
