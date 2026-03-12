package cn.zhu;

//import org.apache.hadoop.conf.Configuration;
//import org.apache.hadoop.fs.Path;
//import org.apache.hadoop.io.WritableComparable;
//import org.apache.orc.OrcFile;
//import org.apache.orc.Reader;
//import org.apache.orc.RecordReader;
//import org.apache.orc.mapred.OrcStruct;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.orc.OrcFile;
import org.apache.orc.Reader;
import org.apache.orc.RecordReader;
import org.apache.hadoop.hive.ql.exec.vector.VectorizedRowBatch;

import java.io.IOException;

public class OrcReadDemo2 {
    public static void main(String[] args) {
        Configuration conf = new Configuration();
        try {
            Reader reader = OrcFile.createReader(new Path(""), OrcFile.readerOptions(conf));
            RecordReader rows = reader.rows();
            VectorizedRowBatch batch = reader.getSchema().createRowBatch();
            while (rows.nextBatch(batch)){

            }
            rows.close();


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
