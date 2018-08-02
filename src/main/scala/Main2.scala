import java.nio.file.{Files, Paths}

import org.apache.pdfbox.pdmodel.PDDocument
import org.apache.pdfbox.text.PDFTextStripper

object Main2 extends App {
  override def main(args: Array[String]): Unit = {

    println("START")

    val pdDoc: PDDocument = PDDocument.load(Files.newInputStream(Paths.get("/Users/work/sample.pdf")))
    val stripper: PDFTextStripper = new PDFTextStripper
//    val writer = Files.newBufferedWriter(Paths.get("/Users/work/sample_pdf.txt"))
    try {
      stripper.setStartPage(1)
      stripper.setEndPage(2)
      println(stripper.getText(pdDoc))
//      stripper.writeText(pdDoc, writer)
//      writer.flush()
    } finally {
//      writer.close()
      pdDoc.close()
    }
    println("END")
  }
}
