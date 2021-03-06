package com.manning.fia.c06;

import org.apache.flink.api.java.tuple.Tuple1;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;

public class BroadcastPartitioner {
	public static void main(String[] args) throws Exception{
      StreamExecutionEnvironment execEnv =
            StreamExecutionEnvironment.getExecutionEnvironment();
      execEnv.setParallelism(2);      
      DataStream<Tuple1<Integer>> source = execEnv.addSource(new RichParallelTuple1EventSource(4));      
      source.broadcast().print().setParallelism(4);
		execEnv.execute();
	}
}
