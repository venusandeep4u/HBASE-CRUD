package coprocessor;



import java.io.IOException;
import java.util.List;
import org.apache.hadoop.hbase.KeyValue;
import org.apache.hadoop.hbase.client.Get;
import org.apache.hadoop.hbase.coprocessor.BaseRegionObserver;
import org.apache.hadoop.hbase.coprocessor.ObserverContext;

// Sample access-control coprocessor. It utilizes RegionObserver
// and intercept preXXX() method to check user privilege for the given table
// and column family.
public class AccessControlCoprocessor extends BaseRegionObserver {
  public void postGet(final ObserverContext<RegionCoprocessorEnvironment> c,
final Get get, final List<KeyValue> result) throws IOException
      throws IOException {

	  System.out.println("Value: ");
    // check permissions..
    if (!permissionGranted())  {
        throw new AccessDeniedException("User is not allowed to access.");
    }
  }

  // override prePut(), preDelete(), etc.
}