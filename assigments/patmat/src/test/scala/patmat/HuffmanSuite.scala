package patmat

import org.scalatest.FunSuite

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

import patmat.Huffman._

@RunWith(classOf[JUnitRunner])
class HuffmanSuite extends FunSuite {
	trait TestTrees {
    val leafLeft = Leaf('a',2)
    val leafRight = Leaf('b',3)
    val forkChars = List('a','b')
    val forkWeight = 5
    val fork1 = Fork(leafLeft, leafRight, forkChars, forkWeight)
    val fork2Right = Leaf('d', 4)
    val fork2Chars = List('a','b','d')
    val fork2Weight = 9
		val fork2 = Fork(Fork(leafLeft, leafRight, forkChars, forkWeight), fork2Right, fork2Chars, fork2Weight)
	}

  test("weight of a larger tree") {
    new TestTrees {
      assert(weight(fork1) === 5)
    }
  }


  test("chars of a larger tree") {
    new TestTrees {
      assert(chars(fork2) === List('a','b','d'))
    }
  }


  test("string2chars(\"hello, world\")") {
    assert(string2Chars("hello, world") === List('h', 'e', 'l', 'l', 'o', ',', ' ', 'w', 'o', 'r', 'l', 'd'))
  }

  test("times of char") {
    assert(times(List('a', 'b', 'a', 'c', 'a')) === List(('a', 3), ('b', 1), ('c', 1)))
  }


  test("makeOrderedLeafList for some frequency table") {
    assert(makeOrderedLeafList(List(('t', 2), ('e', 1), ('x', 3))) === List(Leaf('e',1), Leaf('t',2), Leaf('x',3)))
  }


  test("combine of some leaf list") {
    val leaflist = List(Leaf('e', 1), Leaf('t', 2), Leaf('x', 4))
    assert(combine(leaflist) === List(Fork(Leaf('e',1),Leaf('t',2),List('e', 't'),3), Leaf('x',4)))
  }

  // test("until of some leaf list") {
  //   new TestTrees {
  //     val codeTree = List(leafLeft, leafRight, fork2Right, fork2Right)
  //     val rightCodeTree = Fork(Fork(), Fork(), List(''))
  //     assert(until(singleton, combine)(codeTree) === )
  //   }
  // }


  test("decode and encode a very short text should be identity") {
    new TestTrees {
      assert(decode(fork1, encode(fork1)("ab".toList)) === "ab".toList)
    }
  }

  // test("decode a leaf") {
  //   new TestTrees {
  //    assert(decode(Leaf('a', 1), List(0)) === List('a'))
  //   }
  // }

  test("decode a fork") {
    new TestTrees {
      assert(decode(Fork(Fork(Leaf('a', 1), Leaf('c', 3), List('a', 'b'), 4), Leaf('b', 2), List('a', 'b'), 3), List(0, 1)) === List('c'))
    }
  }

  test("decode the secret string") {
    new TestTrees {
      assert(decodedSecret.mkString === "huffmanestcool")
    }
  }

  test("convert a codetable") {
    new TestTrees {
      val codeTree = Fork(
          Fork(
            Leaf('a', 1),
            Fork(Leaf('c', 3), Leaf('d', 5), List('c', 'd'), 8),
            List('a', 'c', 'd'),
            9
          ),
          Leaf('b', 2),
          List('a', 'b', 'c', 'd'),
          12
      );
      val codeTable = List(('a', List(0, 0)), ('c', List(0, 1, 0)), ('d', List(0, 1, 1)), ('b', List(1)));
      assert(convert(codeTree) === codeTable)
    }
  }

}
