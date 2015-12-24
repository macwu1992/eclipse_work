import java.util.Random;

class people implements Runnable {
	private static final int N = 4;
	//结果矩阵
	public int[][] resultMatrix = {{0}};
	//优先列表
	private int[][] priorityMatrix = {{1, 2, 3, 4}, 
									  {1, 2, 3, 4}, 
									  {1, 2, 3, 4},
									  {1, 2, 3, 4}
									  };
	
	people(){
//		priorityInit();
	}
	
	public void sendBit(){}
	public void run(){
		
	}
	
//	private void priorityInit(){
//		for(int i = 0; i < N; i++){
//			for(int j = 0; j < N; j++){
//				swap(priorityMatrix[i][j], priorityMatrix[i][ran]);
//			}
//		}
//	}
	
	private void swap(int x, int y){
		int temp;
		temp = x;
		x = y;
		y = temp;
	}
	
	private int random(){
		int[] intRet = new int[4]; 
        int intRd = 0; //存放随机数
        int count = 0; //记录生成的随机数个数
        int flag = 0; //是否已经生成过标志
        int temp;
//        while(count<4){
//             Random rdm = new Random(System.currentTimeMillis());
//             intRd = Math.abs(rdm.nextInt())%4;
//             for(int i=0;i<count;i++){
//                 if(intRet[i]==intRd){
//                     flag = 1;
//                     break;
//                 }else{
//                     flag = 0;
//                 }
//             }
//             
//             if(flag==0){
//                 intRet[count] = intRd;
//                 count++;
//         		 return intRd;
//             }
//        }
        Random rdm = new Random(System.currentTimeMillis());
        temp = Math.abs(rdm.nextInt())%4;
        if(intRd != temp) intRd = temp;
		return intRd;
	}
	
	//测试，打印矩阵
	public void print(){
		for(int i = 0; i < N; i++){
			for(int j = 0; j < N; j++){
				System.out.print(priorityMatrix[i][j] + " ");
			}
			System.out.println();
		}
	}
}
