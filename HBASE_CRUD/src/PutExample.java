import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.CoprocessorEnvironment;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.client.HTable;
import org.apache.hadoop.hbase.client.HTablePool;
import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.coprocessor.BaseRegionObserver;
import org.apache.hadoop.hbase.coprocessor.ObserverContext;
import org.apache.hadoop.hbase.coprocessor.RegionCoprocessorEnvironment;
import org.apache.hadoop.hbase.regionserver.wal.WALEdit;
import org.apache.hadoop.hbase.util.Bytes;
import java.io.IOException;

@SuppressWarnings("deprecation")
public class PutExample  {
	   
	
	
	
	public static void main(String[] args) throws IOException {
		
		//create 'mytable', 'cf1'
		
	 

		
		Configuration conf = HBaseConfiguration.create();
		HTable table = new HTable(conf, "EMPLOYEE");
		Put put = new Put(Bytes.toBytes("123456"));
		put.add(Bytes.toBytes("OFFICIAL"), Bytes.toBytes("cl1"),
				Bytes.toBytes("val12345"));

		table.put(put);
	
		table.close();
	

		}
	}

