package com.tookitaki.rs

import org.apache.spark.sql.SparkSession

trait SparkSessionTestWrapper {
  lazy val sparkSession: SparkSession = {
    SparkSession
      .builder()
      .master("local")
      .appName("Tookitaki RS - RecA App")
      .getOrCreate()
  }
}