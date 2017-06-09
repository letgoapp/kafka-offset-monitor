package com.quantifind.kafka.offsetapp

object DatabaseArguments {
  def parseArguments(args: String): DatabaseConfig = {


    var url = ""
    var username = ""
    var password = ""
    var driver = "com.mysql.cj.jdbc.Driver"


    val argsMap: Map[String, String] = args.split(",").map(_.split("=", 2)).filter(_.length > 1).map(arg => {
      arg(0) -> arg(1)
    }).toMap

    argsMap.get("datasource.url").foreach(url = _)
    argsMap.get("datasource.username").foreach(username = _)
    argsMap.get("datasource.password").foreach(password = _)
    argsMap.get("datasource.driver-class-name").foreach(driver = _)

    DatabaseConfig(url, username, password, driver)
  }
}

case class DatabaseConfig(url: String, user: String, password: String, driver: String)
