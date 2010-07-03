/**
 * PamlReader writes a list of sequences to a file in Paml format.
 *
 */

import java.io._
// import org.biojava.bio.alignment._
// import org.biojava.bio.symbol._
// import org.biojava.bio.seq._
import org.biojava.bio.seq.io._
import org.biojavax.bio.phylo.io.phylip._

package bio {

  /** 
   * PamlReader opens a file and parses the PAML Phylip CODON contents using 
   * an iterator.
   */
  class PamlReader(val filename: String) extends Iterator[Tuple3[String,String,String]] {
    private lazy val reader = new BufferedReader(new FileReader(filename))

    class PamlReaderException(string: String) extends Exception(string)

    object PamlListener extends PHYLIPFileListener {
      def receiveSequence(s : String) = { println(">>>>",s) }
      def setCurrentSequenceName(s : String) = { println("@@@@",s) }
      def setSitesCount(i: Int) = {}
      def setSequenceCount(i: Int) = {}
      def endFile() = {}
      def startFile() = {}
    }
    lazy val listener = PamlListener
    val x = PHYLIPFileFormat.parse(listener,reader)


    def hasNext() = true

    def next(): Tuple3[String,String,String] = {
      ("","","")
    }
  } // PamlReader

} // bio
