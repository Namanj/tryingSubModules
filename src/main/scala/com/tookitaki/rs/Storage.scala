package com.tookitaki.rs

import org.apache.spark.sql.{Encoder, SparkSession, Dataset}

/**
  * Storage defines all input and output logic. How and where tables and files
  * should be read and saved
  *
  * @param sparkSession - A unified entry point for manipulating data with Spark
  */
class Storage(sparkSession: SparkSession) extends entities {

  import sparkSession.implicits._

  private def readCsv[T: Encoder](location: String) = {
    sparkSession
      .read
      .option("header", "true")
      .option("inferSchema", "true")
      .option("delimiter", ";")
      .csv(location)
      .as[T]
  }

  override def chatLogs: Dataset[ChatLog] = readCsv[ChatLog]("s3://someLocation")

  override def writeToParquet(ds: Dataset[_], location: String): Unit = {
    ds
      .write
      .parquet(location)
  }
}
