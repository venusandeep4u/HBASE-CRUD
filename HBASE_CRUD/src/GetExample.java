import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.client.Get;
import org.apache.hadoop.hbase.client.HTable;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.util.Bytes;

public class GetExample {
	public static void main(String[] args) throws IOException {

		Configuration conf = HBaseConfiguration.create();
		HTable table = new HTable(conf, "PAGE_INDEX");
		
		Get get = new Get(Bytes.toBytes("AB"));
		get.addColumn(Bytes.toBytes("CF1"), Bytes.toBytes("Word"));
		
		Result result = table.get(get);
		
		byte[] val = result.getValue(Bytes.toBytes("CF1"),
				Bytes.toBytes("Word"));
		System.out.println("Value: " + Bytes.toString(val));

		table.close();
		
	}
}