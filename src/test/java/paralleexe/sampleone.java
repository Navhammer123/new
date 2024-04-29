package paralleexe;

import org.testng.annotations.Test;

public class sampleone {
  @Test(invocationCount =10, threadPoolSize = 2, timeOut = 2000 )
  public void f() {
	  
	  long id = Thread.currentThread().getId();
	  
	  System.out.println("new id" +id);
  }
}
