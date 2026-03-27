package cn.zhu;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.hive.ql.io.orc.OrcInputFormat;
import org.apache.hadoop.hive.ql.io.orc.OrcStruct;
import org.apache.hadoop.hive.ql.io.orc.OrcSplit;
import org.apache.hadoop.hive.serde2.objectinspector.ObjectInspector;
import org.apache.hadoop.hive.serde2.objectinspector.StructField;
import org.apache.hadoop.hive.serde2.objectinspector.StructObjectInspector;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.mapred.Counters;
import org.apache.hadoop.mapred.Reporter;
import org.apache.hadoop.mapreduce.InputSplit;
import org.apache.hadoop.mapreduce.RecordReader;
import org.apache.hadoop.mapreduce.TaskAttemptContext;
import org.apache.hadoop.mapreduce.TaskAttemptID;
import org.apache.hadoop.mapreduce.lib.input.FileSplit;

import java.io.IOException;
import java.util.List;

public class HiveOrcDemo {
    public static void main(String[] args) throws IOException, InterruptedException {
        // 1. 初始化配置（关键：指定本地文件系统）
        Configuration conf = new Configuration();
        conf.set("fs.defaultFS", "file:///"); // 本地文件系统
        conf.set("hive.exec.orc.default.buffer.size", "4096"); // ORC 读取缓冲区

        // 2. 本地 ORC 文件路径（替换为你的文件路径）
        String localOrcPath = "./data/dn_6007_6008_0_4852bcdb-e32a-4b4c-b3f1-def9fb2bcec9_1.orc";
        Path orcFilePath = new Path(localOrcPath);

        // 3. 创建 InputSplit（模拟 Hadoop 切片，本地模式仅单个切片）
        InputSplit split = new FileSplit(
                orcFilePath,       // ORC 文件路径
                0,                 // 切片起始位置
                orcFilePath.getFileSystem(conf).getFileStatus(orcFilePath).getLen(), // 切片长度
                new String[]{}     // 主机列表（本地模式为空）
        );
        // 转换为 Hive ORC 专用的 OrcSplit
        OrcSplit orcSplit = new OrcSplit((FileSplit) split, conf);
        // 4. 创建 TaskAttemptContext（模拟 MapReduce 任务上下文）
        TaskAttemptContext context = new org.apache.hadoop.mapreduce.task.TaskAttemptContextImpl(
                conf,
                new TaskAttemptID()
        );

        // 5. 核心：通过 OrcInputFormat 获取 RecordReader
        OrcInputFormat orcInputFormat = new OrcInputFormat();
        RecordReader<NullWritable, OrcStruct> recordReader = orcInputFormat.getRecordReader(orcSplit, conf, new Reporter() {
            @Override
            public void setStatus(String s) {

            }

            @Override
            public Counters.Counter getCounter(Enum<?> anEnum) {
                return null;
            }

            @Override
            public Counters.Counter getCounter(String s, String s1) {
                return null;
            }

            @Override
            public void incrCounter(Enum<?> anEnum, long l) {

            }

            @Override
            public void incrCounter(String s, String s1, long l) {

            }

            @Override
            public org.apache.hadoop.mapred.InputSplit getInputSplit() throws UnsupportedOperationException {
                return null;
            }

            @Override
            public float getProgress() {
                return 0;
            }

            @Override
            public void progress() {

            }
        });

        // 6. 初始化 RecordReader（必须调用）
        recordReader.initialize(orcSplit, context);

        // 7. 获取 ORC 数据的 ObjectInspector（用于解析字段名和值）
        ObjectInspector inspector = orcInputFormat.getObjectInspector(conf, orcSplit);
        StructObjectInspector structInspector = (StructObjectInspector) inspector;
        List<? extends StructField> fields = structInspector.getAllStructFieldRefs();

        // 8. 循环读取数据
        System.out.println("=== ORC 文件数据 ===");
        while (recordReader.nextKeyValue()) {
            // 获取当前行的 OrcStruct（Hive 封装的 ORC 数据结构）
            OrcStruct orcStruct = recordReader.getCurrentValue();

            // 解析每一列的名称和值
            StringBuilder rowData = new StringBuilder();
            for (StructField field : fields) {
                String fieldName = field.getFieldName();
                Object fieldValue = structInspector.getStructFieldData(orcStruct, field);
                rowData.append(fieldName).append("=").append(fieldValue).append(", ");
            }

            // 打印一行数据（去除最后一个逗号）
            System.out.println(rowData.substring(0, rowData.length() - 2));
        }

        // 9. 关闭资源
        recordReader.close();


    }
}
