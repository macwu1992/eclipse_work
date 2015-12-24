import java.lang.Thread;
import java.security.AlgorithmConstraints;

/*
 * 此程序是模拟G－S算法，利用两个线程模拟Alice&Bob之间的交互过程
 * */

class G_S_Algorithm {
	public static void main(String[] args) {
		people Alice = new people();
		people Bob = new people();
//		
		Alice.print();
		Bob.print();
	}
}

