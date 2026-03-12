package cn.zhu;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.hive.ql.exec.vector.TimestampColumnVector;
import org.apache.hadoop.hive.ql.exec.vector.VectorizedRowBatch;
import org.apache.orc.OrcFile;
import org.apache.orc.Reader;
import org.apache.orc.RecordReader;
import org.apache.orc.TypeDescription;

import java.io.IOException;

/**
 * ORC文件读取示例
 */
public class OrcReadDemo {

    public static void main(String[] args) {
        String inputPath = "./data/dn_6007_6008_0_4852bcdb-e32a-4b4c-b3f1-def9fb2bcec9_1.orc";

        Configuration conf = new Configuration();
        conf.set("useUTCTimestamp", "true");
        conf.set("fs.defaultFS", "file:///");

        try {
            readOrcFile(conf, inputPath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void readOrcFile(Configuration conf, String inputPath) throws IOException {
        OrcFile.ReaderOptions readerOptions = OrcFile.readerOptions(conf);
        readerOptions.useUTCTimestamp(true);
        // 1. 创建Reader
        Reader reader = OrcFile.createReader(
                new Path(inputPath),
                readerOptions
        );

        // 2. 获取文件信息
        System.out.println("ORC文件信息:");
        System.out.println("  行数: " + reader.getNumberOfRows());
        System.out.println("  schema: " + reader.getSchema());
        System.out.println("  条带数: " + reader.getStripes().size());

        // 3. 创建RecordReader
        try (RecordReader rows = reader.rows()) {
            // 4. 获取schema并创建行批处理
            TypeDescription schema = reader.getSchema();
            VectorizedRowBatch batch = schema.createRowBatch();

            System.out.println("\n读取数据内容:");
            System.out.println("----------------------------------------");

            // 5. 逐批读取数据
            int totalRows = 0;
            while (rows.nextBatch(batch)) {
                // 处理当前批次的数据
                for (int r = 0; r < batch.size; r++) {
                    // 读取id
                    TimestampColumnVector t = (TimestampColumnVector) batch.cols[0];
//                    t.setIsUTC(true);
                    long timestampUTC = t.getTime(0);
                    int n = t.getNanos(0);


                    System.out.println(timestampUTC);
                    System.out.println(n);
                    System.out.println(t.asScratchTimestamp(0).toString());
                    totalRows++;
                }
                batch.reset();
            }

            System.out.println("----------------------------------------");
            System.out.println("总计读取行数: " + totalRows);
        }
    }
}