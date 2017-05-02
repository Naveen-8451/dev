package dev;

import java.io.IOException;

import java.text.ParseException;

import java.util.Date;

import org.apache.hadoop.conf.Configuration;

import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.FloatWritable;
import org.apache.hadoop.io.IntWritable;

import org.apache.hadoop.io.Text;

import org.apache.hadoop.mapreduce.Job;

import org.apache.hadoop.mapreduce.Mapper;

import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.Mapper.Context;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;

import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

public class DataLoad {

	// Map function to map transformation

	public static class TokenizerMapper extends Mapper<Object, Text, Text, IntWritable> {
		
		private Text DRGDefinition = new Text();
		private int ProviderId;
		
		private Text ProviderName = new Text();
		private Text ProviderStreetAddress = new Text();
		private Text ProviderCity = new Text();
		private Text ProviderState = new Text();
		private Text HospitalReferralRegionDescription = new Text();
		private int TotalDischarges;
		private float AverageCoveredCharges;
		private float AverageTotalPayments;
		private float AverageMedicarePayments;
		private int ProviderZipCode;
		
		public void map(Object key, Text value, Context context) throws IOException, InterruptedException {
			
			String line = value.toString();
			String[] splits = line.split(",");
			
			
			DRGDefinition.set(splits[0]);
			ProviderId = new Integer(splits[1]);
			ProviderName.set(splits[2]);
			ProviderStreetAddress.set(splits[3]);
			ProviderCity.set(splits[4]);
			ProviderState.set(splits[5]);
			HospitalReferralRegionDescription.set(splits[6]);
			
			TotalDischarges = new Integer(splits[7]);
			AverageCoveredCharges = new Float(splits[8]);
			AverageTotalPayments = new Float(splits[9]);
			AverageMedicarePayments = new Float(splits[10]);
			ProviderZipCode = new Integer(splits[11]);	
			
			String keys = DRGDefinition.toString() +","+ ProviderName.toString() +","+ ProviderStreetAddress.toString() +","+ ProviderCity.toString() +","+ ProviderState.toString() +","+ HospitalReferralRegionDescription.toString();
			int a = ProviderId,TotalDischarges,AverageCoveredCharges ,AverageTotalPayments ,AverageMedicarePayments,ProviderZipCode;
			context.write(new Text(keys), new IntWritable(a));
			System.out.println(keys);
		}

	}

	// reducer phase funtion to perform Action on mapper out put Key Value
	// pairs.

	public static class IntSumReducer extends Reducer<Text, IntWritable, Text, IntWritable> {
		private IntWritable result = new IntWritable();
		public void reduce(Text key, Iterable<IntWritable> values, Context context)
				throws IOException, InterruptedException {
			
			int sum = 0;

			for (IntWritable val : values) {

				sum += val.get();

			}

			result.set(sum);

			context.write(key, result);

		}
	}

	public static void main(String[] args) throws Exception {

		Configuration conf = new Configuration();
		Job job = Job.getInstance(conf,"DataLoad");
		job.setJarByClass(DataLoad.class);
		job.setMapperClass(TokenizerMapper.class);
		job.setCombinerClass(IntSumReducer.class);
		job.setReducerClass(IntSumReducer.class);
		job.setOutputKeyClass(Text.class);
		job.setOutputValueClass(IntWritable.class);
		FileInputFormat.addInputPath(job, new Path(args[0]));
		FileOutputFormat.setOutputPath(job, new Path(args[1]));
		System.exit(job.waitForCompletion(true) ? 0 : 1);

	}
}