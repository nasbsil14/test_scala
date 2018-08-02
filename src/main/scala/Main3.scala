object Main3 extends App {
  override def main(args: Array[String]): Unit = {
    println("START")

    // puzzle1()
    // puzzle4()
    // puzzle5()
    // puzzle8()
    crossCount()

    println("END")
  }

  // 数字の回文
  def puzzle1(): Unit = {
//    val ans = (1 to 10)
//      .filter(p => p.toString == p.toString.reverse)
//      .filter(p => p.toBinaryString == p.toBinaryString.reverse)
//      .filter(p => p.toOctalString == p.toOctalString.reverse)
//    println(ans.length)

    def recursion(n: Int): Int = {
      if ((n.toString == n.toString.reverse) && (n.toBinaryString == n.toBinaryString.reverse) && (n.toOctalString == n.toOctalString.reverse)) {
        println(n.toBinaryString)
        println(n.toOctalString)
        n
      } else {
        recursion(n + 1)
      }
    }
    println(recursion(10))
  }

  // 棒の切り分け
  def puzzle4(): Unit = {
    def recursion(m: Int, n: Int, current: Int): Int = {
      if (current >= n) {
        0
      } else if (current < m) {
        1 + recursion(m, n, current * 2)
      } else {
        // current=4になってからここ
        1 + recursion(m, n, current + m)
      }
    }

    // 1本の棒を3箇所づつ計20回切る
    println(recursion(3, 20, 1))
    println(recursion(5, 100, 1))
  }

  // 硬貨の組み合わせ
  def puzzle5(): Unit = {
    for {
      i <- (0 to 2)
      ii <- (0 to 10)
      iii <- (0 to 15)
      iiii <- (0 to 15)
    } {
      if (((i + ii + iii + iiii) <= 15) &&
        (((500 * i) + (100 * ii) + (50 * iii) + (10 * iiii)) == 1000)) {
        println("500:%s, 100:%s, 50:%s, 10:%s".format(i,ii,iii,iiii))
      }
    }

    val coins:Seq[(Int, Int)] = Seq((500, 0), (100, 0), (50, 0), (10, 0))
    val max_coins = 15
    val target = 1000

    def recursion(seq: Seq[(Int, Int)], index: Int, cnt: Int): Int = {

      if (index >= coins.size || seq.map(_._2).sum > max_coins || seq(index)._2 > max_coins) {
        cnt
      } else if (seq.map(p => p._1 * p._2).sum >= target) {
        println("500:%s, 100:%s, 50:%s, 10:%s".format(seq(0)._2,seq(1)._2,seq(2)._2,seq(3)._2))
        // 金額に達したのでこれ以上自身を増やす必要無し
        cnt + 1
      } else {
//        // 自身を増加
//        recursion(seq.map(p => if (p == seq(index)) seq(index).copy(_2 = seq(index)._2 + 1) else p), index, cnt)
        // 自身の増加結果算出後、桁上げされるイメージ
//        recursion(
//          seq,
//          index + 1,
//          recursion(seq.map(p => if (p == seq(index)) seq(index).copy(_2 = seq(index)._2 + 1) else p), index, cnt)
//        )
        recursion(
          seq.map(p => if (p == seq(index)) seq(index).copy(_2 = seq(index)._2 + 1) else p),
          index,
          recursion(seq, index + 1, cnt)
        )
//        // 自身の増加結果算出後、桁上げされるパターン
//        recursion(
//          seq,
//          index + 1,
//          recursion(seq.map(p => if (p == seq(index)) seq(index).copy(_2 = seq(index)._2 + 1) else p), index, cnt)
//        )
      }
    }

    println("**************")
    println(recursion(coins, 0, 0))
  }
  
  // マス移動
  def puzzle8(): Unit = {
    // 前後左右
    val direction = List((1,0), (-1,0), (0,1), (0,-1))
    def move(moveList: List[(Int, Int)]): Int = {
      if (12 < moveList.size) {
        1
      } else {
        var cnt = 0
        direction.foreach(d => {
          val next: (Int, Int) = (moveList.last._1 + d._1, moveList.last._2 + d._2)
          if (!moveList.contains(next)) {
            cnt += move(moveList :+ next)
          }
        })
        cnt
      }
    }

    println(move(List((0, 0))))

//    def move(moveList: List[(Int, Int)], cnt: Int): Int = {
//      if (12 < moveList.size) {
////        println(moveList)
//        cnt + 1
//      } else {
//        direction
//          .filter(d => !moveList.contains((moveList.last._1 + d._1, moveList.last._2 + d._2)))
//          .map(d => (moveList.last._1 + d._1, moveList.last._2 + d._2))
//          .map(d => move(moveList :+ d, cnt))
//          .sum
//      }
//    }
//
//    println(move(List((0, 0)), 0))
  }

  def crossCount(): Unit = {
    val word = List("A","B","C","D","E","F","G")

    def calc(list: List[String]): Int = {
      if (6 <= list.size) {
        println(list)
        1
      } else if (list.isEmpty) {
        word.map(s => calc(list :+ s)).sum
      } else {
        val index = word.zipWithIndex.filter(_._1 == list.last).head._2
        word.drop(index).filter(!list.contains(_)).map(s => calc(list :+ s)).sum
      }
    }

    println(calc(List.empty))
  }
}
