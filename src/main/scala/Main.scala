import java.io.BufferedWriter
import java.nio.file._
import java.util.stream.Collectors

import scala.collection.JavaConverters._

object Main extends App {
  override def main(args: Array[String]): Unit = {
//    val linesQ1 = Files.newBufferedReader(Paths.get("/Users/work/test_q1.csv")).lines().collect(Collectors.toList()).asScala
//    val linesQ3 = Files.newBufferedReader(Paths.get("/Users/work/test_q3.csv")).lines().collect(Collectors.toList()).asScala
//
//    val writer = Files.newBufferedWriter(Paths.get("/Users/work/test.csv"))
//    List(linesQ1, linesQ3).flatten.distinct.foreach(s =>
//      writer.write(s + "," + "\n")
//    )

//    val lines = Files.newBufferedReader(Paths.get("/Users/work/testtest.csv")).lines().collect(Collectors.toList()).asScala
//
//    var writer = Files.newBufferedWriter(Paths.get("/Users/work/test.txt"))
//    List(lines).flatten.distinct.foreach(s =>
//      writer.write(s + ",")
//    )

//    val lines2 = Files.newBufferedReader(Paths.get("/Users/work/test_2.txt")).readLine().split(",")
//    var writer: BufferedWriter = Files.newBufferedWriter(Paths.get("/Users/work/test_3.txt"))
//    lines2.zipWithIndex.foreach {
//      case(s: String, i: Int) => {
//        if (0 < i && i % 1000 == 0) {
//          writer.flush()
//          writer = Files.newBufferedWriter(Paths.get("/Users/work/test" + (i / 1000) + ".txt"))
//        }
//        writer.write(s + ",")
//      }
//    }

//    val lines3 = Files.newBufferedReader(Paths.get("/Users/work/test10.txt")).readLine().split(",")
//    println(lines3.size)

//    val writer = Files.newBufferedWriter(Paths.get("/Users/work/test2.txt"))
//    1000000000 to 1080000000 foreach(num => {
//      //writer.write("," + num)
//      writer.write("," + num + "\n")
//    })

//    writer.flush()
  }
}
